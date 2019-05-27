package yahootest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ImmutableQueueTest {

    @Test
    @DisplayName("Queueに要素を追加しても、元のQueue自体には変更がないことを確認。(空のQueueのケース)")
    void test_enQueue_01() {
        Queue<String> testTarget = new ImmutableQueue<>();
        testTarget.enQueue("001");

        assertTrue(testTarget.isEmpty());
    }

    @Test
    @DisplayName("Queueに要素を追加しても、元のQueue自体には変更がないことを確認。(値を持ったQueueのケース)")
    void test_enQueue_02() {
        List<String> list = List.of("001", "002", "003");
        Queue<String> testTarget = new ImmutableQueue<>(list);
        testTarget.enQueue("004");

        assertEquals(list.size(), testTarget.size());
    }

    @Test
    @DisplayName("Queueに要素を追加した場合、新しいQueueオブジェクトにその値が追加されていることを確認。(空のQueueのケース)")
    void test_enQueue_03() {
        Queue<String> testTarget = new ImmutableQueue<>();
        Queue<String> newQueue = testTarget.enQueue("001");

        assertEquals(1, newQueue.size());
        assertEquals(newQueue.head(), "001");
    }

    @Test
    @DisplayName("Queueに要素を追加した場合、新しいQueueオブジェクトにその値が追加されていることを確認。(値を持ったQueueのケース)")
    void test_enQueue_04() {
        List<String> list = List.of("001", "002", "003");
        Queue<String> testTarget = new ImmutableQueue<>(list);
        Queue<String> newQueue = testTarget.enQueue("004");

        assertEquals(4, newQueue.size());
        assertEquals(newQueue.head(), "001");
    }

    @Test
    @DisplayName("Queueから要素を削除しても、元のQueue自体には変更がないことを確認。(空のQueueのケース)")
    void test_deQueue_01() {
        Queue<String> testTarget = new ImmutableQueue<>();
        testTarget.deQueue();

        assertTrue(testTarget.isEmpty());
    }

    @Test
    @DisplayName("Queueから要素を削除しても、元のQueue自体には変更がないことを確認。(値を持ったQueueのケース)")
    void test_deQueue_02() {
        List<String> list = List.of("001", "002", "003");
        Queue<String> testTarget = new ImmutableQueue<>(list);
        testTarget.deQueue();

        assertEquals(3, testTarget.size());
    }

    @Test
    @DisplayName("Queueから要素を削除した場合、新しいQueueオブジェクトからその値が削除されていることを確認。")
    void test_deQueue_03() {
        List<String> list = List.of("001", "002", "003");
        Queue<String> testTarget = new ImmutableQueue<>(list);
        Queue<String> newQueue = testTarget.deQueue();

        assertEquals(2, newQueue.size());
        assertEquals(newQueue.head(), "002");
    }
}
