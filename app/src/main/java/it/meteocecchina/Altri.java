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





public class Altri extends Activity {
	// Dichiarazione oggetti
    TextView data;
    TextView alba;
    TextView tramonto;
    TextView lunghezzagiorno;
    TextView tempinterna;
    TextView huminterna;
    TextView pioggiamese;
    TextView pioggiaanno;
    TextView pioggiatemporale;
    TextView luna;
    TextView albaluna;
    TextView tramontoluna;
    TextView densita;
    TextView altezzanubi;
    TextView vartemp1h;
    TextView varwind1h;
    TextView varhum1h;
    TextView varpress1h;
    TextView vartemp1d;
    TextView varwind1d;
    TextView varhum1d;
    TextView varpress1d;
    //Button btnImport;
    //Button btnImport2;
    //Button btnImport3;
    
    //private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            Log.i("main", "BEGIN");
            setContentView(R.layout.main_altri); //Carico layout
            
            // Inizializzo gli  oggetti
            data = (TextView) findViewById(R.id.data);
            alba = (TextView) findViewById(R.id.alba);
            tramonto = (TextView) findViewById(R.id.tramonto);
            lunghezzagiorno = (TextView) findViewById(R.id.lunghezzagiorno);
            tempinterna = (TextView) findViewById(R.id.tempinterna); 
            huminterna = (TextView) findViewById(R.id.huminterna);
            pioggiamese = (TextView) findViewById(R.id.pioggiamese);
            pioggiaanno = (TextView) findViewById(R.id.pioggiaanno);
            pioggiatemporale = (TextView) findViewById(R.id.pioggiatemporale);
            luna = (TextView) findViewById(R.id.luna);
            albaluna = (TextView) findViewById(R.id.albaluna);
            tramontoluna = (TextView) findViewById(R.id.tramontoluna);
            densita = (TextView) findViewById(R.id.densita);
            altezzanubi = (TextView) findViewById(R.id.altezzanubi);
            vartemp1h = (TextView) findViewById(R.id.vartemp1h);
            varwind1h = (TextView) findViewById(R.id.varwind1h);
            varhum1h = (TextView) findViewById(R.id.varhum1h);
            varpress1h = (TextView) findViewById(R.id.varpress1h);
            vartemp1d = (TextView) findViewById(R.id.vartemp1d);
            varwind1d = (TextView) findViewById(R.id.varwind1d);
            varhum1d = (TextView) findViewById(R.id.varhum1d);
            varpress1d = (TextView) findViewById(R.id.varpress1d);            
            
            startImport();
            
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
    	menu.add("Aggiorna").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
                startImport();
    			return true;
    		}
    	});;
    	return true;
	}

    // Metodo parse file
    //qui c'e il metodo per il calcolo dei dati attuali
    private void startImport() 
    {
       
        	
    	try {
            // Create a URL for the desired page,posso leggere anche gli htm!
            URL url = new URL("http://www.meteocecchina.it/android.txt");

            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String[] str= new String[160];
            //StringBuilder sb = new StringBuilder(100);
            String line;
            int i=0;
           line = in.readLine(); // legge una riga del file 
            
            while (line != null){
            	if(i==0){
                str[i]=line;
                data.setText(str[i]);	
                }
            	if(i==144){
            	str[i]=line;
                pioggiatemporale.setText(str[i]+" mm");	
            	}
            	if(i==21){
            	str[i]=line;
                luna.setText(str[i]);	
            	}
            	if(i==146){
            	str[i]=line;
                albaluna.setText(str[i]);	
            	}
            	if(i==147){
                str[i]=line;
                tramontoluna.setText(str[i]);	
                }
            	if(i==2){
                    str[i]=line;
                alba.setText(str[i]);	
                }
            	if(i==3){
                    str[i]=line;
                tramonto.setText(str[i]);	
                }
            	if(i==4){
                    str[i]=line;
                tempinterna.setText(str[i]+" C");
                }
            	if(i==5){
                    str[i]=line;
                huminterna.setText(str[i]+" %");	
                }
            	if(i==1){
                    str[i]=line;
                lunghezzagiorno.setText(str[i]);	
                }
            	if(i==18){
                    str[i]=line;
                pioggiamese.setText(str[i]+" mm");	
                }
            	if(i==19){
                    str[i]=line;
                pioggiaanno.setText(str[i]+" mm");	
                }
            	if(i==22){
                    str[i]=line;
                densita.setText(str[i]+" kg/m^3");	
                }
            	if(i==23){
                    str[i]=line;
                altezzanubi.setText(str[i]+" m");	
                }
            	if(i==132){
                    str[i]=line;
                    double vartemp1hint = Double.parseDouble(str[i]);
                    if(vartemp1hint < 0){
                vartemp1h.setTextColor(getResources().getColor(R.color.blu));   
                    }
                    else{
                vartemp1h.setTextColor(getResources().getColor(R.color.red));   	
                    }
                vartemp1h.setText(vartemp1hint+" C");
                }
            	if(i==133){
                    str[i]=line;
                    double varwind1hint = Double.parseDouble(str[i]);
                    if(varwind1hint < 0){
                varwind1h.setTextColor(getResources().getColor(R.color.blu));   
                    }
                    else{
                varwind1h.setTextColor(getResources().getColor(R.color.red));   	
                    }
                varwind1h.setText(varwind1hint+" km/h");	
                }
            	if(i==135){
                    str[i]=line;
                    double varhum1hint = Double.parseDouble(str[i]);
                    if(varhum1hint < 0){
                varhum1h.setTextColor(getResources().getColor(R.color.blu));   
                    }
                    else{
                varhum1h.setTextColor(getResources().getColor(R.color.red));   	
                    }
                varhum1h.setText(varhum1hint+" %");	
                }
            	if(i==137){
                    str[i]=line;
                    double varpress1hint = Double.parseDouble(str[i]);
                    if(varpress1hint < 0){
                varpress1h.setTextColor(getResources().getColor(R.color.blu));   
                    }
                    else{
                varpress1h.setTextColor(getResources().getColor(R.color.red));   	
                    }
                varpress1h.setText(varpress1hint+" hPa");	
                }
               	if(i==138){
                    str[i]=line;
                    double vartemp1dint = Double.parseDouble(str[i]);
                    if(vartemp1dint < 0){
                vartemp1d.setTextColor(getResources().getColor(R.color.blu));   
                    }
                    else{
                vartemp1d.setTextColor(getResources().getColor(R.color.red));   	
                    }
                vartemp1d.setText(vartemp1dint+" C");
                }
            	if(i==139){
                    str[i]=line;
                    double varwind1dint = Double.parseDouble(str[i]);
                    if(varwind1dint < 0){
                varwind1d.setTextColor(getResources().getColor(R.color.blu));   
                    }
                    else{
                varwind1d.setTextColor(getResources().getColor(R.color.red));   	
                    }
                varwind1d.setText(varwind1dint+" km/h");	
                }
            	if(i==141){
                    str[i]=line;
                    double varhum1dint = Double.parseDouble(str[i]);
                    if(varhum1dint < 0){
                varhum1d.setTextColor(getResources().getColor(R.color.blu));   
                    }
                    else{
                varhum1d.setTextColor(getResources().getColor(R.color.red));   	
                    }
                varhum1d.setText(varhum1dint+" %");	
                }
            	if(i==143){
                    str[i]=line;
                    double varpress1dint = Double.parseDouble(str[i]);
                    if(varpress1dint < 0){
                varpress1d.setTextColor(getResources().getColor(R.color.blu));   
                    }
                    else{
                varpress1d.setTextColor(getResources().getColor(R.color.red));   	
                    }
                varpress1d.setText(varpress1dint+" hPa");	
                }
            	
            	
            	i++;
            	line = in.readLine(); // legge la prossima riga 
            	}
            in.close();
            //txtDifficolta.setText(sb.toString());
        } catch (MalformedURLException e) {
        	alba.setText("mal");
        } catch (IOException e) {
        	tramonto.setText("io");
        }
    }//fine if
    
}

