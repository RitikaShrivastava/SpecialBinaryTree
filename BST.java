import java.util.*;
public class BST {
//RITIKA SHRIVASTAVA - ALL RIGHTS RESERVED!
//RXS160231
	
	
	public static void main(String[] args) {
		
			System.out.println("Please enter input: ");
			
			Scanner sc = new Scanner(System.in);
			
			String input = sc.nextLine();
			
			ArrayList<Node> arrayList = new ArrayList<Node>();
			//arraylist of type node to store all my nodes in an array
			//checking to see if each character already exists as a node in the array and if not, add it. if yes, then increase the weight by 1
			for(int i = 0; i < input.length(); i++) {
				boolean yes = false;
				
				for(int j = 0; j < arrayList.size(); j++) {
					
					if( input.charAt(i) == arrayList.get(j).letters.charAt(0)) {
							arrayList.get(j).weight++;
							yes = true;
					}
					
					
				}
			
				if(yes == false) {
					
					Node temp = new Node( 1, input.substring(i,i+1));
					arrayList.add(temp);
				}
				
			}
			
			print(arrayList, input);
			//printing all unique chars by decreasing frequency
			//Priority queue helps sort my node weights easily
			
			PriorityQueue <Node> pQueue = new PriorityQueue<Node>(20, new Nodecomparator());
			for(int o = 0; o < arrayList.size(); o ++)
			{		
				pQueue.add(arrayList.get(o));
				//adding all nodes from the arraylist to the priority queue
		
			}
			String yOrN = "";
			while( pQueue.size() != 1 ) {
				System.out.println("Ready for the next step? Press enter");
				yOrN = sc.nextLine();//pausing for user to review
			Node node1 = pQueue.poll();
			Node node2 = pQueue.poll();
			Node temp = new Node();
			temp.setLeft(node1);
			temp.setRight(node2);
			temp.weight = node1.weight + node2.weight;
			temp.letters = node1.letters + node2.letters;
			pQueue.add(temp);
			System.out.println("Combined node ' " + node1.letters +  "' weight {" + node1.weight +"} " + " with '"+  node2.letters + "' weight { " + node2.weight + " } " + "to produce '"+ temp.letters+ "' - weight: " + temp.weight  );
			printqueue(pQueue,  temp);
			//printing ONLY the un-combined chars left in the P queue which are printed in the descending order
			}
			System.out.println("Thank you! Bye!");
	}
	
	public static void print(ArrayList<Node> arrayList, String input)
	{
		//function uses bubble sort and sorts weights descending and prints the original list of unique characters
		System.out.println("Character == > Count ");
		for (int i = 0; i < arrayList.size() - 1; i++)
		  {
		     for (int j = 0; j < arrayList.size() - i -1; j++)
		     {
		        if (arrayList.get(j).weight < (arrayList.get(j+1).weight) )
		        {
		           int temp =arrayList.get(j).weight;
		           arrayList.get(j).weight = arrayList.get(j+1).weight;
		           arrayList.get(j+1).weight = temp;
		           String temp2 = arrayList.get(j).letters;
		           arrayList.get(j).letters = arrayList.get(j+1).letters;
		           arrayList.get(j+1).letters = temp2;
		           
		        }
		     }
		  }
		
		
		for ( int k = 0;k < arrayList.size(); k++) {
			
		System.out.println(arrayList.get(k).letters + " == > " + arrayList.get(k).weight);
		
		
		}
	}
	public static void printqueue(PriorityQueue <Node> pQueue, Node temp)
	{
	//function uses bubble sort descending and prints all left over un combined letters and their weights
		int size = pQueue.size();
		
		Node[] arrayNode = new Node[size];
		pQueue.toArray(arrayNode);
		for (int i = 0; i < arrayNode.length - 1; i++)
		  {
		     for (int j = 0; j < arrayNode.length - i -1; j++)
		     {
		        if (arrayNode[j].weight < (arrayNode[j+1].weight) )
		        {
		           int temp3 =arrayNode[j].weight;
		           arrayNode[j].weight = arrayNode[j+1].weight;
		           arrayNode[j+1].weight = temp3;
		           
		           String temp2 = arrayNode[j].letters;
		           arrayNode[j].letters = arrayNode[j+1].letters;
		           arrayNode[j+1].letters = temp2;
		           
		        }
		     }
		  }
		
		
		
		
		
		
		for ( int k = 0;k < arrayNode.length; k++) {
			if(arrayNode[k].letters.length() == 1) {
				
				
				
			System.out.println(arrayNode[k].letters + " == > " + arrayNode[k].weight);}
			}
	
	}

}
