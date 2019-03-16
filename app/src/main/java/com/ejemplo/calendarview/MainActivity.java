package com.ejemplo.calendarview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView myDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }
    private void initComponents(){
        calendarView = (CalendarView)findViewById(R.id.calendarView);
        myDate = (TextView)findViewById(R.id.myDate);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) { //i = al año i1 = al mes i2= al dia
                String fecha = i2 + "/" + (i1 + 1) + "/" + i; //Se guarda en una variable la fecha que se selecciona
                myDate.setText(fecha);
            }
        });
    }
    public void guardarOnClick(View view){
        try{
            String texto;
            texto = (String)myDate.getText();//Recibe la fecha seleccionada por el usuario
            Toast.makeText(MainActivity.this,"Esta es tu fecha: "+texto, Toast.LENGTH_SHORT).show();//Enviar ,emsaje al usuario
        }catch(Exception ex){
            Log.e("Error guardar;", "Message" + ex.getMessage());
        }
    }

}
