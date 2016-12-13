package andyciu.secretballotrsa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

public class BallotFActivity extends AppCompatActivity implements Button.OnClickListener{

    Button bnf,bnc;
    TextView ttVc[],ttVn[],ttC;
    EditText etP[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ballot_f);
        bnf= (Button) findViewById(R.id.billing_buttonFinish);
        bnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bnc= (Button) findViewById(R.id.ballotF_buttonCode);
        bnc.setOnClickListener(this);
        ttVc=new TextView[9];
        ttVc[0]= (TextView) findViewById(R.id.ballotF_ttVoteA1);
        ttVc[1]= (TextView) findViewById(R.id.ballotF_ttVoteB1);
        ttVc[2]= (TextView) findViewById(R.id.ballotF_ttVoteC1);
        ttVc[3]= (TextView) findViewById(R.id.ballotF_ttVoteD1);
        ttVc[4]= (TextView) findViewById(R.id.ballotF_ttVoteE1);
        ttVc[5]= (TextView) findViewById(R.id.ballotF_ttVoteF1);
        ttVc[6]= (TextView) findViewById(R.id.ballotF_ttVoteG1);
        ttVc[7]= (TextView) findViewById(R.id.ballotF_ttVoteH1);
        ttVc[8]= (TextView) findViewById(R.id.ballotF_ttVoteI1);
        ttVn=new TextView[9];
        ttVn[0]= (TextView) findViewById(R.id.ballotF_ttVoteA2);
        ttVn[1]= (TextView) findViewById(R.id.ballotF_ttVoteB2);
        ttVn[2]= (TextView) findViewById(R.id.ballotF_ttVoteC2);
        ttVn[3]= (TextView) findViewById(R.id.ballotF_ttVoteD2);
        ttVn[4]= (TextView) findViewById(R.id.ballotF_ttVoteE2);
        ttVn[5]= (TextView) findViewById(R.id.ballotF_ttVoteF2);
        ttVn[6]= (TextView) findViewById(R.id.ballotF_ttVoteG2);
        ttVn[7]= (TextView) findViewById(R.id.ballotF_ttVoteH2);
        ttVn[8]= (TextView) findViewById(R.id.ballotF_ttVoteI2);
        ttC= (TextView) findViewById(R.id.ballotF_ttCode2);
        etP=new EditText[2];
        etP[0]= (EditText) findViewById(R.id.ballotF_etPublic1);
        etP[1]= (EditText) findViewById(R.id.ballotF_etPublic2);
        for(int i=0;i<9;++i){
            ttVc[i].setText(String.format("%c:",65+i));
            ttVn[i].setText(" ");
        }
    }

    @Override
    public void onClick(View v) {
        String strC=BallotPersonCodeRandom();
        BigInteger b_numb=new BigInteger(strC);
        BigInteger b_num_p1=new BigInteger(etP[0].getText().toString());
        BigInteger b_num_p2=new BigInteger(etP[1].getText().toString());
        //==============================
        b_numb=b_numb.modPow(b_num_p1,b_num_p2);
        for(int i=0;i<9;++i){
            ttVn[i].setText(String.format("%c",strC.charAt(i)));
        }
        ttC.setText(b_numb.toString());
    }
    public String BallotPersonCodeRandom(){
        Date now=new Date();
        Random rn=new Random(now.getTime());
        Boolean num[]=new Boolean[]{false,false,false,false,false,false,false,false,false};
        StringBuffer strB1=new StringBuffer(9);
        int ck=0,tempNum;
        while(ck<9){
            tempNum=rn.nextInt(9);
            if(num[tempNum]==false){
                num[tempNum]=true;
                ++ck;
                strB1.append(tempNum+1);
            }
        }
        return strB1.toString();
    }
}
