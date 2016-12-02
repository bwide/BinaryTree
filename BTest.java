import java.util.Scanner;

public class BTest {

  public static void main( String[] args ) {
    BinaryTree T = new BinaryTree();

    Scanner input = new Scanner( System.in );

    while ( input.hasNext() ) {
      String temp = input.next();

      if ( temp.equals( "quit" ) ) break;
      if ( temp.matches( "[0-9]+" ) ) T.insert( Integer.parseInt(temp) );
      if ( temp.equals( "exists" ) ) System.out.println( ( T.exists( input.nextInt() ) ? "true" : "false" ) );
      if ( temp.equals( "altura" ) ) System.out.println( T.altura() );
      if ( temp.equals( "numNodos" ) ) System.out.println( T.numNodos() );
      
      //T.print();
    }
    T.print();
    System.out.println( "altura: " + T.altura() );
    System.out.println( "numNodos: " + T.numNodos() );
    T.destroy( );
  }
}