package com.example.rohit.paypal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class CustomClass extends AppCompatActivity
{
    LinearLayout frame1,frame2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_class);

        frame1=findViewById(R.id.frame1);
        frame2=findViewById(R.id.frame2);
    }

    public void nextFrame(View view)
    {
        frame2.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed()
    {
        if(frame2.getVisibility()==View.VISIBLE)
        {//on back press directly previous activity was showing instead of showing previous frame. that's y this method needed
            frame2.setVisibility(View.GONE);
            frame1.setVisibility(View.VISIBLE);
        }
        else if(frame1.getVisibility()==View.VISIBLE)
        {//on back press above if condition was overlapping that's why we needed this condition.
            Intent intent=new Intent(CustomClass.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
