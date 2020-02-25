public class BST {  

  private node root;

  public BST() {
    root = null;
  }

public node getRoot() {
  return root;
}
//start of the iterative code
  public void insertIter(int toInsert) {
    if(root == null) {
      root = new node(toInsert, null, null);
    }
    node curr = root;
    //if the current node is not empty, broken go on
    //if the current node is equal to the new value break because assumed no duplicates
    while(curr != null && curr.getKey() != toInsert) {
      if(curr.getKey() > toInsert) {
        //if the value to insert is less than the current node and the left child is empty insert
        if(curr.getLeft() == null) {
          curr.setLeft(new node(toInsert, null, null));
          break;
        }
        //else get the left node to compare
        curr = curr.getLeft();
      }
      else {
        //if the value to insert is greater than the current node and the right child is empty insert
        if(curr.getRight() == null) {
          curr.setRight(new node(toInsert, null, null));
          break;
        }
        //else get the right child to compare
        curr = curr.getRight();
      }
    }
  }
  //very ugly but java doesnt have pointers
  public void removeIter(int toRemove) {
    if(root == null) {
      return;
    }
    if(root.getKey() == toRemove) {
      root = null;
    }
    node curr = root;
    while(curr.getLeft().getKey() != toRemove && curr.getRight().getKey() != toRemove) {
      if(curr.getKey() > toRemove) {
        curr = curr.getLeft();
      }
      else {
        curr = curr.getRight();
      }
    }
    node temp;
    node remove;
    int toReplace;
    //could probably make this a private method to remove clutter, but java makes copies of the obj so it might make a mess 
    if(curr.getLeft().getKey() == toRemove){
      temp = curr.getLeft();
      //if both children are null just remove the element
      if(temp.getLeft() == null && temp.getRight() == null) {
        curr.setLeft(null);
      }
      //if the left child is null make the removed element the right node with its children
      else if(temp.getLeft() == null) {
            curr.setLeft(temp.getRight());
          }
      //if the right child is null make the removed element the left node with its children
            else if(temp.getRight() == null) {
              curr.setLeft(temp.getLeft());
            }
              else {
                remove = temp.getRight();
                while(remove.getLeft() != null) {
                  remove = remove.getLeft();
                }
                toReplace = remove.getLeft().getKey();
                remove.setLeft(null);
                curr.getLeft().setKey(toReplace);
            }
    }
    else{
      temp = curr.getRight();
      //if both children are null just remove the element
      if(temp.getLeft() == null && temp.getRight() == null) {
        curr.setRight(null);
      }
      //if the left child is null make the removed element the right node with its children
      else if(temp.getLeft() == null) {
            curr.setRight(temp.getRight());
          }
      //if the right child is null make the removed element the left node with its children
            else if(temp.getRight() == null) {
              curr.setRight(temp.getLeft());
            }
              else {
                remove = temp.getRight();
                while(remove.getLeft() != null) {
                  remove = remove.getLeft();
                }
                toReplace = remove.getLeft().getKey();
                remove.setLeft(null);
                curr.getRight().setKey(toReplace);
            }
    }
  }

  public node getMaxIter(node curr){
    while(curr.getRight() != null){
      curr = curr.getRight();
    }
    return curr;
  }

  public node getMinIter(node curr) {
    while(curr.getLeft() != null) {
      curr = curr.getLeft();
    }
    return curr;
  }

  

//Start of the recursive functions
  public void insertRec(node curr, int toInsert) {
    if(root == null) {
      root = new node(toInsert, null, null);
    }
    else {
      //if the value is less than the current node
      if(toInsert < curr.getKey()) {
        //add to the tree if there is an empty space
        if(curr.getLeft() == null) {
          curr.setLeft(new node(toInsert, null, null));
        }
        //continue down the tree otherwise
        else {
          insertRec(curr.getLeft(), toInsert);
        }
      }
      //if the value is greater than the current node
      else {
        if(curr.getRight() == null) {
          curr.setRight(new node(toInsert, null, null));
        }
        else {
          insertRec(curr.getRight(), toInsert);
        }
      }
    }
  }

  //assume the tree is not empty
  public node removeRec(node curr, int toRemove) {
    if(curr == null) {
      return null;
    }
    //is the return condition and will return the node to replace the node we are removing
    if(curr.getKey() == toRemove) {
      //if it had no children dont worry about setting new patterns
      if(curr.getLeft() == null && curr.getRight() == null) {
        return null;
      }
      //if there is only the right child return that
      if(curr.getLeft() == null) {
        return curr.getRight();
      }
      //if there is only the left child return that
      if(curr.getRight() == null) {
        return curr.getLeft();
      }
      //if curr has two branches must get the smallest value from the right side
      node temp = findMinRec(curr);
      curr.setKey(temp.getKey());
      //remove the copied value and return the node
      curr.setRight(removeRec(curr.getRight(), temp.getKey()));
      return curr;
    }
    //if true set the left child to the evaluation of the 
    else if(curr.getKey() > toRemove) {
      curr.setLeft(removeRec(curr.getLeft(), toRemove));
      return curr;
    }
      else {
        curr.setRight(removeRec(curr.getRight(), toRemove));
        return curr;
      }
  }

  //works only if sorted correctly
  public node findMinRec(node curr) {
    //if there is still a value less than the current value return that 
    if(curr.getLeft() != null) {
      return findMinRec(curr.getLeft());
    }
    else {
      return curr;
    }
  }

  //works only if sorted correctly
  public node findMaxRec(node curr) {
    //if there is still a child greater/right than return that value
    if(curr.getRight() != null) {
      return findMaxRec(curr.getRight());
    }
    else {
      return curr;
    }
  }

}
