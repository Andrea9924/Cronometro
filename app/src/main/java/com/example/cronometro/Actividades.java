package com.example.cronometro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;

import android.os.Bundle;
import android.widget.TimePicker;

import java.util.Calendar;

public class Actividades extends AppCompatActivity implements View.OnClickListener {

    Button btnfecha, btnhora;
    EditText txtfecha, txthora;
    private int dia, mes, año, horas, minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        btnfecha = (Button)findViewById(R.id.btnfecha);
        btnhora = (Button)findViewById(R.id.btnhora);
        txtfecha = (EditText) findViewById(R.id.txtfecha);
        txthora = (EditText) findViewById(R.id.txthora);
        btnfecha.setOnClickListener(this);
        btnhora.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view==btnfecha){
         final Calendar c = Calendar.getInstance();
         dia = c.get(Calendar.DAY_OF_MONTH);
         mes = c.get(Calendar.MONTH);
         año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                   txtfecha.setText(day+"/"+(month+1)+"/"+year);

                }
            }
            ,dia,mes,año);
            datePickerDialog.show();
        }
        if (view==btnhora){
            final Calendar c = Calendar.getInstance();
            horas = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hora, int min) {
                    txthora.setText(hora+":"+min);
                }
            },horas,minutos,false);
            timePickerDialog.show();
        }
    }

    @Override public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_en_actividades,mimenu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem opcion_menu) {
        int id = opcion_menu.getItemId();

        if (id == R.id.cronometro) {
            return true;
        }
        if (id == R.id.Actividades) {
            return true;
        }
        if (id == R.id.tiempos) {
            return true;
        }

        return super.onOptionsItemSelected(opcion_menu);

    }

}