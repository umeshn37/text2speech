package com.example.hp.text2speech;

import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public Button mic;
    EditText textOut;
    TextToSpeech textToSpeech;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mic =(Button)findViewById(R.id.button);
        textOut=(EditText) findViewById(R.id.editText);
        textToSpeech=new TextToSpeech(getApplication(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    //textToSpeech.setLanguage(Locale.UK);
                }
            }
        });
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // textOut.setText(textOut.getText().toString()+"H");
                String Input_clip=textOut.getText().toString();

                textToSpeech.speak(Input_clip,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
    }
}
