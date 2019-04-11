import java.util.ArrayList; 

public class Sequence extends ArrayList<Integer> {
  public Sequence() {  }
  public Sequence(int[] values){ 
    for (int v : values)
      this.add( v);
  } 
  public static void main(String[] args) {    
    Sequence a = new Sequence( new int[] { 4, 5, 2, 3, 1, 7, 6 } ); 
              // notice how easy it is to initialize a Sequence now
    System.out.println( a ); 
    Sequence b = new Sequence(); 
    Sequence result = b.merge(a); 
    System.out.println( "merge(" + b + ", " + a + ") = " + result ); 
    result = a.merge(b); 
    System.out.println( "merge(" + a + ", " + b + ") = " + result ); 
    a = new Sequence();
    b = new Sequence(); 
    result = a.merge(b); 
    System.out.println( "merge(" + a + ", " + b + ") = " + result ); 
  }
  // if a and b are sortted the result is also sorted 
  public Sequence merge(Sequence other) {
    if (this.size() == 0) return other; 
    else if (other.size() == 0) return this; 
    else return null; 
  }
}