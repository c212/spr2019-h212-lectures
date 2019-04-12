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
        System.out.println( result ); // without this I could not test this imperfect case
      }
      return result;
    }
  }
}

/*

-bash-4.2$ javac Sequence.java
-bash-4.2$ java Sequence
[4, 5, 2, 3, 1, 7, 6]
merge([], [4, 5, 2, 3, 1, 7, 6]) = [4, 5, 2, 3, 1, 7, 6]
merge([4, 5, 2, 3, 1, 7, 6], []) = [4, 5, 2, 3, 1, 7, 6]
merge([], []) = []
[1]
[1, 2]
[1, 2, 3]
[1, 2, 3, 4]
[1, 2, 3, 4, 5]
[1, 2, 3, 4, 5, 6]
[1, 2, 3, 4, 5, 6, 7]
[1, 2, 3, 4, 5, 6, 7, 8]
[1, 2, 3, 4, 5, 6, 7, 8, 9]
Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 5, Size: 5
        at java.util.ArrayList.rangeCheck(ArrayList.java:657)
        at java.util.ArrayList.get(ArrayList.java:433)
        at Sequence.merge(Sequence.java:34)
        at Sequence.main(Sequence.java:25)
-bash-4.2$

 */
