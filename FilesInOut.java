

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.util.Scanner;

/**
 *
 * CSCU9T4 Java strings and files exercise.
 *
 */ 
  public class FilesInOut {
 	static private final int distenceforDateFirstChar = 23;
	private static String formattext = "";

  public static void main(String[] args) throws FileNotFoundException {
// Replace this with statements to set the file name (input) and file name (output).
 System.out.println("Enter the input file to be regesiterd:");
Scanner inputforFile = new Scanner(System.in);
File fileIn = new File(inputforFile.next());
Scanner in = new Scanner(fileIn);
System.out.println("Enter the output file:");
Scanner outPutFiles = new Scanner(System.in);
String fileforNames = outPutFiles.next();
File fileforOut = new File(fileforNames);
if(!fileforOut.exists()) {
System.out.println("invalid output file!!");
}
else if(fileforOut.exists()) {
// Initially it will be easier to hardcode suitable file names.
// Set up a new Scanner to read the input file.
String ofFormat;
do{
System.out.println("chose the format: (t)for title case. (u)for upper case.");
Scanner inForFormat = new Scanner(System.in);
ofFormat = inForFormat.next();
if(ofFormat.equals("t")) {
saveOutput(titleCase(in),fileforNames);
break;
}
else if(ofFormat.equals("u")) {
saveOutput(upperCaseLetters(in),fileforNames);
break;
}
else System.out.println("invalid input choise!!");
}while(ofFormat !="t" ||ofFormat !="u") ;
System.out.println("successfully formated...");
}
}

// Processing line by line would be sensible here.
// Initially, echo the text to System.out to check you are reading correctly.
// Then add code to modify the text to the output format. // Set up a new PrintWriter to write the output file.
// Add suitable code into the above processing (because you need to do this line by line also.
// That is, read a line, write a line, loop. // Finally, add code to read the filenames as arguments from the command line. //System.out.println("You need to add your own code to do anything"); } // main
	public static String upperCaseLetters(Scanner in) {
// TODO Auto-generated method stub\
		while (in.hasNextLine()) {
			String temp = "";
// first letter to upper
			if (in.hasNext()) {
				String nameOf = in.next();
				nameOf = nameOf.toUpperCase();
				temp += nameOf + " ";
				nameOf = in.next();
				temp += nameOf.toUpperCase();
				if (nameOf.length() == 1) {
					temp += ". ";
					nameOf = in.next();
					temp += nameOf.toUpperCase();
				}
			}
// setting space
			int difference = distenceforDateFirstChar - temp.length();
			for (int i = 1; i < difference; i++) {
				temp += " ";
			}
//date format
			String date = in.next();
			temp += date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, date.length()) + "\n";
			 formattext =  formattext + temp;
		}
		return  formattext;
	}

	public static String titleCase(Scanner in) {
		while (in.hasNextLine()) {
			String temp = "";
// first letter to upper case
//check for next
			if (in.hasNext()) {
				String nameOf = in.next();
				String firstLetter = nameOf.substring(0, 1);
				String remainder = nameOf.substring(1, nameOf.length());
				nameOf = firstLetter.toUpperCase() + remainder;
				temp += nameOf + " ";
				nameOf = in.next();
				firstLetter = nameOf.substring(0, 1);
				remainder = nameOf.substring(1,nameOf.length());
				nameOf = firstLetter.toUpperCase() + remainder;
				temp += nameOf;
				if (nameOf.length() == 1) {
					temp += ". ";
					nameOf = in.next();
					temp += nameOf.toUpperCase();
				}
			}
// setting space
			int differenceFor = distenceforDateFirstChar - temp.length();
			for (int i = 1; i < differenceFor; i++) {
				temp += " ";
			}
//date format
			String dateFor = in.next();
			temp += dateFor.substring(0, 2) + "/" + dateFor.substring(2, 4) + "/" + dateFor.substring(4, dateFor.length()) + "\n";
			formattext = formattext + temp;
		}
		return formattext;
	}

	public static void saveOutput(String jsonObj, String filePath) {
// write your code here
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filePath));
			writer.write(jsonObj);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
} // FilesInOut

