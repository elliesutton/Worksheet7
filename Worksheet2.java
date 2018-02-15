/** @author Ellen Sutton
 * 
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {
   
	// Exercise 1

	/**
	 * negateAll is a method that given a tree, returns a new tree containing all the
	 * elements of that tree with their sign negated.
	 * @param t - a tree of integers
	 * @return a new tree containing all elements of t with their sign negated
	 */
    public static Tree<Integer> negateAll(Tree<Integer> t) {
		if (t.isEmpty())
			return t;
		else 
			return new Tree<Integer>(-t.getValue(), 
					negateAll(t.getLeft()), negateAll(t.getRight()));
    }

    
    
    
    
    // Exercise 2

    /**
     * allPositive is a method that given a tree, returns true if all elements of that
     * tree are positive and false otherwise
     * @param a - a tree of integers
     * @return true if all elements of a are positive, false otherwise
     */
    public static boolean allPositive(Tree<Integer> a) {
		if (a.isEmpty())
			return true;
		else if (a.getValue() < 0)
			return false;
		else //if a.getValue() >= 0
			return allPositive(a.getLeft()) && allPositive(a.getRight());
    }

    
    
    
    
    
    // Exercise 3
    
    /**
     * mirror is a method that given a tree, returns a new tree that is a mirror image
     * of that tree along the left-right axis.
     * @param t - a tree
     * @return the mirror image of t along the left-right axis
     */
    public static<E> Tree<E> mirror(Tree<E> t) {
		if (t.isEmpty() || (t.getLeft().isEmpty() && t.getRight().isEmpty()))
			return t;
		else 
			return new Tree<E>(t.getValue(), mirror(t.getRight()), mirror(t.getLeft()));
		}

    
    
    
    
    
    // Exercise 4
    
    /**
     * append is a method that creates a new list by appending two given lists. It is generic
     * in the element type E.
     * 
     * Provided by Uday Reddy in the class ListOpsGeneric
     * 
     * @param a - a list of type E that we are to append to the left of the new List.
     * @param b - a list of type E that we are to append to the right of the new List.
     * @return a new list with a and b appended together.
     */
    public static<E> List<E> append(List<E> a, List<E> b) {
    	if (a.isEmpty())
    		return b;
    		else
    		return new List<E>(a.getHead(), append(a.getTail(), b));
    }
    
    
    
    /**
     * postorder is a method that given a tree, returns a list containing the values in a
     * by traversing the nodes in postorder
     * @param t - a Tree<E>
     * @return a List<E> which contains all elements of t in postorder
     */
    public static<E> List<E> postorder(Tree<E> t) {
    	if (t.isEmpty())
    		return new List<E>();
    	else
    		return append(postorder(t.getLeft()), 
    				append(postorder(t.getRight()), new List<E>(t.getValue(), new List<E>()))); 
    }

    
    
    
    
    
		// Exercise 5
    
    /**
     * min is a method that given a binary search tree, returns the minimum value stored in 
     * the tree
     * @param a - a binary search tree 
     * @return the maximum value stored in a
     */
    public static int min(Tree<Integer> a) {
		if (a.getLeft().isEmpty())
			return a.getValue();
		else 
			return max(a.getLeft());
    }
    
    
    /**
     * isSearchTree is a method that given a tree, returns true if it is a binary search true
     * and returns false otherwise
     * @param a - a tree of integers
     * @return true if a is a binary search tree, false otherwise
     */
    public static boolean isSearchTree(Tree<Integer> a) {
		if (a.isEmpty() || (a.getLeft().isEmpty() && a.getRight().isEmpty()))
			return true;
		else if (max(a.getLeft()) > a.getValue() || min(a.getRight()) < a.getValue())
			return false;
		else
			return isSearchTree(a.getLeft()) && isSearchTree(a.getLeft());
    }

    
    
    
    
    
    // Exercise 6
    /**
     * printDescending is a method that given a tree, prints out the elements of that tree in
     * descending order
     * @param a - a tree of integers
     */
    public static void printDescending(Tree<Integer> a) {
		if (a.isEmpty())
			System.out.println();
		else {
			printDescending(a.getRight());
			System.out.print(a.getValue());
			printDescending(a.getLeft());
		}
    }

    
    
    
    
    
		// Exercise 7
    /**
     * max is a method that given a binary search tree, returns the maximum value stored in 
     * the tree
     * @param a - a binary search tree 
     * @return the maximum value stored in a
     */
    public static int max(Tree<Integer> a) {
		if (a.getRight().isEmpty())
			return a.getValue();
		else 
			return max(a.getRight());
    }

    
    
    
    
    
    
    // Exercise 8
    /**
     * delete is a method that given a binary search tree and a value x, returns that tree
     * with x deleted.
     * @param a - a binary search tree
     * @param x - the integer to be deleted
     * @return the search tree a with x deleted
     */
    public static Tree<Integer> delete(Tree<Integer> a, int x) {
		if (a.getLeft().isEmpty() && a.getRight().isEmpty())
			return new Tree<Integer>();
		else if (a.getValue() == x && a.getLeft().isEmpty())
			return new Tree<Integer>(a.getRight().getValue(), a.getRight().getLeft(), a.getRight().getRight());
		else if (a.getValue() == x && a.getRight().isEmpty())
			return new Tree<Integer>(a.getLeft().getValue(), a.getLeft().getLeft(), a.getLeft().getRight());
		else if (a.getValue() == x)
			return new Tree<Integer>(max(a.getLeft()), delete(a.getLeft(), max(a.getLeft())), a.getRight());
		else if (a.getValue() > x)
			return new Tree<Integer>(a.getValue(), delete(a.getLeft(), x), a.getRight());
		else //if (a.getValue() < x)
			return new Tree<Integer>(a.getValue(), a.getLeft(), delete(a.getRight(), x));
    }
    
    
    
    
    

		// Exercise 9
    /**
     * isHeightBalanced is a method that given a tree, returns true if the tree is height balanced
     * and returns false otherwise
     * @param a - a Tree<E>
     * @return true if a is height balanced, false otherwise
     */
    public static<E> boolean isHeightBalanced(Tree<E> a) {
    	if (a.isEmpty())
    		return true;
    	else if (Math.abs(a.getLeft().getHeight() - a.getRight().getHeight()) <= 1)
    		return isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight());
    	else
    		return false;
    }

    
    
    
    
    
    
    
		// Exercise 10
    
    
    /**
     * rightRotate is a method that performs a right rotation on a tree
     * @param a - a tree
     * @return - a tree containing the same elements of a with a right rotation performed
     */
    public static Tree<Integer> rightRotate(Tree<Integer> a) {
    	return new Tree<Integer>(a.getLeft().getValue(), a.getLeft().getLeft(), 
    			new Tree<Integer>(a.getValue(), a.getLeft().getRight(), a.getRight()));
    }
    
    /**
     * leftRotate is a method that performs a left rotation on a tree
     * @param a - a tree
     * @return a tree containing the same elements of a with a left rotation performed
     */
    public static Tree<Integer> leftRotate(Tree<Integer> a) {
    	return new Tree<Integer>(a.getRight().getValue(), new Tree<Integer>(a.getValue(), a.getLeft(),
    			a.getRight().getLeft()), a.getRight().getRight());
    }
    
    
    /**
     * heightBalanceFactor is a method that returns the height balance factor of a given tree
     * which is given by the height of the left subtree - the height of the right subtree
     * @param a - a tree
     * @return the height balancing factor (height of left subtree - height of right subtree)
     */
    public static int heightBalanceFactor(Tree<Integer> a) {
    	return a.getLeft().getHeight() - a.getRight().getHeight();
    }
    
    /**
     * restoreHB is a method that given a tree that is not height balanced, restores the
     * height balanced property
     * @param a - a tree that is not height balanced
     * @return a height balanced tree that contains the same elements of a 
     */
    public static Tree<Integer> restoreHB(int x, Tree<Integer> t) {
		if (heightBalanceFactor(t) > 1 && x < t.getLeft().getValue())
			return rightRotate(t); 
		else if (heightBalanceFactor(t) > 1 && x > t.getLeft().getValue())
			return rightRotate(new Tree<Integer>(t.getValue(), leftRotate(t.getLeft()), t.getRight()));
		else if (heightBalanceFactor(t) < -1 && x > t.getRight().getValue())
			return leftRotate(t);
		else //if (heightBalanceFactor(t) < -1 && x < a.getRight().getValue())
			return leftRotate(new Tree<Integer>(t.getValue(), t.getLeft(), rightRotate(t.getRight())));
   } 
    
    
    
    
    /**
     * insertHB is a method that inserts an integer x to a height balanced binary search tree,
     * whilst maintaining the height balanced property
     * @param x - an integer
     * @param a - a height balanced binary search tree
     * @return a height balanced binary search tree containing all elements of a with x inserted
     */
    public static Tree<Integer> insertHB(int x, Tree<Integer> a) {
    	if (a.isEmpty())
    		return new Tree(x, new Tree<Integer>(), new Tree<Integer>());
    	else if (x == a.getValue())
    		throw new IllegalArgumentException("Cannot insert duplicates.");
    	else if (x < a.getValue()){
    		Tree<Integer> t = new Tree<Integer>(a.getValue(), insertHB(x, a.getLeft()), a.getRight());
    		if (isHeightBalanced(t))
    			return t;
    		else 
    			return restoreHB(x, t);
    	}
    	else { //if (x > a.getValue())
    		Tree<Integer> t =  new Tree<Integer>(a.getValue(), a.getLeft(), insertHB(x, a.getRight()));
    		if (isHeightBalanced(t))
    			return t;
    		else 
    			return restoreHB(x, t);
    	}
    	
    } 
    
    

    
    /**
     * deleteHB is a method that deletes an integer x from a height balanced binary search tree,
     * whilst maintaining the height balanced property
     * @param a - a height balanced binary search tree
     * @param x - an integer
     * @return - a height balanced binary search tree containing all elements of a apart from x
     */
    public static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
			Tree<Integer> t = delete(a, x);
			if (isHeightBalanced(t))
				return t;
			else {
				if (heightBalanceFactor(t) > 1)
					return rightRotate(t); 
				else //if (heightBalanceFactor(t) < -1)
					return leftRotate(t);
			}
    }
   
    
    
    


    
    
}