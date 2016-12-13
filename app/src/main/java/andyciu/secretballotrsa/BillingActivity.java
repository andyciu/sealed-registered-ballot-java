package andyciu.secretballotrsa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class BillingActivity extends AppCompatActivity implements Button.OnClickListener{
    
    Button bnf,bno;
    TextView ttVc[],ttVn[];
    EditText etPrivate,etSeed,etPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        bnf= (Button) findViewById(R.id.billing_buttonFinish);
        bnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bno= (Button) findViewById(R.id.billing_buttonCode);
        bno.setOnClickListener(this);
        ttVc=new TextView[9];
        ttVc[0]= (TextView) findViewById(R.id.billing_ttVoteA1);
        ttVc[1]= (TextView) findViewById(R.id.billing_ttVoteB1);
        ttVc[2]= (TextView) findViewById(R.id.billing_ttVoteC1);
        ttVc[3]= (TextView) findViewById(R.id.billing_ttVoteD1);
        ttVc[4]= (TextView) findViewById(R.id.billing_ttVoteE1);
        ttVc[5]= (TextView) findViewById(R.id.billing_ttVoteF1);
        ttVc[6]= (TextView) findViewById(R.id.billing_ttVoteG1);
        ttVc[7]= (TextView) findViewById(R.id.billing_ttVoteH1);
        ttVc[8]= (TextView) findViewById(R.id.billing_ttVoteI1);
        ttVn=new TextView[9];
        ttVn[0]= (TextView) findViewById(R.id.billing_ttVoteA2);
        ttVn[1]= (TextView) findViewById(R.id.billing_ttVoteB2);
        ttVn[2]= (TextView) findViewById(R.id.billing_ttVoteC2);
        ttVn[3]= (TextView) findViewById(R.id.billing_ttVoteD2);
        ttVn[4]= (TextView) findViewById(R.id.billing_ttVoteE2);
        ttVn[5]= (TextView) findViewById(R.id.billing_ttVoteF2);
        ttVn[6]= (TextView) findViewById(R.id.billing_ttVoteG2);
        ttVn[7]= (TextView) findViewById(R.id.billing_ttVoteH2);
        ttVn[8]= (TextView) findViewById(R.id.billing_ttVoteI2);
        for(int i=0;i<9;++i){
            ttVc[i].setText(String.format("%d:",i+1));
            ttVn[i].setText(" ");
        }
        etPrivate= (EditText) findViewById(R.id.billing_etPrivate);
        etSeed= (EditText) findViewById(R.id.billing_etSeed);
        etPerson= (EditText) findViewById(R.id.billing_etPerson);
    }

    @Override
    public void onClick(View v) {
        String strC=etPerson.getText().toString();
        BigInteger b_numb=new BigInteger(strC);
        BigInteger b_num_p1=new BigInteger(etPrivate.getText().toString());
        BigInteger b_num_p2=new BigInteger(etSeed.getText().toString());
        int tp;
        //==============================
        b_numb=b_numb.modPow(b_num_p1,b_num_p2);
        String strN=b_numb.toString();
        for(int i=0;i<9;++i){
            tp=Integer.parseInt(String.format("%c",strN.charAt(i)));
            ttVn[tp-1].setText(String.format("%c",65+i));
        }
    }
}
