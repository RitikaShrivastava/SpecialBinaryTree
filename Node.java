
public class Node {
		
	int weight ;
	String letters;
	
	Node left, right;
	
	Node(){
		
	this.weight = 0;
	this.letters = "";
	
	this.left = null;
	this.right = null;
	}
	Node(int weight,String letters)
	{
		this.weight = weight;
		this.letters = letters;
		this.left = null;
		this.right = null;
	}
	
	void setLeft( Node left)
	{
		this.left = left;
	}

	void getLeft( Node left)
	{
		this.left = left;
	}
	void setRight( Node right)
	{
		this.right = right;
	}
	void getRight( Node right)
	{
		this.right = right;
	}
}
