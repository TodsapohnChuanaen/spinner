package com.example.aun.spinner;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.attr.button;
import static android.R.attr.country;

public class MainActivity extends AppCompatActivity {
    String[] countries;
    Spinner spinnerCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinnerCountry = (Spinner) findViewById(R.id.spinner_country);

        countries = getResources().getStringArray(R.array.country_array);
        ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, countries);
        spinnerCountry.setAdapter(adapterCountry);

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),countries[position],Toast.LENGTH_LONG).show();
            } //getApplicationContext .ใช้ MainActivity.this แทนได้

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });


        Button buttonCountry = (Button) findViewById(R.id.button);
        buttonCountry.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String countryName = spinnerCountry.getSelectedItem().toString();
                //AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //builder.setTitle("Country");
                //builder.setMessage(countryName);
                //builder.show();
                //Toast.makeText(MainActivity.this,countryName, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("spinner",countryName);
                startActivity(intent);
            }
        });
    }
}
