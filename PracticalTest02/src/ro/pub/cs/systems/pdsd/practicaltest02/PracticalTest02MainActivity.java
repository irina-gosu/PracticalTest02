package ro.pub.cs.systems.pdsd.practicaltest02;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PracticalTest02MainActivity extends Activity {

	
	private ServerThread serverThread             = null;
	private ClientThread clientThread             = null;
	
	public EditText     portEditText       = null;
	
	public Button 		connect = null;
	public EditText     hour    = null;
	public EditText     minute             = null;
	public Button       set = null;
	public Button       reset = null;
	public Button       poll = null;
	public TextView     textActive  = null;
	public TextView     textInactive  = null;
	public TextView     textNone  = null;
	
	
	private ConnectButtonClickListener connectButtonClickListener = new ConnectButtonClickListener();
	private class ConnectButtonClickListener implements Button.OnClickListener {
		
		@Override
		public void onClick(View view) {
			serverThread = new ServerThread(Integer.parseInt(portEditText.getText().toString()));
			
			if (!serverThread.isAlive()) {
				serverThread.start();
			}
		}
	}
	
	private SetButtonClickListener setButtonClickListener = new SetButtonClickListener();
	private class SetButtonClickListener implements Button.OnClickListener {
		
		@Override
		public void onClick(View view) {
			String op = "set";
			String clientAddress = "127.0.0.1";
			int port = Integer.parseInt(portEditText.getText().toString());
			Integer ora = Integer.parseInt(hour.getText().toString());
			Integer min = Integer.parseInt(minute.getText().toString());;
			clientThread = new ClientThread(ora, min, port, clientAddress, textInactive, op);
			
			if (!clientThread.isAlive()) {
				clientThread.start();
			}
		}
	}
	
	private ResetButtonClickListener resetButtonClickListener = new ResetButtonClickListener();
	private class ResetButtonClickListener implements Button.OnClickListener {
		
		@Override
		public void onClick(View view) {
//			serverThread = new ServerThread(Integer.parseInt(portEditText.getText().toString()));
//			
//			if (!serverThread.isAlive()) {
//				serverThread.start();
//			}
		}
	}
	
	private PollButtonClickListener pollButtonClickListener = new PollButtonClickListener();
	private class PollButtonClickListener implements Button.OnClickListener {
		
		@Override
		public void onClick(View view) {
//			serverThread = new ServerThread(Integer.parseInt(portEditText.getText().toString()));
//			
//			if (!serverThread.isAlive()) {
//				serverThread.start();
//			}
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test02_main);
        
        
        portEditText = (EditText)findViewById(R.id.portText);
        hour = (EditText)findViewById(R.id.ora);
        minute = (EditText)findViewById(R.id.minut);
            
        textActive = (TextView)findViewById(R.id.textactive);
        textInactive = (TextView)findViewById(R.id.inactive);
        textNone = (TextView)findViewById(R.id.none);
        
        connect = (Button)findViewById(R.id.buttonConnect);
        set = (Button)findViewById(R.id.buttonSet);
        reset = (Button)findViewById(R.id.buttonReset);
        poll = (Button)findViewById(R.id.buttonPoll);
        
        set.setOnClickListener(setButtonClickListener);
        reset.setOnClickListener(resetButtonClickListener);
        poll.setOnClickListener(pollButtonClickListener);
        
        connect.setOnClickListener(connectButtonClickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test02_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
