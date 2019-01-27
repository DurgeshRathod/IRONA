/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package server;
//This is the file to run on all client machines.........................................................................

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;


/**
 *
 * @author Durgesh
 */
public class Client {



    public static void main(String[] args) throws Exception{

Socket socket;
int fileSizeFromClient;
FileOutputStream fos = null;
BufferedInputStream bis = null;
BufferedOutputStream bos = null;
DataInputStream dis = null;
DataOutputStream dos = null;


    int bufferSize = 0;
//---------------------------------------------------------------------------------------------------------------------
/*
  	      // TODO code application logic here
    	ServerSocket servsock = new ServerSocket(12345);
   	 File myFile = new File("C:\\Users\\Namrata\\Desktop\\ComSIS_nst-4604.pdf");
    	myFile.createNewFile();
	
   	 while (true) {
    		  Socket sock = servsock.accept();
	System.out.println("found a socket ...connecting...");
 		byte[] mybytearray = new byte[(int) myFile.length()];
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
      bis.read(mybytearray, 0, mybytearray.length);
      OutputStream os = sock.getOutputStream();
      os.write(mybytearray, 0, mybytearray.length);
	System.out.println("File Recieved Successfully");
      os.flush();
      sock.close();
System.out.println(" Send next Software.......");  */

//---------------------------------------------------------------------------------------------------------------------
       //---------------------------------------------------------------------------------------------------------------------


 try {

    	ServerSocket servsock = new ServerSocket(12345);

System.out.println("........................Waiting.............................");
Socket sock = servsock.accept();
System.out.println("........................connected.............................");


     bis = new BufferedInputStream(sock.getInputStream());
     dis = new DataInputStream(bis);

     fileSizeFromClient = dis.readInt();
     System.out.println("file size from client is " + fileSizeFromClient);

      File fileDirectory = new File("C:/DOWNLOAD/");
        if (!fileDirectory.exists()) {
            fileDirectory.mkdir();
      }



      File file = new File("C:/Users/Shreegeet/Desktop/Server final proj/transfer.exe");
      file.createNewFile();
   

       fos = new FileOutputStream(file);
       bos = new BufferedOutputStream(fos);
       dos = new DataOutputStream(bos);

       byte[] buffer = new byte[fileSizeFromClient];

      int totalBytesRead = 0;

        while(totalBytesRead < fileSizeFromClient){
            int bytesRemaining = fileSizeFromClient - totalBytesRead;
            int bytesRead = dis.read(buffer, 0, (int) Math.min(buffer.length, bytesRemaining));
            if(bytesRead == -1) {
                break;
            } else {
                dos.write(buffer, 0, bytesRead); 
                    totalBytesRead += bytesRead;

                    
            }
        } // while
        

        System.out.println("Runninng the installation");
        Runtime rt=Runtime.getRuntime();
        Process p=rt.exec("cmd.exe /c transfer.exe /VERYSILENT /SUPPRESSMSGBOXES /NORESTART /SP-");

        System.out.println("Done");


 }//try

catch(Exception e)
{System.out.println(e);}

    }
    
}

