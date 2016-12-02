public class BinaryTree {
  private Node root;

  private static class Node {
    Node left;
    Node right;
    int data;

    Node( int newData ) {
      left = right = null;
      data = newData;
    }
  }
  public BinaryTree() {
    root = null;
  }
  public void insert( int data ) {
    root = insert( root, data );
  }

  private Node insert( Node n, int data ) {
    if(n==null) return new Node(data);
    if(data > n.data) n.right = insert(n.right, data);
    if(data < n.data) n.left = insert(n.left, data);
    return n;
  }

  public void print( ) {
    System.out.println("______________________________________");
    print( root, "" );
  }

  private void print( Node n, String tab ) {
    if(n == null) return;

    print(n.left, tab + "    ");
    System.out.println(tab + n.data);
    print(n.right, tab + "    ");
  }

  public void destroy( ) {
    root = destroy( root );
  }

  private Node destroy( Node n ) {
    if(n == null) return null;
    if(n.left!=null) n.left = destroy(n.left);
    if(n.right!=null) n.right = destroy(n.right);
    return null;
  }

  public Boolean exists(int data){
    return exists(root, data);
  }

  public Boolean exists(Node n, int data){
    if(n == null) return false;
    if(data > n.data) return exists(n.right, data);
    if(data < n.data) return exists(n.left, data);
    return true;
  }

  public int altura(){
    return altura(root);
  }

  private int altura(Node n){
    if (n==null) return 0;
    if (n.left==null && n.right==null) return 0;
    int left = altura(n.left);
    int right = altura(n.right);
    return 1 + (left > right ? left : right);
  }

  public int numNodos(){
    return numNodos(root);
  }

  private int numNodos(Node n){
    if (n==null) return 0;
    else return 1 + numNodos(n.left) + numNodos(n.right);
  }

  public int pai(int n){
    return pai(null, root, n);
  }

  private int pai(Node pai, Node n, int data){
    if(n.data == data)
      if(pai!=null) return pai.data;
      else return -1;
    if( data > n.data ) return pai(n, n.right, data);
    if( data < n.data ) return pai(n, n.left, data);
    return -1;
  }

  public int soma(){
    return soma(root);
  }

  private int soma(Node n){
    if (n==null) return 0;
    return n.data + soma(n.left) + soma(n.right);
  }

  public int conta(int val){
    return conta(root, val);
  }

  private int conta(Node n, int val){
    if(n==null) return 0;
    int res = 0;
    res += conta(n.left, val);
    res += conta(n.right, val);
    if(n.data==val) res+=1;
    return res;
  }

  public int numPares(){
    return numPares(root);
  }

  private int numPares(Node n){
    if(n==null) return 0;
    int res = 0;
    res+=numPares(n.left);
    res+=numPares(n.right);
    if(n.data % 2 == 0) res+=1;
    return res;
  }

  public void emOrdem(){
    emOrdem(root);
  }

  private void emOrdem(Node n){
    if(n==null) return;
    if(n.left!=null) emOrdem(n.left);
    System.out.println( n.data );
    if(n.right!=null) emOrdem(n.right);
  }

  public void emOrdemDec(){
    emOrdemDec(root);
  }

  private void emOrdemDec(Node n){
    if(n==null) return;
    if(n.right!=null) emOrdem(n.right);
    System.out.println( n.data );
    if(n.left!=null) emOrdem(n.left);
  }
  
  public void espelha(){
    espelha(root);
  }

  private void espelha(Node n){
    if(n==null) return;
    if( n.left==null && n.right==null ) return;
    if( n.left!=null ) espelha(n.left);
    if( n.right!=null ) espelha(n.right);
    Node aux = n.left;
    n.left = n.right;
    n.right = aux;
  }
}