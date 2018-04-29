package Newthread;
import java.util.Arrays;
import MakeHuffmanTree.MakeHuffmanTree;
import Encode.Encode;
import java.util.BitSet;
import java.io.FileOutputStream; 
import java.io.IOException;
import java.io.File;

public class Newthread implements Runnable {
	String text;
	String name;
	String filename;
	String folder;
	public Thread thread;

	public Newthread(String text,String name ,String filename ,String folder)
	{
		this.text=text;
		this.name=name;
		this.filename = filename;
		this.folder = folder;
		thread = new Thread(this,name);
		System.out.println(name+" started...");
		thread.start();
	}

	public void run()
	{
	    String [] codes = new String [128];

		for (int i=0;i<128;i++)
			codes[i]="";

		MakeHuffmanTree tree = new MakeHuffmanTree(text);

		tree.MakeTree(codes);

		Encode en = new Encode(text);

		String result ="";
		result = en.encode(codes);
      
		BitSet bits = new BitSet(result.length());
		for(int i=0;i<result.length() ;i++)
			bits.set(i);

		byte[] bytes = new byte[bits.length()/8+1];

	    for (int i=0; i<bits.length(); i++) {
	        if (bits.get(i)) {
	            bytes[bytes.length-i/8-1] |= 1<<(i%8);
	        }
	    }
	    
	    File directory = new File(folder);
      if (! directory.exists()){
        directory.mkdir();
        
      }
		try (FileOutputStream fileOuputStream = new FileOutputStream("./"+folder+"/"+filename)) {
	        fileOuputStream.write(bytes);
	    } catch (IOException e) {
	            e.printStackTrace();
	    }
	}
}