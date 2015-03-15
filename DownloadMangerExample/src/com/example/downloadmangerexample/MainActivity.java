package com.example.downloadmangerexample;

import android.support.v7.app.ActionBarActivity;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	private DownloadManager dm;
	private long enqueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Button download =(Button)findViewById(R.id.download);
         Button check =(Button)findViewById(R.id.check);
         download.setOnClickListener(new OnClickListener() {
			
		
			@Override
			public void onClick(View v) {
				  dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request request = new Request(
			                Uri.parse("http://sample-videos.com/video/mp4/720/big_buck_bunny_720p_10mb.mp4"));
			        //Uri.parse("http://techslides.com/demos/sample-videos/small.mp4"));
			        enqueue = dm.enqueue(request);
			}
		});
         check.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				Intent i = new Intent();
 		        i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
 		        startActivity(i);
 				
 			}
 		});
         
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
