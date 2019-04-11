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
    
    a = new Sequence( new int[] { 1, 3, 5, 7, 9 } ); 
    b = new Sequence( new int[] { 2, 4, 6, 8, 10 } ); 
    result = a.merge(b); 
  }
  // if a and b are sorted the result is also sorted 
  public Sequence merge(Sequence other) {
    if (this.size() == 0) return other; 
    else if (other.size() == 0) return this; 
    else {
      Sequence result = new Sequence(); 
      for (int me = 0, them = 0; me < this.size() || them < other.size() ;     ) {
        if (this.get(me) < other.get(them)) 
          result.add(this.get(me++)); 
        else 
          result.add(other.get(them++));          
        System.out.println( result ); 
      }
      return result; 
    }
  }
}