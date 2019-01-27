package koffi.simplifiedcodingalpha.com.jonadanapaul.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import koffi.simplifiedcodingalpha.com.jonadanapaul.R;

public class ProjektInitAct extends AppCompatActivity {
    @BindView(R.id.spin_exist)
    Spinner spinExist;
    @BindView(R.id.spin_obarkategorie)
    Spinner spinObarkategorie;
    @BindView(R.id.spin_untercategorie)
    Spinner spinUntercategorie;
    @BindView(R.id.spin_bildocument)
    Spinner spinBildocument;
    @BindView(R.id.spin_prüfart)
    Spinner spinprüfart;
    @BindView(R.id.spin_packeinheit)
    Spinner spinPackeinheit;
    @BindView(R.id.spin_identifikationsart)
    Spinner spinIdentifikationsart;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projekt_init);

        initViews();
    }

    public void initViews(){
        ButterKnife.bind(this);
        setOnClickListener();

        ArrayAdapter adapte1 = ArrayAdapter.createFromResource(this, R.array.spinner_projekt, R.layout.spinner_row);
        spinExist.setAdapter(adapte1);

        ArrayAdapter adapteBild = ArrayAdapter.createFromResource(this, R.array.spinner_bildocument, R.layout.spinner_row);
        spinBildocument.setAdapter(adapteBild);

        ArrayAdapter adaptePrufart = ArrayAdapter.createFromResource(this, R.array.spinner_prüfart, R.layout.spinner_row);
        spinprüfart.setAdapter(adaptePrufart);

        ArrayAdapter adapterPackeinheit = ArrayAdapter.createFromResource(this, R.array.spinner_packeinheit, R.layout.spinner_row);
        spinPackeinheit.setAdapter(adapterPackeinheit);

        ArrayAdapter adapterIdentifikation = ArrayAdapter.createFromResource(this, R.array.spinner_identifikationsart, R.layout.spinner_row);
        spinIdentifikationsart.setAdapter(adapterIdentifikation);


    }

    public void setOnClickListener(){

    }
}
