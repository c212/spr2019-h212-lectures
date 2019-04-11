import java.util.ArrayList; 

public class Sequence {
  private ArrayList<Integer> values; 
  public Sequence() {
    this.values = new ArrayList<Integer>();
  }
  public Sequence(int[] values){ 
    this(); // ha, ha!
    for (int v : values)
      this.values.add( v);
  } 
  public void add(int n) {
    this.values.add(n);
  }
  public String toString() {
    return this.values.toString();
  }
  public static void main(String[] args) {    
    Sequence w = new Sequence( new int[] { 4, 5, 2, 3, 1, 7, 6 } ); 
              // notice how easy it is to initialize a Sequence now
    System.out.println( w ); 
  }
}