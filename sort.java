import java.util.ArrayList;
class sort {
  private ArrayList<Integer> sorted = new ArrayList<Integer>();
  private BST toSort;
  private node root;
  public sort(BST tree){
    this.toSort = tree;
    this.root = tree.getRoot();
  }

  public ArrayList<Integer> sort() {
    if(root != null){
      sort(root);
    }
    return sorted;
  }

  public void sort(node curr){
    //would cause an error if not for shortcircuting 
    if(curr.getLeft() != null && !sorted.contains(curr.getLeft().getKey())) {
      sort(curr.getLeft());
    }
    sorted.add(curr.getKey());
    if(curr.getRight() != null) {
      sort(curr.getRight());
    }
  }
}