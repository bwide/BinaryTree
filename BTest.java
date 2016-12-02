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
      if ( temp.equals( "pai" ) ) System.out.println( T.pai( input.nextInt() ) );
      if ( temp.equals( "soma" ) ) System.out.println( T.soma() );
      if ( temp.equals( "conta" ) ) System.out.println( T.conta( input.nextInt() ) );
      if ( temp.equals( "numPares" ) ) System.out.println( T.numPares() );
      if ( temp.equals( "emOrdem" ) ) T.emOrdem();
      if ( temp.equals( "emOrdemDec" ) ) T.emOrdemDec();
      if ( temp.equals( "espelha" ) ) T.espelha();
      
      
      T.print();
    }
    //T.print();
    T.destroy( );
  }
}