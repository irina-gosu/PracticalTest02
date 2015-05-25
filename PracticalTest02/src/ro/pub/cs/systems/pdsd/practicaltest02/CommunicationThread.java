package ro.pub.cs.systems.pdsd.practicaltest02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import android.util.Log;

public class CommunicationThread extends Thread {

	ServerThread serverThread;
	Socket socket;
	String TAG = "CommunicationThread";
	
	public CommunicationThread(ServerThread serverThread, Socket socket) {
		this.serverThread = serverThread;
		this.socket = socket;
	}
	

	@Override
	public void run() {
		
		if (socket != null) {
			
				
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost("http://www.timeapi.org/utc/now");
				List<NameValuePair> params = new ArrayList<NameValuePair>();       
				
				
			
		}
	}
}
//				params.add(new BasicNameValuePair("query", city));
//				UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
//				httpPost.setEntity(urlEncodedFormEntity);
//				ResponseHandler<String> responseHandler = new BasicResponseHandler();
//				String pageSourceCode = httpClient.execute(httpPost, responseHandler);
				
				
//				BufferedReader bufferedReader = Utilities.getReader(socket);
//				PrintWriter printWriter = Utilities.getWriter(socket);
//				
//				if (bufferedReader != null && printWriter != null) {
//					Log.i(TAG, "Waiting for parameters from client!" );
//					String op = bufferedReader.readLine();
//										

//						
//						printWriter.println(op);
//						printWriter.flush();
						
//					} else {
//						Log.e(TAG, "Error receiving parameters from client!");
//					}
//				} else {
//					Log.e(TAG, "BufferedReader / PrintWriter are null!");
//				}
//				socket.close();
//			} catch (IOException ioException) {
//				Log.e(TAG, "An exception has occurred: " + ioException.getMessage());
//				ioException.printStackTrace();
//			} catch (InterruptedException e) {
//				Log.e(TAG, "Can't sleep: " + e.getMessage());
//				e.printStackTrace();
//			} 
//		}
//	}
//}
//}
