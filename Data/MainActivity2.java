package com.example.appv1;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;
import android.view.View.OnClickListener;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.os.Handler;

public class MainActivity2 extends AppCompatActivity {

    private ImageView img;
    //private TextView textView;
    //private Bitmap bitmap;
    //final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

            img = findViewById(R.id.blackimage);
            Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.black_colour);
            bm = bm.copy(Bitmap.Config.ARGB_8888, true);

            Variables.x_pos = Integer.parseInt(String.valueOf(getIntent().getStringExtra("pos_x")));
            Variables.y_pos = Integer.parseInt(String.valueOf(getIntent().getStringExtra("pos_y")));
            Variables.max_iter = Integer.parseInt(String.valueOf(getIntent().getStringExtra("iter")));

            Handler handler1 = new Handler();
            for (int a = 1; a<=Variables.max_iter;a++) {
                Bitmap finalBm = bm;
                handler1.postDelayed(new Runnable() {
                @Override
                public void run() {

                    int pixelColor = finalBm.getPixel(Variables.x_pos,Variables.y_pos);

                    int r = Color.red(pixelColor);
                    int g = Color.green(pixelColor);
                    int b = Color.blue(pixelColor);
                    int defineColor;

                    if (r<10 && g <10 && b<10){
                        defineColor = 1;
                        Variables.actual_color = 1;
                    }
                    else{
                        defineColor = 0;
                        Variables.actual_color = 0;
                    }

                    if(defineColor == 1) {
                        finalBm.setPixel(Variables.x_pos, Variables.y_pos, Color.rgb(255,255,255));
                        img.setImageBitmap(finalBm);
                        //Toast.makeText(getApplicationContext(), String.valueOf(finalBm.getWidth()), Toast.LENGTH_LONG).show();

                    }
                    else {
                        finalBm.setPixel(Variables.x_pos, Variables.y_pos, Color.rgb(0,0,0));
                        img.setImageBitmap(finalBm);
                    }

                    int[] position = Algorithm(Variables.x_pos,Variables.y_pos);
                    Variables.x_pos = position[0];
                    Variables.y_pos = position[1];
                        }
                    }, 20L * a);
                }

    }

    public class Variables{
        public static int x_pos = 5;
        public static int y_pos = 5;
        public static int mirada = 1;
        public static int actual_color = 1;

        public static int size_y = 805;
        public static int size_x = 604;

        public static int max_iter = 100;
    }

    public int[] Algorithm(int x_position, int y_position){

        int new_x_pos = Variables.x_pos;
        int new_y_pos = Variables.y_pos;

        if (Variables.actual_color == 1){
            if(Variables.mirada == 1){
                Variables.mirada = 3;
                if (x_position+1 == Variables.size_x) {
                    new_x_pos = 1;
                }
                else{
                    new_x_pos = x_position + 1;
                }
            }
            else if(Variables.mirada == 2){
                Variables.mirada = 4;
                if (x_position-1 == 0){
                    new_x_pos = Variables.size_x-1;
                }
                else{
                    new_x_pos = x_position-1;
                }
            }
            else if(Variables.mirada == 3){
                Variables.mirada = 2;
                if (y_position-1 == 0){
                    new_y_pos = Variables.size_y-1;
                }
                else{
                    new_y_pos = y_position-1;
                }
            }
            else if(Variables.mirada == 4){
                Variables.mirada = 1;
                if (y_position+1 == Variables.size_y){
                    new_y_pos = 1;
                }
                else{
                    new_y_pos = y_position+1;
                }
            }
        }
        else{
            if(Variables.mirada == 1){
                Variables.mirada = 4;
                if (x_position-1 == 0){
                    new_x_pos = Variables.size_x-1;
                }
                else {
                    new_x_pos = x_position - 1;
                }
            }
            else if(Variables.mirada == 2){
                Variables.mirada = 3;
                if (x_position+1 == Variables.size_x){
                    new_x_pos = 1;
                }
                else{
                    new_x_pos = x_position+1;
                }
            }
            else if(Variables.mirada == 3){
                Variables.mirada = 1;
                if (y_position+1 == Variables.size_y){
                    new_y_pos = 1;
                }
                else{
                    new_y_pos = y_position+1;
                }
            }
            else if(Variables.mirada == 4){
                Variables.mirada = 2;
                if (y_position-1 == 0){
                    new_y_pos = Variables.size_y-1;
                }
                else{
                    new_y_pos = y_position-1;
                }
            }
        }

        int[] position = new int[2];
        position[0] = new_x_pos;
        position[1] = new_y_pos;
        return position;
    };


}

