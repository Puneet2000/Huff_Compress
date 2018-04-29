package Encode;
public class Encode {

	String text;
	
	public Encode(String text )
	{
		this.text=text;
		
	}

	public String encode(String [] codes)
	{
		String result ="";
		for(int i=0;i<text.length();i++)
		{
			result = result + codes[text.charAt(i)];
		}
		return result;
	}
}