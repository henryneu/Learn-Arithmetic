package neu.yimi.cn;

import java.util.Random;

/**
 * @author neuHenry
 */
public class AddNumWithLink {
	public static void main(String[] args) {

		Random random = new Random(10);
		// 初始化两个链表
		Node header1 = null;
		for (int i = 0; i < 7; i++) {
			Node node = new Node(random.nextInt(10));
			node.next = header1; // 这里采用头插法
			header1 = node;
		}
		// 输出链表1的节点值
		print(header1);
		Node header2 = null;
		for (int i = 0; i < 8; i++) {
			Node node = new Node(random.nextInt(10));
			node.next = header2;
			header2 = node;
		}
		// 输出链表2的节点值
		print(header2);
		Node result = null;
		result = add(header1, header2);
		// 输出求和后新链表的节点值
		print(result.next);
	}

	/**
	 * 打印输出链表
	 * @param node 链表的头结点
	 */
	public static void print(Node node) {
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
	/**
	 * 两个链表相加
	 * @param link1 链表1的头结点
	 * @param link2 链表2的头结点
	 * @return  两链表相加后所得新链表的头结点
	 */
	public static Node add(Node link1, Node link2) {
		Node sum = new Node();  // 所求新链表的头结点
		Node pTail = sum;
		Node p1 = link1, p2 = link2;
		Node cur;
		int carry = 0;
		int temp;
		while (p1 != null && p2 != null) {
			temp = p1.value + p2.value + carry;
			carry = temp / 10;  // 进位值
			temp = temp % 10;  // 所求新的节点值
			cur = new Node(temp);
			pTail.next = cur; // 这里使用尾插法
			pTail = cur;
			// 处理下一位
			p1 = p1.next;
			p2 = p2.next;
		}

		// 处理长度较长的链表，将较长的链表添加到新链表中
		Node p = (p1 != null) ? p1 : p2;
		while (p != null) {
			temp = p.value + carry;
			carry = temp / 10;
			temp = temp % 10;
			cur = new Node(temp);
			pTail.next = cur;
			pTail = cur;

			p = p.next;
		}

		// 处理可能存在的进位
		if (carry != 0) {
			cur = new Node(carry);
			pTail.next = cur;
			pTail = cur;
		}
		return sum;
	}
}
