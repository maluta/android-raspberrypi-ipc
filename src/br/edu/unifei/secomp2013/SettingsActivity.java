package br.edu.unifei.secomp2013;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends Activity {

	private static final String TAG = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		/*Bundle bundle = getIntent().getExtras();
		int value = bundle.getInt("some_key");
		String value2 = bundle.getString("some_other_key");*/
		
		Button b1 = (Button) findViewById(R.id.btn_save_settings);
		final EditText t1 = (EditText) findViewById(R.id.edt_ipaddress);
		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
				intent.putExtra("ip_address", t1.getText().toString());
				startActivity(intent);
			}
		});
		
		
		
	}
}