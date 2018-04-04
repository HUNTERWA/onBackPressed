package com.example.rohit.paypal;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //ImageView image,view;
    //Animation top_to_bottom,bottom_to_top;
    LinearLayout linearLayout;
    ImageView imageView;
    Button pc;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("anim");

        linearLayout=findViewById(R.id.linearLayout);

        linearLayout.animate().translationY(1000f).setDuration(0);

        Thread thread=new Thread()
        {
          public void run()
          {
              try
              {
                  sleep(3000);
              }
              catch (InterruptedException e)
              {
                  e.printStackTrace();
              }
              finally
              {
                  linearLayout.animate().translationY(0).setDuration(1000);
                  //linearLayout.bringChildToFront(view); no effect in code
                  linearLayout.setZ(1000f);
              }
          }
        };
        thread.start();


        imageView=findViewById(R.id.s_cross);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                linearLayout.animate().translationY(1000).setDuration(1000);
            }
        });

        pc=findViewById(R.id.phoneCall);
        pc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:8655364531"));
                startActivity(i);
            }
        });

        /*image=findViewById(R.id.image);
        view=findViewById(R.id.view);

        image.animate().translationY(-1000).setDuration(0);
        view.animate().translationY(-1000).setDuration(0);

        Thread thread=new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(0);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    imganimate();
                }
            }
        };
        thread.start();

        imganimate();*/



    /*public void imganimate()
    {
        image.animate().translationY(0).setDuration(500);
        view.animate().translationY(0).setDuration(500);
    }*/


    }

    public boolean onKeyDown(int keycode, KeyEvent keyEvent)
    {
        if(keycode==KeyEvent.KEYCODE_BACK)
        {
            event();
            return true;
        }
            return super.onKeyDown(keycode,keyEvent);

    }

    public void event()
    {
        AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setMessage("Do you really want to exit ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                }).show();
    }
}
