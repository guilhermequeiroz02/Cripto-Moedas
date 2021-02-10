package com.example.pim4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class selecionar_opcao extends AppCompatActivity {
    private void runHTTPRequest() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest")
                .header("X-CMC_PRO_API_KEY", "e33e0e7e-d62c-4ce2-914b-a69a1e0fb66e")
                .addHeader("Accepts", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String body = response.body().string();
                Gson gson = new GsonBuilder().create();
                JSONResponse JSONFormatted = gson.fromJson(body, JSONResponse.class);
                System.out.println("**" + JSONFormatted.data.get(0).name);
                System.out.println("**" + JSONFormatted.data.get(0).quote.USD.price);
                Intent criptoativos = new Intent(getApplicationContext(),valores.class);
                criptoativos.putExtra("Valor",body);
                startActivity(criptoativos);

            }
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
        });
        System.out.println("Depois da chamada do backend");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_opcao);
        Button btSaldo = (Button) findViewById(R.id.btSaldo);
        Button btCriptoativos = (Button) findViewById(R.id.btCriptoativos);
        btCriptoativos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                runHTTPRequest();

            }
        });
        btSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saldo = new Intent(getApplicationContext(),saldo.class);
                startActivity(saldo);
            }
        });
    }
}