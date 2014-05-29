
public class ListNode {
	
	int value;
	ListNode next = null;
	
	public ListNode(int value, ListNode next) {
		this.value = value;
		this.next = next;
	}
	
	public int getValue() {
		return value;
	}
	
	public ListNode getNext() {
		return next;
	}
	
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public static ListNode doTheTrick(ListNode head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		ListNode newHead = head.getNext();
		newHead = doTheTrick(newHead);
		
		head.setNext(newHead.getNext());
		newHead.setNext(head);
		return newHead;
	}
	
	public static void printList(ListNode head) {
		System.out.print("List: ");
		ListNode currNode = head;
		while(currNode != null) {
			System.out.print(currNode.getValue() + "  ");
			currNode = currNode.getNext();
		}
		System.out.println();
	}
		
	static public void main(String[] argv) {
		ListNode head = new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, null))));
		printList(head);
		ListNode newHead = doTheTrick(head);
		printList(newHead);
		
	}
}
