package reveilleMatin;


public class Main {
 public static ReveilMatin rm = new ReveilMatin();
 public static User user = new User(rm);
 public static void main ( String[] args ) {
  new Thread(user).start();
}
 
 public static void minuteur(int i,ReveilMatin myRM){
	 for(int j=0;j<i;j++){
		 myRM.incrementTime();
	 }
 }
}