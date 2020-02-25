public class node{
  private int key;
  private node left, right;

  public node(int value, node left, node right){
    this.key = value;
    this.left = left;
    this.right = right;
  }

  public int getKey() {
    return this.key;
  }

  public node getLeft() {
    return this.left;
  }

  public node getRight() {
    return this.right;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public void setLeft(node left) {
    this.left = left;
  }

  public void setRight(node right) {
    this.right = right;
  }
}