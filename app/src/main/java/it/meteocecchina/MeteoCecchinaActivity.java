package it.meteocecchina;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MeteoCecchinaActivity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);
        
        //Primo bottone che si collega alla classe(o activity) ImportParoleActivity
        //la formattazione del pulsante deve essere definito nel main_home
        Button Attuali = (Button) findViewById(R.id.Attuali);
        Attuali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	//da qui micollego all'altra activity che non e nient'altro che un'altra classe java che deve stare nello stesso package
            	Intent myIntent = new Intent(view.getContext(), Attuali.class);
                startActivity(myIntent);
            }

        });
        
        //Quarto bottone che si collega alla classe(o activity) Webcam
        //la formattazione del pulsante deve essere definito nel main_home
         Button Altri = (Button) findViewById(R.id.Altri);
         Altri.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
              Intent myIntent = new Intent(view.getContext(), Altri.class);
              startActivity(myIntent);
          }

         });
        //Secondo bottone che si collega alla classe(o activity) Estremi
        //la formattazione del pulsante deve essere definito nel main_home
        Button Estremi = (Button) findViewById(R.id.Estremi);
        Estremi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Estremi.class);
                startActivity(myIntent);
            }

        });
        //Terzo bottone che si collega alla classe(o activity) Grafici
        //la formattazione del pulsante deve essere definito nel main_home
        Button Grafici = (Button) findViewById(R.id.Grafici);
        Grafici.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Grafici.class);
                startActivity(myIntent);
            }

        });
        
        //Quarto bottone che si collega alla classe(o activity) Webcam
        //la formattazione del pulsante deve essere definito nel main_home
        Button Webcam = (Button) findViewById(R.id.Webcam);
        Webcam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Webcam.class);
                startActivity(myIntent);
            }

        });
        
        
    }
}
