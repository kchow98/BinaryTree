/**
This is my Post-Order Iterator class. This allows the Binary Tree created in the Binary 
Tree class to be iterated.

Special Thanks to Anish Seth for helping me.

@author Kevin Chow
@version 12.24.15
*/

import java.util.NoSuchElementException;
import java.util.Iterator;
public class PostOrderIterator<E> implements Iterator<E>
{
	private Queue<E> queueofnodes;
	
	/**
	Constructor of PostOrder Iterator
	@param BinaryTree<E> tree to be iterated
	*/
	public PostOrderIterator(BinaryTree<E> tree)
	{
		queueofnodes = new LinkedList<E>();
		fill(tree);
	}
	
	/**
	Fills queueofnodes with values
	@param BinaryTree<E> tree that is PostOrder iterated.
	*/
	private void fill(BinaryTree<E> tree)
	{
		if(tree.isLeaf() == true)
		{
			queueofnodes.offer(tree.value());
		}
		else
		{
			if(tree.left() != null)
			{
				fill(tree.left());
			}
						
			if(tree.right() != null)
			{
				fill(tree.right());
			}
	
			queueofnodes.offer(tree.value());

		}
	}
	
	/**
	Returns true if the iteration has more elements.
	@return boolean true if there is a next item, false if there is not
	*/	
	public boolean hasNext()
	{
		if (queueofnodes.isEmpty())
		{
			return false;
		}
		return true;
		
	}
	/**
	Returns the next element in the iteration. 
	Throws the NoSuchElementException - if the iteration has no more elements
	@return E next element in the iteration
	*/
	public E next()
	{	
		if(hasNext() == false)
			throw new NoSuchElementException();
		return queueofnodes.poll();
	}
	
	/**
	Removes from the underlying collection the last element returned by this 
	iterator (optional operation). 
	Not actually defined.
	*/
	public void remove()
	{
	}
}