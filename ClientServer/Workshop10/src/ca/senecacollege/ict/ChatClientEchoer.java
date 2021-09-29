package ca.senecacollege.ict;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

public class ChatClientEchoer extends ChatServer implements Runnable{
	
	private Socket socket;
	private PrintWriter writer;
	private static ArrayList<ChatClientEchoer> clients;

	public ChatClientEchoer(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			
			while(true) {
				
				String echoString = input.readLine();
				System.out.println("Received Client Input: " + echoString);
				if(echoString != null) {
					for(ChatClientEchoer client: clients) {
						writer.println(echoString);
						client.getWriter().write(echoString);
					}
				}
				
			}
		} catch(IOException e) {
			System.out.println("Oooops " + e.getMessage());
		} finally {
			try {
				socket.close();
			}catch(IOException e) {
				// later
			}
		}
		
	}
	
	public PrintWriter getWriter() {
		return writer;
	}

}
