package com.example.appv1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView pos_x, pos_y, iter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn_iniciar);

        pos_x = findViewById(R.id.pos_x);
        pos_y = findViewById(R.id.pos_y);
        iter = findViewById(R.id.iter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String send_pos_x = pos_x.getText().toString();
                String send_pos_y = pos_y.getText().toString();
                String send_iter = iter.getText().toString();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("pos_x", send_pos_x);
                intent.putExtra("pos_y", String.valueOf(send_pos_y));
                intent.putExtra("iter", String.valueOf(send_iter));

                //Toast.makeText(getApplicationContext(), String.valueOf(send_pos_x) , Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

    }
}


// String name = name_id.getText().toString();
// https://www.google.com/search?rlz=1C1EJFC_enCO854CO854&sxsrf=AB5stBigkmfmk1kdjHAemSvujo-4YIgGOg:1688596891460&q=change+image+color+in+android+studio&tbm=vid&sa=X&ved=2ahUKEwj8lInP0fj_AhVqD1kFHTrVDvEQ0pQJegQICxAB&biw=1920&bih=937&dpr=1#fpstate=ive&vld=cid:e66721f8,vid:InHGI20U3ak






