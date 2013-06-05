package br.edu.unifei.secomp2013;


import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import tutorial.Calculator;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = null;
	TTransport transport;
	TProtocol protocol;
	Calculator.Client client;
	String ip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button b1 = (Button) findViewById(R.id.button1);
		final Button b2 = (Button) findViewById(R.id.button2);
		final Button b3 = (Button) findViewById(R.id.button3);
		final Button b4 = (Button) findViewById(R.id.button4);
		final Button b5 = (Button) findViewById(R.id.button5);
		final Button b6 = (Button) findViewById(R.id.button6);
		final Button b7 = (Button) findViewById(R.id.button7);
		final Button button_connect = (Button) findViewById(R.id.btn_connect);

		b1.setVisibility(View.INVISIBLE);
		b2.setVisibility(View.INVISIBLE);
		b3.setVisibility(View.INVISIBLE);
		b4.setVisibility(View.INVISIBLE);
		b5.setVisibility(View.INVISIBLE);
		b6.setVisibility(View.INVISIBLE);
		b7.setVisibility(View.INVISIBLE);

		final TextView t1 = (TextView) findViewById(R.id.server_ip);

		try {
			Bundle bundle = getIntent().getExtras();
			ip = bundle.getString("ip_address");
			t1.setText(ip);
		} catch (NullPointerException ex) {
			ip="192.168.1.7";
		}
		t1.setText(ip);

		//JavaClient jc = new JavaClient();
		button_connect.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				boolean on = false;
				Log.e(TAG,"connect");
				//Toast.makeText(getApplicationContext(), "Connectando...", Toast.LENGTH_LONG).show();

				try {
					transport = new TSocket(ip, 9090);
					transport.open();

					protocol = new  TBinaryProtocol(transport);
					client = new Calculator.Client(protocol);
					on = true;
				} catch (TException x) {
					Log.e(TAG,"error on connecting");
				} 

				if (on) {
					b1.setVisibility(View.VISIBLE);
					b2.setVisibility(View.VISIBLE);
					b3.setVisibility(View.VISIBLE);
					b4.setVisibility(View.VISIBLE);
					b5.setVisibility(View.VISIBLE);
					b6.setVisibility(View.VISIBLE);
					b7.setVisibility(View.VISIBLE);
				}
				//SetColors(1);
			}
		});

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e(TAG,""+v.getId());
				//client.add(1, arg1)
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
		Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
		startActivity(intent);
		return super.onOptionsItemSelected(item);
	}

	public void SetColors(int id) {

		/*try {
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
		} */
	}
}