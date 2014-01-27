package com.example.notificationtest;

import java.util.Calendar;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	public final String TAG = MainActivity.class.getName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d(TAG, "onClick");
				
				//ŒÄ‚Ño‚·“ú‚ğİ’è‚·‚é
				Calendar triggerTime = Calendar.getInstance();
				triggerTime.add(Calendar.SECOND, 5);	//¡‚©‚ç5•bŒã
				
				//İ’è‚µ‚½“ú‚Å”­s‚·‚éIntent‚ğ¶¬
				Intent intent = new Intent(MainActivity.this, Notifier.class);
				PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

				AlarmManager manager = (AlarmManager)getSystemService(ALARM_SERVICE);
				manager.set(AlarmManager.RTC_WAKEUP, triggerTime.getTimeInMillis(), sender);
				
				finish();
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
