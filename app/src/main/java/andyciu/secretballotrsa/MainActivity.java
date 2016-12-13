package andyciu.secretballotrsa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bn1,bn2,bn3,bnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bn1= (Button) findViewById(R.id.main_button1);
        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent();
                it1.setClass(MainActivity.this,CreateRSA_Activity.class);
                startActivity(it1);
            }
        });
        bn2= (Button) findViewById(R.id.main_button2);
        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent();
                it1.setClass(MainActivity.this,BallotFActivity.class);
                startActivity(it1);
            }
        });
        bn3= (Button) findViewById(R.id.main_button3);
        bn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent();
                it1.setClass(MainActivity.this,BillingActivity.class);
                startActivity(it1);
            }
        });
        bnt= (Button) findViewById(R.id.main_buttontest);
        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent();
                it1.setClass(MainActivity.this,BallotTestActivity.class);
                startActivity(it1);
            }
        });
    }
}
