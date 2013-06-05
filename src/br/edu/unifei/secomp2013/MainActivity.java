package br.edu.unifei.secomp2013;


import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import tutorial.Calculator;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);
		Button b5 = (Button) findViewById(R.id.button5);
		Button b6 = (Button) findViewById(R.id.button6);
		Button b7 = (Button) findViewById(R.id.button7);

		//JavaClient jc = new JavaClient();

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e(TAG,""+v.getId());
				SetColors(1);
			}
		});

		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e(TAG,""+v.getId());


			}
		});

		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e(TAG,""+v.getId());
			}
		});

		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e(TAG,""+v.getId());
			}
		});

		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e(TAG,""+v.getId());
			}
		});

		b6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e(TAG,""+v.getId());
			}
		});

		b7.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e(TAG,""+v.getId());
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.e(TAG,""+item.getItemId());

		showMsg("Ok");
		return super.onOptionsItemSelected(item);
	}

	private void showMsg(String msg) {
		EditText e = new EditText(getApplicationContext());
		//	Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
		Toast toast = Toast.makeText(this, e.getText().toString(), Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, toast.getXOffset() / 2, toast.getYOffset() / 2);
		toast.show();
	}


	public void SetColors(int id) {

		try {
			TTransport transport;
			transport = new TSocket("192.168.1.7", 9090);
			transport.open();

			TProtocol protocol = new  TBinaryProtocol(transport);
			Calculator.Client client = new Calculator.Client(protocol);

			switch (id) {
			case 1: client.add(1, 1); break;
			case 2: client.add(2, 2); break;
			case 3: client.add(3, 3); break;
			case 4: client.add(4, 4); break;
			case 5: client.add(5, 5); break;
			case 6: client.add(6, 6); break;
			case 7: client.add(7, 7); break;
			}

			transport.close();
		} catch (TException x) {
			x.printStackTrace();
		} 
	}
}