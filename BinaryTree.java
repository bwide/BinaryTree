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
    if(n.data == data ) return true;
    if(data > n.data) return exists(n.right, data);
    if(data < n.data) return exists(n.left, data);
    return false;
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

  public int pai(int data){
    return pai(null, root, data);
  }

  private int pai(Node pai, Node n, int data){
    if(n.data == data)
      if(pai!=null) return pai.data; // root
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

  public void copy(BinaryTree b){
    destroy();
    this.root = b.root;
  }

  private boolean hasInt(Node n, int data){//procura por toda a arvore, usado em 'hasrep'
    if(n==null) return false;
    if(n.data==data) return true;
    return hasInt(n.left, data) || hasInt(n.right, data);
  }

  public boolean hasRep(){
    return hasRep(root);
  }

  private boolean hasRep(Node n){
    if( n==null ) return false;
    return hasInt(n.left, n.data) || hasInt(n.right, n.data);
    // if( hasInt(n.left, n.data) || hasInt(n.right, n.data) ) return true;
    // return hasRep(n.left) || hasRep(n.right);
  }

  public void join(BinaryTree a, BinaryTree b){
    destroy();
    root = join(a.root,b.root);
  }

  private Node join(Node a, Node b){
    if(a==null && b==null) return null;
    if(a==null) return b;
    if(b==null) return a;

    if(a.data == b.data){
      a.left = join(a.left, b.left);
      a.right = join(a.right, b.right);
      return a;
    }
    if( a.data > b.data ){
      a.left = join(a.left, b);
      a.right = join(a.right, b.right);
      return a;
    }
    else{ //a.data < b.data
      b.left = join(a.left, b.left);
      b.right = join(a, b.right);
      return b;
    }
  }

  private Node find(Node n, int data){
    if( n==null ) return null;
    if( n.data==data ) return n;
    return ( data < n.data ? find(n.left, data) : find(n.right, data) );
  }

  public int ancestral(int a, int b){
    if(a==b) return a;
    int nA = nivel(a);
    int nB = nivel(b);
    if( nA == nB ) return ancestral(pai(a),pai(b));
    if( nA > nB ) return ancestral(pai(a),b);
    else return ancestral(a,pai(b));
  }

  public int nivel(int n){
    if(root.data == n) return 0;
    else return 1 + nivel(pai(n));
  }

  public static boolean isABP( Node n ) {
    if( n == null ) return true;
    if( isABP(n.left) && isABP(n.right) ) return true;
    if(n.left != null && n.left.data < n.data) return true;
    if(n.right != null && n.right.data > n.data) return true;

    return false;
  }

  public int maiorSoma(){
        return maiorSoma(root);
  }

  private int maiorSoma(Node n){
      if(n == null) return 0;
      int left, right;
      left = maiorSoma(n.left);
      right = maiorSoma(n.right);
      return left > right ? left + n.data : right + n.data;
  }

  public String caminho(){
      return caminho(root);
  }

  private String caminho(Node n){
      if(n == null) return "";

      int left, right;
      right = maiorSoma(n.right);
      left = maiorSoma(n.left);

      return right > left ? caminho(n.right) + " " + n.data : caminho(n.left) + " " + n.data;
  }
}
