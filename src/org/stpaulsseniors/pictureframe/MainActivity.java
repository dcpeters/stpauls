package org.stpaulsseniors.pictureframe;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

	private static String[] imageNames;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setBackgroundPicture("l1.jpg");
		
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						wait(3000);
					} catch (InterruptedException e) {
					}
					setBackgroundPicture("l2.jpg");
				}
				
			}
		});
	}

	public void setBackgroundPicture(String fileName) {
		ImageView imageView = new ImageView(getApplicationContext());
		LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		InputStream s;
		try {
			s = getAssets().open("l1.jpg");
		} catch (IOException e) {
			throw new RuntimeException("IO error");
		}
		Bitmap image = BitmapFactory.decodeStream(s);
		imageView.setImageBitmap(image);
		imageView.setLayoutParams(lp);
		setContentView(imageView);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
