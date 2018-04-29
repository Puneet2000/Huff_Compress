package MakeHuffmanTree;
import java.util.PriorityQueue;
import HuffmanNode.*;
import Compare.*;
public class MakeHuffmanTree {

 
  String text="";
  

  public MakeHuffmanTree (String text ){
  	this.text = text;
  	
  	
  }
  
  public void MakeTree(String [] codes)
  {
  	int [] freq = new int [128];
  	int n=0;
  	for (int i=0;i<128;i++)
  		freq[i] =0;

  	for(int i=0; i<text.length() ;i++)
  		freq[text.charAt(i)]++;



  	for (int i=0;i<128;i++)
  		{
  			if (freq[i]>0)
  				n++;
  		}


  	PriorityQueue <HuffmanNode> tree = new PriorityQueue<HuffmanNode>(n, new Compare());
  	for (int i=0;i<128;i++)
  	{
  		if(freq[i] > 0)
  		{
  			HuffmanNode node = new HuffmanNode();
  			node.frequency = freq[i];
  			node.ascii = i;
  			node.left =null;
  			node.right = null;
  			tree.add(node);

  		}
  	}

  	HuffmanNode root = null;

  	while ( tree.size() > 1)
  	{
  		HuffmanNode min1 = tree.peek();
  		tree.poll();
  		HuffmanNode min2 = tree.peek();
  		tree.poll();
      
  		HuffmanNode x = new HuffmanNode();
  		x.frequency = min1.frequency +min2.frequency;
  		x.ascii =128;
  		x.left =min1;
  		x.right = min2;

  		root = x;
  		tree.add(x);
  	}
    

  	if (n>1)
  	GenerateCode(tree.peek(),"",codes);
    else
    	GenerateCode(tree.peek(),"1",codes);

  }

public static void GenerateCode(HuffmanNode root ,String code ,String [] codes)
	{
		if (root.left ==null && root.right ==null && root.ascii < 128)
		{
			codes[root.ascii] = code;
			
			return;
		}

		if(root.left!=null)
		GenerateCode(root.left ,code +"0",codes);

        if(root.right!=null)
		GenerateCode(root.right ,code +"1" ,codes);
	}
  
}