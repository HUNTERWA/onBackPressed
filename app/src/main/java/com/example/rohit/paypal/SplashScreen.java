package com.example.rohit.paypal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.LinearLayout;

public class SplashScreen extends AppCompatActivity
{
    LinearLayout linear,lay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        linear=findViewById(R.id.linear);
        lay=findViewById(R.id.lay);

        linear.animate().translationY(-1000f).setDuration(0);
        lay.animate().translationY(1000f).setDuration(0);

        Thread t=new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    out();
                }
            }
        };
        t.start();

        Handler handler=new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }

    public void out()
    {
        linear.animate().translationY(0).setDuration(1000);
        lay.animate().translationY(0).setDuration(1000);
    }




}
