package ca.senecacollege.ict;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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

public class ChatClient {
	
	 public static void main(String[] args) {

	        try (Socket socket = new Socket("localhost", 4000)) {
	        	
	            BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

	            Scanner scanner = new Scanner(System.in);
	            String echoString;
	            String response;

	            do {
	                System.out.println("Enter text: ");
	                echoString = scanner.nextLine();

	                stringToEcho.println(echoString);
	                if(!echoString.equals("exit")) {
	                    response = echoes.readLine();
	                    System.out.println(response);
	                }
	            } while(!echoString.equals("exit"));

	        } catch (IOException e) {
	            System.out.println("Client Error: " + e.getMessage());

	        }
	    }

}
