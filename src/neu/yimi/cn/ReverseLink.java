package neu.yimi.cn;

import java.util.Random;
import java.util.Scanner;

public class ReverseLink {
	public static void main(String[] args) {
		int m, n;
		Random random = new Random(100);
		// 初始化一个单链表
		Node head = new Node();
		Node pre = head;
		for (int i = 0; i < 10; i++) {
			Node node = new Node(random.nextInt(100));
			pre.next = node;
			pre = node;
		}
		System.out.print("原链表：");
		print(head.next);
		System.out.println("翻转链表的范围m和n：");
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		System.out.println("m = " + m + " n = " + n);
		// 翻转链表
		reverse(head, m, n);
		System.out.print("翻转之后的链表：");
		print(head.next);
	}

	/**
	 * 打印输出链表的结点值
	 */
	public static void print(Node head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	/**
	 * 翻转链表的从结点m到结点n的部分
	 * 
	 * @param head 连标点额头结点
	 * @param m 翻转的开始位置
	 * @param n 翻转的结束位置
	 * @return 翻转后的新链表
	 */
	public static void reverse(Node head, int from, int to) {
		Node cur = head.next;
		int i;
		for (i = 0; i < from - 1; i++) {
			head = cur;
			cur = cur.next;
		}
		Node pre = cur;
		cur = cur.next;
		to--;
		Node next;
		for (; i < to; i++) {
			next = cur.next;
			cur.next = head.next;
			head.next = cur;
			pre.next = next;
			cur = next;
		}
	}
}
