package tableau;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Client {

	 public static void main(String argv[]){

	        int port =1000;
	     //   int[] tab ={1,2,-1};
	        try {
	        	File f=new File("file.in.txt");
	        	FileReader fr=new FileReader(f);
	    		
	    		BufferedReader br=new BufferedReader(fr);
	    		List<Integer> nbrs=new ArrayList<Integer>();
	    		String s;
	    		while ((s=br.readLine())!=null) {
	    			StringTokenizer st=new StringTokenizer(s," ");
	    			
	    			while (st.hasMoreTokens()) {
	    				
	    				nbrs.add(Integer.parseInt(st.nextToken()));
	    				
	    			}
	    			
				}
	    		br.close();
	    	//	String nbr=br.readLine();
	            Socket socket = new Socket(InetAddress.getLocalHost() , port );
	            

	            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

	           // outputStream.writeObject(tab);
	            outputStream.writeObject(nbrs);
	            outputStream.flush();


	            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

	            System.out.println(inputStream.readUTF());
	            System.out.println(inputStream.readUTF());







	        } catch (IOException e) {
	            e.printStackTrace();
	        }


	    }

}