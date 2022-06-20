package NGT_ASSIGNMENT_JAVA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class ConvertDoxtoTxt {

	static void writeOutput(String str) {
		  
	       try {
	           FileOutputStream fos = new FileOutputStream("./Resources/resume.txt");
	           Writer out = new OutputStreamWriter(fos, "ASCII");
	           out.write(str);
	           out.close();
	       } 
	       catch (IOException e) {
	           e.printStackTrace();
	       }
	   }
	 
	   static String readInput() {
	  
	      StringBuffer buffer = new StringBuffer();
	      try {
	          FileInputStream fis = new FileInputStream("./resume.doc");
	          InputStreamReader isr = new InputStreamReader(fis, "ASCII");
	          Reader in = new BufferedReader(isr);
	          int ch;
	          while ((ch = in.read()) > -1) {
	             buffer.append((char)ch);
	          }
	          in.close();
	          return buffer.toString();
	      } catch (IOException e) {
	          e.printStackTrace();
	          return null;
	      }
	   }

}