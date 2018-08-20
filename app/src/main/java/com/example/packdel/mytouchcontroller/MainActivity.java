package com.example.packdel.mytouchcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public ImageView ball;

    public float last_x = 0;
    public float last_y = 0;

    void log(String log){ Log.i("AMP", log);}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ball = findViewById(R.id.ball);

        log(String.valueOf(ball.getMaxHeight()));
        //ball.setY(ball.getY() - ball.getMaxHeight()/2);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        if(x - last_x < 0){

            log("moving left");
            ball.setScaleX(ball.getScaleX() + ((last_x - x)/100));
            ball.setScaleY(ball.getScaleY() + ((last_x - x)/100 ));
        }

        last_x = x;
        last_y = y;

        try {

            //ball.setX(event.getX());
            //ball.setY(event.getY());

        }catch (Exception e){

            log(e.toString());
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
