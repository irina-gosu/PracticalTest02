package ro.pub.cs.systems.pdsd.practicaltest02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import android.util.Log;
import android.widget.TextView;


public class ClientThread extends Thread {

	String TAG = "ClientThread";
	
	public String address;
	public int port;
	public TextView text;
	public Integer hour;
	public Integer minute;
	public Socket socket;
	public String op;
	
	public ClientThread (Integer hour, Integer minute, int port, String address, TextView text, String op) {
		this.address = address;
		this.port = port;
		this.text = text;
	}
	
	@Override
	public void run() {
		try {
			socket = new Socket(address, port);
			if (socket == null) {
				Log.e(TAG, "Could not create socket!");
			}
			
			BufferedReader bufferedReader = Utilities.getReader(socket);
			PrintWriter printWriter = Utilities.getWriter(socket);
			if (bufferedReader != null && printWriter != null) {
				printWriter.println(op);
				printWriter.flush();
				String rezText;
				while ((rezText = bufferedReader.readLine()) != null) {
					final String finalizedRezText = rezText;
					text.post(new Runnable() {
						@Override
						public void run() {
							text.setText(finalizedRezText);
						}
					});
				}
			}
		} catch (IOException ioException) {
			Log.e(TAG, "An exception has occurred: " + ioException.getMessage());
			ioException.printStackTrace();
		}
	
	}
}
