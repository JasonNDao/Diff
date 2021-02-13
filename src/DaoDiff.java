//Jason Dao ACSL#2
import java.io.*;
import java.util.Scanner;
public class DaoDiff {
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(new File("C:\\\\Users\\\\Jason Dao\\\\Documents\\\\Eclipse Workspace\\\\Dao's Diff\\\\Input"));
		String ListStrings[]=new String[14];         //Reads input with spaces between 2 string statements
		String a,b,c,d,e,f,g,h,i,j;
		for (int k=0;k<ListStrings.length;k++)                                     //Puts all lines separate arrays
		{
			ListStrings[k]=s.nextLine();
		}
		for (int l=0;l<=14;l+=3)                                                    //Runs Program
		{
			String length1[]=ListStrings[l].split(" ");                             //Puts first string into array
			String length2[]=ListStrings[l+1].split(" ");                           //Puts second string into array
			a=diff(length1,length2);                                                //Runs first algorithm with first array
			String length3[]=ListStrings[l+1].split(" ");                           //Puts second string into array
			String length4[]=ListStrings[l].split(" ");                             //Puts first string into array
			b=diff(length3,length4);                                                //Runs first algorithm with second array
			System.out.println(second(a,b));                                        //Runs second algorithm
		}
	}
public static String diff(String [] a,String [] b)
{
	String r="";
	int counter=1;
	String length3[]=new String[100];                                               //Declares array for first string to break into letters
	String length4[]=new String[100];                                               //Declares array for second string to break into letters
	for (int i=0;i<a.length;i++)
	{
		for (int k=0;k<a[i].length();k++)                                           //Breaks first string into letters into different elements
		{
			 length3[k]=a[i].substring(k,k+1);
		}
		outerloop:
		for (int j=0;j<b.length;j++)
		{	
			for (int l=0;l<b[j].length();l++)                                       //Breaks second string into letters into different elements
			{
				 length4[l]=b[j].substring(l,l+1);
			}
			if (a[i].equals(b[j]))                                                  //Finds similar WORDS
			{
				r+=a[i] + " ";                                                      //if words are same add them into return string
				b[j]=" ";                                                           //erases added word from second string
				break outerloop;
			}
			else
			{ 
				if (b[j].length()>a[i].length())                                    //if first word is longer or equal does not work
				{
					for (int m=0;m<b[j].length();m++)                              
					{
						if (length3[0].equals(length4[m]) && a[i].length()>1)       //sees if first letter in first word matches anything in second string
						{
							for (int n=m+1;n<a[i].length()+m;n++)
							{
								if (length3[counter].equals(length4[n]))            //if does, continues to match to see if they are the same
								{
									counter++;
									if ( n==a[i].length()+m-1)                      //if they do match, word is added into return string
									{
										r+=a[i] + " ";
										b[j]=" ";                                   //word is removed from second string
										counter=1;
										break outerloop;
									}
								}
								else                                                //if words are different after first same letter, breaks
								{
									break;
								}
							}
						}
						if (length3[0].equals(length4[m]) && a[i].length()==1)      //if word is one letter and matches, adds to return statement
						{
							r+=a[i]+ " ";
							break outerloop;
						}
					}
				}
			}
		}
	}
	return r;                                                                       //return string
}
public static String second(String a,String b)
{
	String c="";                                            
	String r[]=new String[a.length()];                                              //arrays to turn words of first algorithm into array of letters
	String s[]=new String[b.length()];
	int start=0;
	for (int i=0;i<a.length();i++)                                                  //turns Diff A to B into array of letters
	{
		r[i]=a.substring(i, i+1);
	}
	for (int j=0;j<b.length();j++)                                                  //turns Diff B to A into array of letters
	{
		s[j]=b.substring(j, j+1);
	}
	for (int i=0;i<a.length();i++)                                                  
	{
		for (int j=start;j<b.length();j++)
		{
			if (r[i].equals(s[j]) && (!(r[i].equals(" "))))                         //if letters match, added to return string
			{
				c+=r[i];
				start=j+1;                                                          //all letters before removed
				break;
			}
		}
	}
	if (c.equals(""))                                                               //if empty, prints None
	{
		c+="NONE";
	}
	return c;
}
}
