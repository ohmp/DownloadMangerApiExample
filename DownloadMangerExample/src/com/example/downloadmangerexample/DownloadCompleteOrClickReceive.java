package com.example.downloadmangerexample;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

public class DownloadCompleteOrClickReceive extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent intent) {
	
		 String action = intent.getAction();
		  DownloadManager dm = (DownloadManager)arg0. getSystemService(Activity.DOWNLOAD_SERVICE);
         if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)||DownloadManager.ACTION_NOTIFICATION_CLICKED.equals(action)) {
             long downloadId = intent.getLongExtra(
                     DownloadManager.EXTRA_DOWNLOAD_ID, 0);
             DownloadManager.Query query = new DownloadManager.Query();
             query.setFilterById(downloadId);
             Cursor c = dm.query(query);
             if (c.moveToFirst()) {
                 int columnIndex = c
                         .getColumnIndex(DownloadManager.COLUMN_STATUS);
                 if (DownloadManager.STATUS_SUCCESSFUL == c
                         .getInt(columnIndex)) {
                 
                     String uriString = c
                             .getString(c
                                     .getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
                 }else   if (DownloadManager.STATUS_RUNNING == c
                         .getInt(columnIndex)) {
                		Intent i = new Intent();
                		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
         		        i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
         		       arg0.startActivity(i);
                	 
                 }
             }
         }
	}

}
