package tableau;

import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serveur {

    public static void main(String argv[]){
        int port =1000;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            int [] tab = null;
            List<Integer> nbrs=new ArrayList<Integer>();
            while (true){

               Socket client = serverSocket.accept();

                ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());

                tab = (int[]) inputStream.readObject();
                nbrs= (List<Integer>) inputStream.readObject();

              //  int max = tab[0];
               // int min = tab[0];
                
                int max = nbrs.get(0);
                 int min = nbrs.get(0);
                for (int i=0;i< tab.length;i++){
                    if(max<nbrs.get(i)){
                        max = nbrs.get(i);
                    }

                    if(min > nbrs.get(i)){
                        min = nbrs.get(i);
                    }
                }


                DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
                
                File f1=new File("file.out.txt");
                
        		FileWriter fw=new FileWriter(f1,true);
        		
        		BufferedWriter bw=new BufferedWriter(fw);
        		bw.write(max);
        		bw.write("\n");
        		bw.write(min);
        		
                outputStream.writeUTF("Le max : "+max);
                outputStream.writeUTF("Le min  : "+min);


                outputStream.flush();


            }




        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}