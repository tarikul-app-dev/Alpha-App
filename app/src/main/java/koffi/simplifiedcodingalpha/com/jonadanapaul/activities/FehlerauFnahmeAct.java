package koffi.simplifiedcodingalpha.com.jonadanapaul.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import koffi.simplifiedcodingalpha.com.jonadanapaul.R;

public class FehlerauFnahmeAct extends AppCompatActivity {
    @BindView(R.id.imgv_nio_nok)
    ImageView btnNioNOk;
    @BindView(R.id.imgv_sonderfreigabe)
    ImageView btnSonderfreigabe;
    @BindView(R.id.imgv_io_ok)
    ImageView btnIOOk;

    @BindView(R.id.lin_reset)
    LinearLayout btnresetCount;

    static TextView txvshowNioNOk;
    TextView txvshowSonderfreigabe;
    TextView txvshowIoOk;
    TextView txvSumme;

    static int countNioOk=0;
    static int countSonderfreigabe=0;
    static int countIoOk=0;
    static int countSumme=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fehlerau_fnahme);
        initViews();
    }

    public void initViews(){

        ButterKnife.bind(this);
        setOnClickListener();
        txvshowNioNOk = (TextView)findViewById(R.id.txv_result);
        txvshowSonderfreigabe = (TextView)findViewById(R.id.txv_result_sonderfreigabe);
        txvshowIoOk = (TextView)findViewById(R.id.txv_result_io_ok);
        txvSumme = (TextView)findViewById(R.id.txv_summe);

        txvshowNioNOk.setText(String.valueOf(0));

    }
    public void setOnClickListener(){
        btnNioNOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FehlerauFnahmeAct.this,FehlerdetailsAct.class);
                startActivity(intent);
                countNioOk++;
                txvshowNioNOk.setText(String.valueOf(countNioOk));
                countSumme = countNioOk + countIoOk ;
              //  txvSumme.setText(String.valueOf(countSumme));
            }
        });

        btnSonderfreigabe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countSonderfreigabe++;
                txvshowSonderfreigabe.setText(String.valueOf(countSonderfreigabe));
                countIoOk++;
                txvshowIoOk.setText(String.valueOf(countIoOk));

                countNioOk--;
                txvshowNioNOk.setText(String.valueOf(countNioOk));
            }
        });

        btnIOOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countIoOk++;
                txvshowIoOk.setText(String.valueOf(countIoOk));
                countSumme = countNioOk + countIoOk ;
                txvSumme.setText(String.valueOf(countSumme));
            }
        });

        btnresetCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countNioOk=0;
                countSonderfreigabe=0;
                countIoOk=0;
                //countSumme = 0;
                    txvshowNioNOk.setText(String.valueOf(countNioOk));
                    txvshowSonderfreigabe.setText(String.valueOf(countSonderfreigabe));
                    txvshowIoOk.setText(String.valueOf(countIoOk));
                    txvSumme.setText("0");
            }
        });



    }


    @Override
    public void onResume(){
        super.onResume();
        // put your code here...

        txvshowNioNOk.setText(String.valueOf(countNioOk));
        txvshowSonderfreigabe.setText(String.valueOf(countSonderfreigabe));
        txvshowIoOk.setText(String.valueOf(countIoOk));
        txvSumme.setText(String.valueOf(countSumme));

    }
}
