package com.example.apkal_qurandigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class hal2 extends AppCompatActivity {
    TextView txtasma,txtarti,txtaudio,txtketerangan;
    AlQuran alQuran;
    Button playBtn,pauseBtn, btnBaca;
    MediaPlayer mediaPlayer;
    String bacaan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal2);
        txtasma=(TextView)findViewById(R.id.txtAsma);
        txtarti=(TextView)findViewById(R.id.txtArti);
        txtaudio=(TextView) findViewById(R.id.txtAudio);
        txtketerangan=(TextView)findViewById(R.id.txtKeterangan);
        playBtn=(Button) findViewById(R.id.idBtnPlay);
        pauseBtn=(Button) findViewById(R.id.idBtnPause);
        btnBaca=(Button)findViewById(R.id.btn_baca);
        Intent intent=getIntent();
        alQuran= (AlQuran) intent.getSerializableExtra("kiriman");
        bacaan=alQuran.getAudio();

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    Toast.makeText(hal2.this, "Audio nyala", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(hal2.this,"Audio tidak tersedia",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Intent dapet=getIntent();
        alQuran= (AlQuran) dapet.getSerializableExtra("kiriman");
        txtasma.setText(alQuran.getAsma());
        txtarti.setText(alQuran.getArti());
        txtketerangan.setText(alQuran.getKeterangan());
        btnBaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xxx=alQuran.getNomor();
                Intent intent1=new Intent(hal2.this,hal3.class);
                intent1.putExtra("suratnya",xxx);
                startActivity(intent1);
            }
        });
    }

    private void playAudio() {
        String audioUrl=bacaan;
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(audioUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Toast.makeText(this,"Audio play",Toast.LENGTH_SHORT).show();
    }
}
