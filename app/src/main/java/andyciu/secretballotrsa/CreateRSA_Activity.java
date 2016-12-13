package andyciu.secretballotrsa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

public class CreateRSA_Activity extends AppCompatActivity implements Button.OnClickListener{

    Button bn1,bnf;
    TextView tt1,tt2,tt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_rsa);
        bn1= (Button) findViewById(R.id.create_button1);
        bn1.setOnClickListener(this);
        bnf= (Button) findViewById(R.id.create_buttonFinish);
        bnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tt1= (TextView) findViewById(R.id.create_textRSApublic);
        tt2= (TextView) findViewById(R.id.create_textRSAseed);
        tt3= (TextView) findViewById(R.id.create_textRSAprivate);
    }

    @Override
    public void onClick(View v) {
        //====================
        Date now=new Date();
        Random rn=new Random(now.getTime());
        BigInteger numP,numQ,numN,numO,numE,numD;
        int ni;
        do{
            numP=BigInteger.probablePrime(17,rn);
            numQ=BigInteger.probablePrime(17,rn);
        }while(numP.compareTo(numQ)==0);
        numD=null;
        numN=new BigInteger(numP.multiply(numQ).toString());
        numO=new BigInteger(numP.subtract(new BigInteger("1")).multiply(numQ.subtract(new BigInteger("1"))).toString()); //(numP-1)*(numQ-1)
        do{
            ni=0;
            numE=new BigInteger(16,rn);
            if(numE.gcd(numO).intValue()==1){
                numD=new BigInteger(numO.add(new BigInteger("1")).divide(numE).toString());  //(numO+1)/numE
                if(numE.multiply(numD).mod(numO).intValue()==1){  //e*d mod O(Euler's Totient Function)=1
                    ni=1;
                }
            }
        }while(ni==0);
        //====================
        tt1.setText(numE.toString());
        tt2.setText(numN.toString());
        tt3.setText(numD.toString());
    }
}
