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
  
  public Integer get(int n) {
    return this.values.get(n);  
  }

  public int size() { return this.values.size(); }
  
  public Integer remove(int n) { return this.values.remove(n); } 
  
  public String toString() {
    return this.values.toString();
  }
  public static Sequence merge(Sequence a, Sequence b) {
   Sequence result = new Sequence(); 
   while (a.size() > 0 || b.size() > 0) {
     if (a.size() > 0 && b.size() > 0 && a.get(0) < b.get(0) || b.size() == 0) 
       result.add(a.remove(0));
     else if (a.size() > 0 && b.size() > 0 && a.get(0) >= b.get(0) || a.size() == 0) 
       result.add(b.remove(0));
     else System.out.println("This should have never happen."); 
   }
   return result; 
  }
  public boolean empty() { return this.size() == 0; } 
  public Sequence longest() { 
    Sequence result = new Sequence(); 
    if (this.empty()) {
      return result;     
    } else { // if I come here I am a non empty sequence 
      while( result.empty() || // I do the body if result is empty
            ! this.empty() && this.get(0) >= result.get(result.size()-1)) {
            // or result is not empty and I am not empty and my first number is bigger than result's last 
        result.add(this.remove(0));  // so here I move one element from me (my first) to result (becomes last there) 
      }
      return result;  
    }
  }
  // public Sequence rest() { 
  //  Sequence result = new Sequence(); 
  //  
  //  return result;  
  // }  
  public Sequence sort() {
    if (this.empty()) return new Sequence(); 
    Sequence a = this.longest();  // which side-effects a into its rest
    Sequence b = this; // this.rest();
    // System.out.println(a + " " + b); 
    return merge(a, b.sort());
  }
  
  public static void main(String[] args) {    
    Sequence m = new Sequence( new int[] { 2, 4, 5 } ); 
    Sequence n = new Sequence( new int[] { 1, 2, 3 } ); 
    System.out.println( "Sequence.merge(" + m + ", " + n + ") = " + Sequence.merge(m, n) ); 
    
    Sequence a = new Sequence(new int[] {3, 4, 7, 2, 5, 6, 4, 1, 3});
    
    a = new Sequence(new int[] {4, 3, 2, 1});
    System.out.println( a + ".sort() results in: " + a.sort() );     
    a = new Sequence(new int[] {4, 4, 4, 1, 4, 4, 4});
    System.out.println( a + ".sort() results in: " + a.sort() );     
    a = new Sequence(new int[] {});
    System.out.println( a + ".sort() results in: " + a.sort() );     
    a = new Sequence(new int[] {5});
    System.out.println( a + ".sort() results in: " + a.sort() );     
    
  }
}