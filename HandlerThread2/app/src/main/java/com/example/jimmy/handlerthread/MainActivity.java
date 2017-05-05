package com.example.jimmy.handlerthread;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {
    private Button startButton = null;
    private Button endButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new StartButtonListener());
        endButton = (Button)findViewById(R.id.endButton);
        endButton.setOnClickListener(new EndButtonListener());
    }

    Handler handler = new Handler();
    class StartButtonListener implements OnClickListener{
      @Override
        public void onClick(View v){
          handler.removeCallbacks(updateThread);
      }
    }

    class EndButtonListener implements OnClickListener{
        @Override
        public void onClick(View v){
            handler.removeCallbacks(updateThread);
        }
    }

    Runnable updateThread = new Runnable() {
        @Override
        public void run() {
            System.out.println("UpdateThread");
            Log.v("tag","UpdateThread");
            handler.postDelayed(updateThread,2000);
        }
    };
}
