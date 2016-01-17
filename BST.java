/**
A Binary Tree is a data structure in which each node points to two other nodes, referred 
to as its left child and its right child. The Binary Search Tree is like this, but it 
keeps itself organized/sorted appropriately


@author Kevin Chow
@version 1.15.16
*/
public class BST <E extends Comparable>
{

	private BinaryTree<E> root;
	
	/**
	Constructor
	@param E v the item to start as the root of the BST
	*/
	public BST(E v)
	{
		root = new BinaryTree<E>(v);
	}
	
	/**
	Return false if already in there (no dupilicates), returns true if added
	@param E v the item to be added
	@return boolean whether or not the item was added 
	*/
	public boolean add(E v)
	{
		return add(v, root);
	}
	
	/**
	Helper method to Add. 
	@param E v the item to be added
	@param BinaryTree<E> root the root of the tree
	*/
	private boolean add(E v, BinaryTree<E> root)
	{
		//immediately return false if two items are the same. May cut down on runtime
		if(v.equals(root.value()))
		{
			return false;
		}
		
		
		if(v.compareTo(root.value()) < 0)
		{
			if(root.left() ==  null)
			{
				BinaryTree<E> newTree = new BinaryTree<E>(v);
				root.setLeft(newTree);
				return true;
			}
			
			return add(v, root.left());

		}
		
		else
		{
			if(root.right() ==  null)
			{
				BinaryTree<E> newTree = new BinaryTree<E>(v);
				root.setRight(newTree);
				return true;
			}
			return add(v, root.right());
		}
	}
	
	/**
	Goes through and finds the object, including all the pointers that is connected
	@param E v the item looking for
	@return BinaryTree<E> the BT that the item is 
	*/
	public BinaryTree<E> find(E v)
	{
		return find(v, root);
	}
	
	/**
	Helper method to Find. 
	@param E v the item to be found
	@param BinaryTree<E> root the root of the tree
	*/
	private BinaryTree<E> find(E v, BinaryTree<E> root)
	{
		if(v.equals(root.value()))
		{
			return root;
		}
		
		else if(v.compareTo(root.value()) < 0)
		{	
			return find(v, root.left());
		}
		
		else 
		{
			return find(v,root.right());
		}
						
	}
	
	/** Optional
	public boolean remove(E v)
	{
	}
	*/
	
	/**
	To String Function
	@return String string representation of the binary tree
	*/
	public String toString()
	{
		return root.toString();
	}

	public static void main(String[] args)
	{
		BST<Integer> tree = new BST<Integer>(34);
		tree.add(32);
		System.out.println(tree);
		tree.add(3);
		System.out.println(tree);
		tree.add(324);
		System.out.println(tree);
		tree.add(6);
		System.out.println(tree);
		tree.add(9);
		System.out.println(tree);
		tree.add(15);
		System.out.println(tree);
		tree.add(30);
		System.out.println(tree);
		tree.add(941);
		System.out.println(tree);
		tree.add(66);
		System.out.println(tree);
		tree.add(33);
		System.out.println(tree);
		
		System.out.println(tree.find(3));
		
		/**
		Testing Graveyard
		*/
		
		


		
	}
	
	
}
