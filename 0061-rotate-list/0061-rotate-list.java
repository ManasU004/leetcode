class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases: empty list, single node, or no rotation
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Find length and original tail node
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. Reduce k using modulo
        k = k % length;
        if (k == 0) {
            return head;
        }

        // 3. Connect tail to head to form a cycle
        tail.next = head;

        // 4. Find the new tail: (length - k) steps from old head
        int stepsToNewTail = length - k;
        ListNode newTail = tail;
        while (stepsToNewTail > 0) {
            newTail = newTail.next;
            stepsToNewTail--;
        }

        // 5. Break the cycle and establish new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}