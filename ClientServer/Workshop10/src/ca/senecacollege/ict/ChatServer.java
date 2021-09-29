package ca.senecacollege.ict;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**********************************************
Workshop 10
Course: JAC444
Last Name: Kapila
First Name: Shivani
ID: 113561179
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 21/04/11
**********************************************/

public class ChatServer {

	private static ArrayList<ChatClientEchoer> clients;

	public static void main(String [] args) {
		
			clients = new ArrayList<ChatClientEchoer>();
			try(ServerSocket chatSocket = new ServerSocket(4000)){
			while(true) {
					 
					 Socket socket = chatSocket.accept();
					 ChatClientEchoer echoer = new ChatClientEchoer(socket);
					 Thread thread = new Thread(echoer);
					 thread.start(); 
					 clients.add(echoer);

					} 
				} catch(IOException e) {
					System.out.println("Unable to listen on port " + e.getMessage());
					e.printStackTrace();
				}
			
	}
	
	
}
