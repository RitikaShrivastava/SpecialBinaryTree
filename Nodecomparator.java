import java.util.Comparator;

public class Nodecomparator implements Comparator<Node>{

	@Override
	public int compare(Node arg0, Node arg1) {
		// TODO Auto-generated method stub
		
		if(arg0.weight < arg1.weight )
			return -1;
		
		if(arg0.weight > arg1.weight  ) {
			return 1;}
		
	
		return 0;
	}
		
	
	
}
