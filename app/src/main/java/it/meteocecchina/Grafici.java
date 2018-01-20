package it.meteocecchina;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.os.AsyncTask;

public class Grafici extends Activity{
	
	private ImageView imgGraph;

    private ProgressDialog pd;

	
    String temp = "http://meteocecchina.it/wview/tempdaycomp.png";
    String wspeed = "http://meteocecchina.it/wview/wspeeddaycomp.png";
    String wdir = "http://www.meteocecchina.it/wview/wdirday.png";
    String rain = "http://meteocecchina.it/wview/rainday.png";
    String barom = "http://meteocecchina.it/wview/baromday.png";
    String humid = "http://meteocecchina.it/wview/humidday.png";
    
	
	public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.main_grafici);
		        
		        imgGraph =(ImageView)findViewById(R.id.imgGraph);
	        	     
                pd = ProgressDialog.show(Grafici.this,"Download immagine","Attendi...",true,false);
                pd.setCancelable(true);
                AsTask task2 = new AsTask();
                task2.execute("temp");
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add("Temp").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
                pd = ProgressDialog.show(Grafici.this,"Download immagine","Attendi...",true,false);
                AsTask task2 = new AsTask();
                task2.execute("temp");
    			return true;
    		}
    	});;
    	menu.add("Vento").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
                pd = ProgressDialog.show(Grafici.this,"Download immagine","Attendi...",true,false);
                AsTask task2 = new AsTask();
                task2.execute("wspeed");
    			return true;
    		}
    	});;
    	menu.add("Dir.Vento").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
                pd = ProgressDialog.show(Grafici.this,"Download immagine","Attendi...",true,false);
                AsTask task2 = new AsTask();
                task2.execute("wdir");
    			return true;
    		}
    	});;
    	menu.add("Pioggia").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
                pd = ProgressDialog.show(Grafici.this,"Download immagine","Attendi...",true,false);
                AsTask task2 = new AsTask();
                task2.execute("rain");
    			return true;
    		}
    	});;
    	menu.add("Pressione").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
                pd = ProgressDialog.show(Grafici.this,"Download immagine","Attendi...",true,false);
                AsTask task2 = new AsTask();
                task2.execute("barom");
				return true;
			}
    	});;
    	menu.add("Umidita").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
                pd = ProgressDialog.show(Grafici.this,"Download immagine","Attendi...",true,false);
                AsTask task2 = new AsTask();
                task2.execute("humid");
    			return true;
    		}
    	});;
    	return true;
	}
	
	Bitmap bmImgGraph;
	
	private class AsTask extends AsyncTask<String,Void,Void> {
		@Override
		protected Void doInBackground(String... params) {
			// TODO Auto-generated method stub
			String v = params[0];
			if(v == "temp"){
	        downloadFile(temp);
			}
			if(v == "wspeed"){
		    downloadFile(wspeed);
			}
			if(v == "wdir"){
		    downloadFile(wdir);
			}
			if(v == "rain"){
			downloadFile(rain);
			}
			if(v == "barom"){
			downloadFile(barom);
			}
			if(v == "humid"){
			downloadFile(humid);
			}
			return null;
		}
		protected void onProgressUpdate(Void... values) {
	         // aggiorno la progress dialog
	         pd.setMessage("download");
	      }
		 protected void onPostExecute(Void result) {
	         // chiudo la progress dialog
			 imgGraph.setImageBitmap(bmImgGraph);
	         pd.dismiss();
		 }

		
	}
	
	void downloadFile(String fileUrl){
	URL myFileUrl =null; 
	try {
	myFileUrl= new URL(fileUrl);
	} catch (MalformedURLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	try {
	HttpURLConnection conn= (HttpURLConnection)myFileUrl.openConnection();
	conn.setDoInput(true);
	conn.connect();
	InputStream is = conn.getInputStream();

	bmImgGraph = BitmapFactory.decodeStream(is);
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
		}
	}
	
	
	
	

}

	