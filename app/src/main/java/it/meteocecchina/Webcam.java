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
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.os.AsyncTask;


public class Webcam extends Activity{

	private ImageView imgWebcam;
	
    private ProgressDialog pd;

    String cecchina = "http://meteocecchina.it/webcam/webcam.php";
	String ariccia = "http://www.meteoariccia.it/webcam.jpg";
	String pomezia = "http://www.pomeziameteo.altervista.org/webcam_canon/cam.jpg";
	String rpapa = "http://li1830.myfoscam.org:88/cgi-bin/CGIProxy.fcgi?cmd=snapPicture2&usr=guest&pwd=Guest123";
	String velletri = "http://www.meteovelletri.it/webcam_crocefissi/image.jpg";


	
	public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.main_webcam);

		        imgWebcam =(ImageView)findViewById(R.id.imgWebcam);
		        //imgWebcam.setOnTouchListener(new Touch());  
		        //se metto questo usa la classe touch per zoomare 
		        //l'immagine col pinch to zoom!!nell'xml pero devo aggiungere questo nella imageview
		    	//android:scaleType="matrix"  
		    	//android:adjustViewBounds="true"  
		    	//android:layout_gravity="center"
		        
		        
		        
                pd = ProgressDialog.show(Webcam.this,"Download immagine","Attendi...",true,false);
                pd.setCancelable(true);
                AsTask task3 = new AsTask();
                task3.execute("cecchina");
		        


	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Cecchina").setOnMenuItemClickListener(new OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				pd = ProgressDialog.show(Webcam.this,"Download immagine","Attendi...",true,false);
				Webcam.AsTask task2 = new Webcam.AsTask();
				task2.execute("cecchina");
				return true;
			}
		});;
		menu.add("Ariccia").setOnMenuItemClickListener(new OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				pd = ProgressDialog.show(Webcam.this,"Download immagine","Attendi...",true,false);
				Webcam.AsTask task2 = new Webcam.AsTask();
				task2.execute("ariccia");
				return true;
			}
		});;
		menu.add("Pomezia").setOnMenuItemClickListener(new OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				pd = ProgressDialog.show(Webcam.this,"Download immagine","Attendi...",true,false);
				Webcam.AsTask task2 = new Webcam.AsTask();
				task2.execute("pomezia");
				return true;
			}
		});;
		menu.add("R.Di Papa").setOnMenuItemClickListener(new OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				pd = ProgressDialog.show(Webcam.this,"Download immagine","Attendi...",true,false);
				Webcam.AsTask task2 = new Webcam.AsTask();
				task2.execute("rpapa");
				return true;
			}
		});;
		menu.add("Velletri").setOnMenuItemClickListener(new OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				pd = ProgressDialog.show(Webcam.this,"Download immagine","Attendi...",true,false);
				Webcam.AsTask task2 = new Webcam.AsTask();
				task2.execute("velletri");
				return true;
			}
		});;
    	return true;
	}
	Bitmap bmImgWebcam;

	private class AsTask extends AsyncTask<String,Void,Void> {
		@Override
		protected Void doInBackground(String... params) {
			String v = params[0];
			if(v == "cecchina"){
				downloadFile(cecchina);
			}
			if(v == "ariccia"){
				downloadFile(ariccia);
			}
			if(v == "pomezia"){
				downloadFile(pomezia);
			}
			if(v == "rpapa"){
				downloadFile(rpapa);
			}
			if(v == "velletri"){
				downloadFile(velletri);
			}
			return null;
		}
		protected void onProgressUpdate(Void... values) {
	         // aggiorno la progress dialog
	         pd.setMessage("download");
	      }
		 protected void onPostExecute(Void result) {
	         // chiudo la progress dialog
			 imgWebcam.setImageBitmap(bmImgWebcam);
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

	bmImgWebcam = BitmapFactory.decodeStream(is);
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
		}
	}

}
