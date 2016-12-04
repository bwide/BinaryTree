import java.util.Scanner;

public class BTest {

  public static void main( String[] args ) {
    BinaryTree T = new BinaryTree();
    BinaryTree t1 = new BinaryTree();
    BinaryTree t2 = new BinaryTree();
    
    t1.insert(5);
    t1.insert(4);
    t1.insert(10);

    t2.insert(5);
    t2.insert(2);
    t2.insert(7);

    Scanner input = new Scanner( System.in );

    while ( input.hasNext() ) {
      String temp = input.next();

      if ( temp.equals( "quit" ) ) break;
      if ( temp.matches( "[0-9]+" ) ) T.insert( Integer.parseInt(temp) );
      if ( temp.equals( "exists" ) ) System.out.println( ( T.exists( input.nextInt() ) ? "true" : "false" ) );
      if ( temp.equals( "altura" ) ) System.out.println( T.altura() );
      if ( temp.equals( "numNodos" ) ) System.out.println( T.numNodos() );
      if ( temp.equals( "pai" ) ) System.out.println( T.pai( input.nextInt() ) );
      if ( temp.equals( "soma" ) ) System.out.println( T.soma() );
      if ( temp.equals( "conta" ) ) System.out.println( T.conta( input.nextInt() ) );
      if ( temp.equals( "numPares" ) ) System.out.println( T.numPares() );
      if ( temp.equals( "emOrdem" ) ) T.emOrdem();
      if ( temp.equals( "emOrdemDec" ) ) T.emOrdemDec();
      if ( temp.equals( "espelha" ) ) T.espelha();
      if ( temp.equals( "copia" ) ) T.copy( t1 );
      if ( temp.equals( "hasRep" ) ) System.out.println( ( T.hasRep() ? "true" : "false" ) );
      if ( temp.equals( "join" ) ) T.join( t1, t2 );
      
      T.print();
    }
    //T.print();
    T.destroy( );
  }
}