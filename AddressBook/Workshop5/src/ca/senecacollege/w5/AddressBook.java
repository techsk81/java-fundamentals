package ca.senecacollege.w5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**********************************************
Workshop 5
Course: JAC444
Last Name: Kapila
First Name: Shivani
ID: 113561179
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 21/03/06
**********************************************/

public class AddressBook extends Application {

	final int FNAME = 52;
	final int LNAME = 52;
	final int CITY = 20;
	final int PROVINCE = 20;
	final int POSTAL_CODE = 7;

	int pos;
	int count = 0;

	TextField fn = new TextField();
	TextField ln = new TextField();
	TextField city = new TextField();
	ComboBox<String> provinces = new ComboBox<String>();
	TextField pc = new TextField();
	
	static final String filePath = "addressbook.dat";

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage ps) throws Exception {

		GridPane addressPane = new GridPane();
		addressPane.setAlignment(Pos.BASELINE_CENTER);
		addressPane.setHgap(5);
		addressPane.setVgap(5);

		addressPane.setPadding(new Insets(40, 40, 40, 40));

		addressPane.add(new Label("First Name: "), 0, 0);
		addressPane.add(fn, 1, 0);
		fn.setText("John");

		if (fn.getText().trim().equals("")) {
			System.out.println("Please enter the first name...");
		}

		addressPane.add(new Label("Last Name: "), 0, 1);
		addressPane.add(ln, 1, 1);
		ln.setText("Lin");

		addressPane.add(new Label("City: "), 0, 2);
		addressPane.add(city, 1, 2);
		city.setText("Toronto");

		addressPane.add(new Label("Province: "), 0, 3);
		provinces.getItems().addAll("Alberta", "British Columbia", "Manitoba", "New Brunswick",
				"Newfoundland and Labrador", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec",
				"Saskatchewan");
		addressPane.add(provinces, 1, 3);
		provinces.setValue("Select Province");

		addressPane.add(new Label("Postal Code: "), 0, 4);
		addressPane.add(pc, 1, 4);
		pc.setText("S5V7U1");

		HBox buttons = new HBox();
		buttons.setSpacing(5);

		Button add = new Button("Add");
		Button first = new Button("First");
		Button next = new Button("Next");
		Button previous = new Button("Previous");
		Button last = new Button("Last");
		Button update = new Button("Update");

		buttons.getChildren().addAll(add, first, next, previous, last, update);
		addressPane.add(buttons, 0, 5, 5, 1);

		add.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				fn.clear();
				ln.clear();
				city.clear();
				pc.clear();

				if (fn.getText().contains("") && ln.getText().contains("") && pc.getText().contains("")) {

					System.out.println("Please fill...");
				
				} 
				
				System.out.println("Contact is added.");

				String fns = fn.getText();
				String lns = ln.getText();
				String citys = city.getText();
				String province = provinces.getValue();
				String postalcode = pc.getText();

				try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");) {

					long fileLength = filePath.length();

					file.seek(fileLength);
					file.writeBytes(fns + "\n");
					file.writeBytes(lns + "\n");
					file.writeBytes(citys + "\n");
					file.writeBytes(province + "\n");
					file.writeBytes(postalcode + "\n");

					System.out.println(filePath);

					file.close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		});

		first.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Contact is stored");

				try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");) {

					long fileLength = filePath.length();

					if (count > 0) {

						file.seek(fileLength);
						read(file);

					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		});

		next.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Next contact");

				try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");) {

					long fileLength = filePath.length();

					if (count * 10 > fileLength) {

						file.seek(count * 10 - 10);
						read(file);
						count++;

					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		});

		previous.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Previous contact");

				try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");) {

					if (count > 1) {

						count--;

					} else {

						count = 1;
						file.seek(count * 10 - 10);
						read(file);
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		});

		last.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Last contact");

				try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");) {

					long fileLength = filePath.length();

					count = (int) (fileLength / 10);
					file.seek(count * 10 - 10);
					read(file);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		});

		update.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Contact is updated");

				byte[] fns = fn.getText().getBytes();
				byte[] lns = ln.getText().getBytes();
				byte[] citys = city.getText().getBytes();
				byte[] province = provinces.getValue().getBytes();
				byte[] postalcode = pc.getText().getBytes();

				try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");) {

					long fileLength = filePath.length();
					boolean record = false;

					if (record == true) {

						while (file.getFilePointer() < fileLength) {

							file.seek(count * 10 - 10);
							file.writeBytes(file.readLine());

							file.writeBytes(fns + "\n");
							file.writeBytes(lns + "\n");
							file.writeBytes(citys + "\n");
							file.writeBytes(province + "\n");
							file.writeBytes(postalcode + "\n");
							file.close();
						}

					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});

		Scene sc = new Scene(addressPane, 500, 300);

		ps.setTitle("Address Book");
		ps.setScene(sc);
		ps.show();

	}

	public void read(RandomAccessFile file) throws IOException {

		String fns = fn.getText();
		String lns = ln.getText();
		String citys = city.getText();
		String province = provinces.getValue();
		String postalCode = pc.getText();

		file.readByte();

		byte[] fname = new byte[FNAME];
		pos = file.read(fname);
		file.writeBytes(fns + "\n");

		byte[] lname = new byte[LNAME];
		pos = file.read(lname);
		file.writeBytes(lns + "\n");

		byte[] city = new byte[CITY];
		pos = file.read(city);
		file.writeBytes(citys + "\n");

		byte[] provinceB = new byte[PROVINCE];
		pos = file.read(provinceB);
		file.writeBytes(province + "\n");

		byte[] postalCodeB = new byte[POSTAL_CODE];
		pos = file.read(postalCodeB);
		file.writeBytes(postalCode + "\n");


	}
}
