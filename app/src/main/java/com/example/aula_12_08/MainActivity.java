package com.example.aula_12_08;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int num;
    int total;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent sendEmail = new Intent(Intent.ACTION_SEND);
                sendEmail.setType("*/*");
                sendEmail.putExtra(Intent.EXTRA_EMAIL, "cafe.do.ifc.concordia@gmail.com");
                if(num == 1){
                    sendEmail.putExtra(Intent.EXTRA_TEXT, "Eu gostaria de pedir " + num + " café. O valor total será R$" + total);
                }else{
                    sendEmail.putExtra(Intent.EXTRA_TEXT, "Eu gostaria de pedir " + num + " cafés. O valor total será R$" + total);
                }
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, "BATATA");

                if(sendEmail.resolveActivity(getPackageManager()) != null){
                    startActivity(sendEmail);
                }
            }


        });


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recuperando view da activity
        Button next = findViewById(R.id.nextBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Criando um intent explícito
                // Recupera-se o contexto da view
                // Chama-se explicitamente a classe da activity que deseja abrir
                Intent intent = new Intent(v.getContext(), secondActivity.class);

                // Inicia-se a activity
                startActivity(intent);
            }
        });
    }


    public void teste(View view) {
        Toast toast = Toast.makeText(this,"texto",Toast.LENGTH_SHORT);
        toast.show();
    }



    public void soma1(View view){
        TextView cafe = findViewById(R.id.texto);
        TextView soma = findViewById(R.id.total);
        num++;
        total += 3;
        cafe.setText("" + num);
        if(num == 1){
            soma.setText("Eu gostaria de pedir " + num + "café. O valor total será R$" + total);
        }else{
            soma.setText("Eu gostaria de pedir "  + num + " cafés. O valor total será R$" + total);
        }
    }

    public void menos1(View view){
        TextView cafe = findViewById(R.id.texto);
        TextView soma = findViewById(R.id.total);
        if(num!=0){
            num--;
        }
        if((total-3)!=0){
            total -= 3;
        }
        cafe.setText("" + num);
        if(num == 1){
            soma.setText("Eu gostaria de pedir " + num + "café. O valor total será R$" + total);
        }else{
            soma.setText("Eu gostaria de pedir "  + num + " cafés. O valor total será R$" + total);
        }
    }


}