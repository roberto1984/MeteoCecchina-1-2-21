package it.meteocecchina;

import android.app.Activity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import android.widget.ImageView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;





public class Estremi extends Activity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            Log.i("main", "BEGIN");
            setContentView(R.layout.main_estremi); //Carico layout
            
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


            
            //ventoMed = (TextView) findViewById(R.id.ventoMed);
            //ventoDir = (TextView) findViewById(R.id.ventoDir);
            //pioggia = (TextView) findViewById(R.id.pioggia);
            //rainRate = (TextView) findViewById(R.id.rainRate);  
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
               

            
    }
 //*********************CREZAZIONE MENU**************
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add("Max mensili").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("max_mese");
    			return true;
    		}
    	});;
    	menu.add("Max Annuali").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("max_anno");
    			return true;
    		}
    	});;
    	menu.add("Max Assoluti").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("max_ass");
    			return true;
    		}
    	});;
    	menu.add("Min mensili").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("min_mese");
    			return true;
    		}
    	});;

    	menu.add("Min Annuali").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("min_anno");
    			return true;
    		}
    	});;

    	menu.add("Min assoluti").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("min_ass");
    			return true;
    		}
    	});;

    	return true;
	}
    // Metodo parse file
    private void startImport(String string) 
    {
          
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
           //***************INIZIO CONDIZIONI IF*************** 
           if(string =="min_mese"){
           
            while (line != null){
            	if(i==0){
            	str[i]=line;
                data.setText(str[i]);	
            	}
            	if(i==41){
            	str[i]=line;
                temperatura.setText(str[i]);	
            	}
            	if(i==43){
                str[i]=line;
                umidita.setText(str[i]);	
                }
            	if(i==48){
                    str[i]=line;
                pressione.setText(str[i]);	
                }
            	if(i==45){
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
            Intestazione.setText("Estremi minimi mensili");
           }//***************fine if***********
           if(string =="max_mese"){
        	   
        	   while (line != null){
               	if(i==0){
               	str[i]=line;
                   data.setText(str[i]);	
               	}
               	if(i==40){
               	str[i]=line;
                   temperatura.setText(str[i]);	
               	}
               	if(i==42){
                   str[i]=line;
                   umidita.setText(str[i]);	
                   }
               	if(i==47){
                       str[i]=line;
                   pressione.setText(str[i]);	
                   }
               	if(i==46){
                       str[i]=line;
                   ventom.setText(str[i]);	
                   }
               	if(i==44){
                       str[i]=line;
                   dewpoint.setText(str[i]);	
                   }
               	if(i==50){
                       str[i]=line;
                   heatIndex.setText(str[i]);	
                   }
               	if(i==51){
                       str[i]=line;
                   rainRate.setText(str[i]);	
                   }
               	
               	
               	i++;
               	line = in.readLine(); // legge la prossima riga 
               	} 
               in.close();
               ventoDir.setText("ND");
               pioggia.setText("ND");
               Intestazione.setText("Estremi massimi mensili"); 
           }//****************fine if ***************************
           if(string =="min_anno"){
        	   
               while (line != null){
               	if(i==0){
               	str[i]=line;
                   data.setText(str[i]);	
               	}
               	if(i==54){
               	str[i]=line;
                   temperatura.setText(str[i]);	
               	}
               	if(i==56){
                   str[i]=line;
                   umidita.setText(str[i]);	
                   }
               	if(i==61){
                       str[i]=line;
                   pressione.setText(str[i]);	
                   }
               	if(i==58){
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
               Intestazione.setText("Estremi minimi Annuali");
           }//****************fine if ***************************
           if(string =="max_anno"){
        	   
               while (line != null){
               	if(i==0){
               	str[i]=line;
                   data.setText(str[i]);	
               	}
               	if(i==53){
               	str[i]=line;
                   temperatura.setText(str[i]);	
               	}
               	if(i==55){
                   str[i]=line;
                   umidita.setText(str[i]);	
                   }
               	if(i==60){
                       str[i]=line;
                   pressione.setText(str[i]);	
                   }
               	if(i==59){
                       str[i]=line;
                   ventom.setText(str[i]);	
                   }
               	if(i==57){
                       str[i]=line;
                   dewpoint.setText(str[i]);	
                   }
               	if(i==63){
                       str[i]=line;
                   heatIndex.setText(str[i]);	
                   }
               	if(i==64){
                       str[i]=line;
                   rainRate.setText(str[i]);	
                   }
               	
               	
               	i++;
               	line = in.readLine(); // legge la prossima riga 
               	} 
               in.close();
               ventoDir.setText("ND");
               pioggia.setText("ND");
               Intestazione.setText("Estremi massimi annuali");
           }//****************fine if ***************************
           if(string =="min_ass"){
        	   
               while (line != null){
               	if(i==0){
               	str[i]=line;
                   data.setText(str[i]);	
               	}
               	if(i==67){
               	str[i]=line;
                   temperatura.setText(str[i]);	
               	}
               	if(i==69){
                   str[i]=line;
                   umidita.setText(str[i]);	
                   }
               	if(i==74){
                       str[i]=line;
                   pressione.setText(str[i]);	
                   }
               	if(i==71){
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
               Intestazione.setText("Estremi minimi assoluti");
           }//****************fine if ***************************
           if(string =="max_ass"){
        	   
               while (line != null){
               	if(i==0){
               	str[i]=line;
                   data.setText(str[i]);	
               	}
               	if(i==66){
               	str[i]=line;
                   temperatura.setText(str[i]);	
               	}
               	if(i==68){
                   str[i]=line;
                   umidita.setText(str[i]);	
                   }
               	if(i==73){
                       str[i]=line;
                   pressione.setText(str[i]);	
                   }
               	if(i==72){
                       str[i]=line;
                   ventom.setText(str[i]);	
                   }
               	if(i==70){
                       str[i]=line;
                   dewpoint.setText(str[i]);	
                   }
               	if(i==76){
                       str[i]=line;
                   heatIndex.setText(str[i]);	
                   }
               	if(i==77){
                       str[i]=line;
                   rainRate.setText(str[i]);	
                   }
               	
               	
               	i++;
               	line = in.readLine(); // legge la prossima riga 
               	} 
               in.close();
               ventoDir.setText("ND");
               pioggia.setText("ND");
               Intestazione.setText("Estremi massimi assoluti"); 
           }//***************FINE CONDIZIONI IF*************** 
            //txtDifficolta.setText(sb.toString());
        } catch (MalformedURLException e) {
        	temperatura.setText("mal");
        } catch (IOException e) {
        	umidita.setText("io");
        }
    }

}