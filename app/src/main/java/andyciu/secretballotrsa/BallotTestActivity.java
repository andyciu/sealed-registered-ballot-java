package andyciu.secretballotrsa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class BallotTestActivity extends AppCompatActivity implements Button.OnClickListener{

    Button bn1,bnf;
    TextView ttr;
    EditText etP1,etP2,etB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ballottest);
        bn1= (Button) findViewById(R.id.ballotTest_button);
        bn1.setOnClickListener(this);
        bnf= (Button) findViewById(R.id.ballotTest_buttonFinish);
        bnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        etP1= (EditText) findViewById(R.id.ballotTest_etPublic1);
        etP2= (EditText) findViewById(R.id.ballotTest_etPublic2);
        etB= (EditText) findViewById(R.id.ballotTest_etBallot);
        ttr= (TextView) findViewById(R.id.ballotTest_textViewPerson);
    }

    @Override
    public void onClick(View v) {
        BigInteger b_numb=new BigInteger(etP1.getText().toString());
        BigInteger b_num_p1=new BigInteger(etP2.getText().toString());
        BigInteger b_num_p2=new BigInteger(etB.getText().toString());
        //==============================
        b_numb=b_numb.modPow(b_num_p1,b_num_p2);
        ttr.setText(b_numb.toString());
    }
}
