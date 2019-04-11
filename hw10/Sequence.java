import java.util.ArrayList; 

public class Sequence extends ArrayList<Integer> {
  public Sequence() {  }
  public Sequence(int[] values){ 
    for (int v : values)
      this.add( v);
  } 
  public static void main(String[] args) {    
    Sequence w = new Sequence( new int[] { 4, 5, 2, 3, 1, 7, 6 } ); 
              // notice how easy it is to initialize a Sequence now
    System.out.println( w ); 
  }
}