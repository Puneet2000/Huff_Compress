import java.util.Arrays;
import MakeHuffmanTree.MakeHuffmanTree;
import Encode.Encode;
import java.util.BitSet;
import java.io.FileOutputStream; 
import java.io.IOException;


class test {

public static void main(String args[])
{
	
	
	String text = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	String [] codes = new String [128];
	for (int i=0;i<128;i++)
		codes[i]="";
	MakeHuffmanTree tree = new MakeHuffmanTree(text);
	tree.MakeTree(codes);
	Encode en = new Encode(text);

	String res ="";
	res = en.encode(codes);

	BitSet bits = new BitSet(res.length());
	for(int i=0;i<res.length() ;i++)
		bits.set(i);
	byte[] bytes = new byte[bits.length()/8+1];
    for (int i=0; i<bits.length(); i++) {
        if (bits.get(i)) {
            bytes[bytes.length-i/8-1] |= 1<<(i%8);
        }
    }
    
		try (FileOutputStream fileOuputStream = new FileOutputStream("./abc.txt")) {
            fileOuputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }


	

}
}