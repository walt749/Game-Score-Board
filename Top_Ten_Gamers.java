package programing_Challenges;


/**
 * @author santiago24756
 *
 */
public class Top_Ten_Gamers {
	
	 private Node first; //list head.
	  private Node last; //last element in list.
	
	
	private class Node{
		
		String name;
		int score;
		Node next;
		
		
		
		/**
		 * Constructor
		 * @param na name of gamer.
		 * @param sc score of gamer.
		 * @param n the reference to the successor node.
		 */
		
		Node(String na, int sc, Node n){
			
			name = na;
			score = sc;
			next = n;
			
		}
		
		
		/**
		 * Constructor
		 *@Param na name
		 *@param int score
		 */
		@SuppressWarnings("unused")
		Node(String na, int sc){
			
			this(na, sc, null); // call the other (sister) constructor.
		}
		
	
	}
	
	 
	  
	  
	/**
	 * Constructor.
	 */
	public Top_Ten_Gamers() {
		// TODO Auto-generated constructor stub
		
		first = null;
		last = null;
		
	}
	
	   
	    /**
	     * The isEmpty method checks to see
	     * if the list is empty.
	     * @return true if list is empty,
	     * false otherwise. 
	     */
	
	public boolean isEmpty(){
		
		return first == null;
	}
	
	
	
	/**
	 *The size method returns the length of the list.
	 *@return the number of elements in the list. 
	 */
	
	public int size(){
		
		int count = 0;
		Node p = first;
		while(p != null){
			
			//There is an element at p
			count++;
			p = p.next;
			
		}
		return count;
	}
	  
	
	
	/**
	 * The add method adds an element to
	 * the end of the list.
	 * @param e The value to add to the end 
	 * of the list.
	 */
	
	public void add(String na, int sc){
		
		
		
		if(isEmpty()){
			
			//new node goes at the beginning.
			first = new Node(na, sc ,first);
			last = first;
			}
		
		else if(first.score <= sc)
		{	
			
			  first = new Node(na, sc, first);
		         
			    if(last == null)
		    	 last = first;
		    	  
			
		}
		else if(first.score >= sc){
			
		    	  Node pred = first;
		  
		   for(int index = 0; index <= size()-2; index++){
			   
			   
			  if(pred.next.score <= sc){   //checks the next node's score
				break;  
				

			  }pred = pred.next;

		   }
		    	  
		    	  
		   pred.next = new Node(na, sc,pred.next); 	
		   
	
		}
		
	
	}
		    	  
		 
			
	
	
	     public String toString(){
	    	 
	    	 StringBuilder strBuilder = new StringBuilder();
	    	 
	    	 Node p = first;
	    	 
	    	 while(p != null){
	    	 
	    	 strBuilder.append(p.name +" " +p.score +"\n");
	    	 p = p.next;
	    	 
	    	 }
	    	 return strBuilder.toString();
	    	 
	     }
	     
	     
	     
	/**
	 * The Remove method removes an element.
	 * @param element the element to remove.
	 * @return true if the remove succeeded.
	 * false otherwise.
	 */
	    
	     public boolean remove(String element){
	    	 
	    	 if(isEmpty())
	    		 return false;
	    	 
	    	 if(element.equals(first.name)){
	    		 
	    		 //Removal of the first item in the list.
	    		 first = first.next;
	    		 if(first == null)
	    			 last = null;
	    		 
	    		 return true;
	    		 
	    	 }
	    	 
	    	 //Find the predecessor of the element to remove.
	    	 Node pred = first;
	    	 
	    	 while(pred.next != null && !pred.next.name.equals(element)){
	    		 
	    		 pred = pred.next;
	    		 
	    	 }
	    		 
	    		 // pred.next == null OR pred.nest.value is element
	    	 if(pred.next == null)
	    		 return false;
	    		 
	    		 
	    	 //pred.next.value is element.
	    	 pred.next = pred.next.next;
	    	 
	    	 //check if the pred is now last
	    	 if(pred.next == null)
	    	 last = pred;
	    	 
	    	 
	    	 return true;
	     }
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Top_Ten_Gamers to = new Top_Ten_Gamers();
		
		to.add("Al", 50);
	//	System.out.println(to);
		to.add("Bob", 30);
		System.out.println(to);
		
		to.add("Wa", 42);
		System.out.println(to);
		System.out.println(to.first.next.score);
		
		to.add("et", 40);
		
		System.out.println(to);
		to.add("TE", 68);
		System.out.println(to);
		to.add("EG", 47);
		System.out.println(to);
		
		to.add("a", 70);
		System.out.println(to);
		to.add("OF", 20);
		
		to.add("W", 69 );
		
		System.out.println(to);
		System.out.println(to.first.next.score);

	}

}
