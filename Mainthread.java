import Newthread.Newthread;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

class Mainthread {
	public static void  main(String args[] )
	{
		String filename = args[0];
		File directory = new File(filename);
         if (! directory.exists()){
       System.out.println("File not found");
       System.exit(0);
        
        }

		try{
		byte[] encoded = Files.readAllBytes(Paths.get(filename));
        String text = new String(encoded);
        String folder = filename.substring(0, filename.indexOf(".")) + "_compress";
    

		int length = text.length();
		Newthread thread1 = new Newthread(text.substring(0,length/4),"Thead 1","1"+filename,folder);
		Newthread thread2 = new Newthread(text.substring((length/4) +1,length/2),"Thead 2","2"+filename,folder);
		Newthread thread3 = new Newthread(text.substring((length/2)+1,(3*length)/4),"Thead 3","3"+filename,folder);
		Newthread thread4 = new Newthread(text.substring(((3*length)/4)+1,length-1),"Thead 1","4"+filename,folder);
		try {
				System.out.println("Waiting for threads to finish.");
				thread1.thread.join();
				thread2.thread.join();
				thread3.thread.join();
				thread4.thread.join();
			} catch (InterruptedException e) {
				System.out.println("Main thread Interrupted");
				}
		System.out.println("Main thread exiting.");
	}
	catch (IOException e){
		System.out.println("Main thread Interrupted");

	}
	}
}