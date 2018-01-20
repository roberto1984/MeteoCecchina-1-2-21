package it.meteocecchina;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import android.R.string;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import android.widget.ImageView;





public class Attuali extends Activity {
	// Dichiarazione oggetti
    TextView temperatura;
    TextView umidita;
    TextView pressione;
    TextView ventom;
    TextView ventoDir;
    TextView pioggia;
    TextView dewpoint;
    TextView heatIndex;
    TextView rainRate;
    TextView data;
    TextView Intestazione;
    ImageView tempImm;
    ImageView humImm;
    ImageView pressImm;
    ImageView windmImm;
    ImageView windDirImm;
    ImageView rainImm;
    ImageView dewImm;
    ImageView hIndexImm;
    ImageView rRateImm;
    //Button btnImport;
    //Button btnImport2;
    //Button btnImport3;
    
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            Log.i("main", "BEGIN");
            setContentView(R.layout.main_attuali); //Carico layout
            
            // Inizializzo gli  oggetti
            temperatura = (TextView) findViewById(R.id.temperatura);
            umidita = (TextView) findViewById(R.id.umidita);
            pressione = (TextView) findViewById(R.id.pressione);
            ventom = (TextView) findViewById(R.id.ventom); 
            ventoDir = (TextView) findViewById(R.id.ventoDir);
            pioggia = (TextView) findViewById(R.id.pioggia);
            dewpoint = (TextView) findViewById(R.id.dewpoint);
            heatIndex = (TextView) findViewById(R.id.heatIndex);
            rainRate = (TextView) findViewById(R.id.rainRate);
            data = (TextView) findViewById(R.id.data);
            Intestazione = (TextView) findViewById(R.id.intestazione);

              
            tempImm = (ImageView) findViewById(R.id.tempImage);
            tempImm.setImageResource(R.drawable.temper);
            humImm = (ImageView) findViewById(R.id.humImage);
            humImm.setImageResource(R.drawable.humid);
            pressImm = (ImageView) findViewById(R.id.pressImage);
            pressImm.setImageResource(R.drawable.press);
            windmImm = (ImageView) findViewById(R.id.windmImage);
            windmImm.setImageResource(R.drawable.windm);  
            windDirImm = (ImageView) findViewById(R.id.windDirImage);
            windDirImm.setImageResource(R.drawable.windd);  
            rainImm = (ImageView) findViewById(R.id.rainImage);
            rainImm.setImageResource(R.drawable.rain);  
            dewImm = (ImageView) findViewById(R.id.dewImage);
            dewImm.setImageResource(R.drawable.dew);  
            hIndexImm = (ImageView) findViewById(R.id.hIndexImage);
            hIndexImm.setImageResource(R.drawable.hi);  
            rRateImm = (ImageView) findViewById(R.id.rRateImage);
            rRateImm.setImageResource(R.drawable.rr);  
            
            startImport("attuali");
            
            //dichiaro i 3 bottoni per i dati minimi attuali e massimi
            //sono definiti nel main_attuali
            //btnImport = (Button) findViewById(R.id.btnImport);
            //btnImport2 = (Button) findViewById(R.id.btnImport2);
            //btnImport3 = (Button) findViewById(R.id.btnImport3);

            //come per cambiare attivity ma qui invece lo uso per richiamare una funzione cioe startimport(piu in basso)
            //btnImport.setOnClickListener(new OnClickListener() 
            //                 {

            //    public void onClick(View v) {
            // TODO Auto-generated method stub
            //Richiamo il metodo che esegue il parse
            //startImport("attuali");
            //    }
            //});
            //idem
            //btnImport2.setOnClickListener(new OnClickListener() 
            //{

            //	public void onClick(View v) {
           // TODO Auto-generated method stub
           //Richiamo il metodo che esegue il parse
           //startImport("minimi");
           // 	}
           // });
            //idem
           // btnImport3.setOnClickListener(new OnClickListener() 
           // {

           // 	public void onClick(View v) {
           // TODO Auto-generated method stub
           //startImport("massimi");
           // 	}
           // });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add("Minimi").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("minimi");
    			return true;
    		}
    	});;
    	menu.add("Attuali").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("attuali");
    			return true;
    		}
    	});;
    	menu.add("Massimi").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("massimi");
    			return true;
    		}
    	});;
    	return true;
    }

    // Metodo parse file
    //qui c'e il metodo per il calcolo dei dati attuali
    private void startImport(String string) 
    {
        if (string == "attuali"){
        	
    	try {
            // Create a URL for the desired page,posso leggere anche gli htm!
            URL url = new URL("http://www.meteocecchina.it/android.txt");

            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String[] str= new String[147];
            //StringBuilder sb = new StringBuilder(100);
            String line;
            int i=0;
           line = in.readLine(); // legge una riga del file 
            
            while (line != null){
            	if(i==0){
            	str[i]=line;
                data.setText(str[i]);	
            	}
            	if(i==6){
            	str[i]=line;
                temperatura.setText(str[i]);	
            	}
            	if(i==8){
                str[i]=line;
                umidita.setText(str[i]);	
                }
            	if(i==15){
                    str[i]=line;
                pressione.setText(str[i]);	
                }
            	if(i==12){
                    str[i]=line;
                ventom.setText(str[i]);	
                }
            	if(i==10){
                    str[i]=line;
                ventoDir.setText(str[i]);	
                }
            	if(i==17){
                    str[i]=line;
                pioggia.setText(str[i]);	
                }
            	if(i==14){
                    str[i]=line;
                dewpoint.setText(str[i]);	
                }
            	if(i==9){
                    str[i]=line;
                heatIndex.setText(str[i]);	
                }
            	if(i==16){
                    str[i]=line;
                rainRate.setText(str[i]);	
                }
            	
            	
            	i++;
            	line = in.readLine(); // legge la prossima riga 
            	}
            in.close();
            Intestazione.setText("Dati Attuali");
            //txtDifficolta.setText(sb.toString());
        } catch (MalformedURLException e) {
        	temperatura.setText("mal");
        } catch (IOException e) {
        	umidita.setText("io");
        }
    }//fine if
    if (string == "minimi"){
          
    	try {
            // Create a URL for the desired page,posso leggere anche gli htm!
            URL url = new URL("http://www.meteocecchina.it/android.txt");

            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String[] str= new String[147];
            //StringBuilder sb = new StringBuilder(100);
            String line;
            int i=0;
           line = in.readLine(); // legge una riga del file 
            
            while (line != null){
            	if(i==0){
            	str[i]=line;
                data.setText(str[i]);	
            	}
            	if(i==28){
            	str[i]=line;
                temperatura.setText(str[i]);	
            	}
            	if(i==30){
                str[i]=line;
                umidita.setText(str[i]);	
                }
            	if(i==35){
                    str[i]=line;
                pressione.setText(str[i]);	
                }
            	if(i==32){
                    str[i]=line;
                dewpoint.setText(str[i]);	
                }
            	
            	
            	i++;
            	line = in.readLine(); // legge la prossima riga 
            	} 

            in.close();
            ventom.setText("ND");
            ventoDir.setText("ND");
            pioggia.setText("ND");
            heatIndex.setText("ND");
            rainRate.setText("ND");
            Intestazione.setText("Estremi minimi giornalieri");
            //txtDifficolta.setText(sb.toString());
        } catch (MalformedURLException e) {
        	temperatura.setText("mal");
        } catch (IOException e) {
        	umidita.setText("io");
        }
    }
    if(string == "massimi"){
    	
    	try {
            // Create a URL for the desired page,posso leggere anche gli htm!
            URL url = new URL("http://www.meteocecchina.it/android.txt");

            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String[] str= new String[147];
            //StringBuilder sb = new StringBuilder(100);
            String line;
            int i=0;
           line = in.readLine(); // legge una riga del file 
            
            while (line != null){
            	if(i==0){
            	str[i]=line;
                data.setText(str[i]);	
            	}
            	if(i==27){
            	str[i]=line;
                temperatura.setText(str[i]);	
            	}
            	if(i==29){
                str[i]=line;
                umidita.setText(str[i]);	
                }
            	if(i==34){
                    str[i]=line;
                pressione.setText(str[i]);	
                }
            	if(i==33){
                    str[i]=line;
                ventom.setText(str[i]);	
                }
            	if(i==31){
                    str[i]=line;
                dewpoint.setText(str[i]);	
                }
            	if(i==38){
                    str[i]=line;
                heatIndex.setText(str[i]);	
                }
            	if(i==36){
                    str[i]=line;
                rainRate.setText(str[i]);	
                }
            	
            	
            	i++;
            	line = in.readLine(); // legge la prossima riga 
            	} 
            in.close();
            ventoDir.setText("ND");
            pioggia.setText("ND");
            Intestazione.setText("Estremi massimi giornalieri");
            //txtDifficolta.setText(sb.toString());
        } catch (MalformedURLException e) {
        	temperatura.setText("mal");
        } catch (IOException e) {
        	umidita.setText("io");
        }
    }
}
}