package com.jy;

public class Main {

	public static void main(String[] args) {
		// 构建二叉树
		TreeNode node1 = new TreeNode(4, null, null);
		TreeNode node2 = new TreeNode(8, null, null);
		TreeNode node3 = new TreeNode(12, null, null);
		TreeNode node4 = new TreeNode(16, null, null);
		TreeNode node5 = new TreeNode(6, node1, node2);
		TreeNode node6 = new TreeNode(14, node3, node4);
		TreeNode root = new TreeNode(10, node5, node6);

		System.out.print("中序遍历树:");
		midOrder(root);

		System.out.println();

		System.out.println("============树转双向链表============");
		System.out.print("正向遍历双向链表:");
		TreeNode treeNode = convert(root);
		while (treeNode.mRight != null) {
			System.out.print(treeNode.mValue + "->");
			treeNode = treeNode.mRight;
		}
		System.out.println(treeNode.mValue);

		System.out.print("反向遍历双向链表:");
		while (treeNode.mLeft != null) {
			System.out.print(treeNode.mValue + "->");
			treeNode = treeNode.mLeft;
		}
		System.out.println(treeNode.mValue);

	}

	/**
	 * 转换树为有序的双向链表
	 * 
	 * @param root
	 *            待转换树的根节点
	 * @return 转换成的链表的头结点
	 */
	public static TreeNode convert(TreeNode root) {
		// 转换后双向链表的尾节点
		// 这里用java中的数组来替代c++中的指针
		TreeNode[] pLastNode = new TreeNode[1];
		convertNodeRecursively(root, pLastNode);
		// 反向遍历获取头节点
		TreeNode head = pLastNode[0];
		while (head != null && head.mLeft != null)
			head = head.mLeft;
		return head;

	}

	/**
	 * 递归转换树为有序双向链表
	 * 
	 * @param root
	 *            待转换的树
	 * @param pLastNode
	 *            转换成的链表的尾节点
	 */
	public static void convertNodeRecursively(TreeNode root, TreeNode[] pLastNode) {
		if (root == null)
			return;

		// 先递归左子树
		if (root.mLeft != null)
			convertNodeRecursively(root.mLeft, pLastNode);

		root.mLeft = pLastNode[0];
		if (pLastNode[0] != null) // 当是最左边的叶子节点4时需要检查
			pLastNode[0].mRight = root;
		// 变更尾节点
		pLastNode[0] = root;

		// 递归右子树
		if (root.mRight != null)
			convertNodeRecursively(root.mRight, pLastNode);
	}

	/**
	 * 中序遍历树
	 * 
	 * @param root
	 *            待遍历树的根节点
	 */
	public static void midOrder(TreeNode root) {
		if (root != null) {
			if (root.mLeft != null)
				midOrder(root.mLeft);
			System.out.print(root.mValue + " ");
			if (root.mRight != null)
				midOrder(root.mRight);
		}
	}

}
