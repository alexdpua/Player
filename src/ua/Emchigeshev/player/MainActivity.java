package ua.Emchigeshev.player;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	private MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AssetManager assetsManager = getAssets();
		try {
			AssetFileDescriptor fd = assetsManager
					.openFd("1.mp3");
			mp = new MediaPlayer();
			mp.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(),
					fd.getLength());
			mp.prepare();
		} catch (Exception e) {
			throw new RuntimeException();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void PlayStop(View view) {
		if (mp.isPlaying()) {
			mp.pause();
		} else {
			mp.start();
		}
	}
	@Override
	public void onBackPressed() {
		finish();
		super.onBackPressed();
	}
	
	/*
	 * ExternalStorage  - sdcard
	 * InternalStorage  
	 * 
	 * Enviroment.getExternalStorage();
	 */

}
