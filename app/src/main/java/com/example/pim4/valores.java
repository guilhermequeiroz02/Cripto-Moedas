package com.example.pim4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import java.util.ArrayList;

public class valores extends AppCompatActivity {

    private static final String TAG  = "valores";

    private ListView lvMoedas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valores);
        Log.d(TAG, "onCreate: Started.");
        String json = getIntent().getExtras().getString("Valor");
        Gson gson = new GsonBuilder().create();
        JSONResponse JSONFormatted = gson.fromJson(json, JSONResponse.class);

        ListView lvMoedas = (ListView) findViewById(R.id.lvMoedas);

        ArrayList<String> itens = new ArrayList<String>();
        int i;
        for(i = 0; i < JSONFormatted.data.size(); i++) {
            itens.add(JSONFormatted.data.get(i).name + "\t Preço: US$ " + JSONFormatted.data.get(i).quote.USD.price.shortValue());

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );
        lvMoedas.setAdapter(adapter);


        }
    }

