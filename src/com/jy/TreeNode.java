package com.jy;

/**
 * 节点类，这里采用二叉链表的方式来表示二叉树
 * 
 * @author jiangyu
 *
 */
public class TreeNode {
	public int mValue;
	public TreeNode mLeft;
	public TreeNode mRight;

	public TreeNode(int mValue, TreeNode mLeft, TreeNode mRight) {
		this.mValue = mValue;
		this.mLeft = mLeft;
		this.mRight = mRight;
	}

	public TreeNode() {
		super();
	}

}
