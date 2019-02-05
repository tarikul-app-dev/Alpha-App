package koffi.simplifiedcodingalpha.com.jonadanapaul.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import koffi.simplifiedcodingalpha.com.jonadanapaul.R;
import koffi.simplifiedcodingalpha.com.jonadanapaul.adapter.RelevanteFehlerbilderAdapter;
import koffi.simplifiedcodingalpha.com.jonadanapaul.database.LocalStorageDB;
import koffi.simplifiedcodingalpha.com.jonadanapaul.model.RelevanteFehlebilderModel;

import static koffi.simplifiedcodingalpha.com.jonadanapaul.utils.SaveLocalStorage.getValueFromSharedPreferences;

public class ProjektInit4von4Act extends AppCompatActivity {

    ArrayList<RelevanteFehlebilderModel> verfugbareList;
    ArrayList<RelevanteFehlebilderModel> showVerfugbareList;
    RelevanteFehlerbilderAdapter relevanteFehlerbilderAdapter;
    @BindView(R.id.lv_verfugbare_mitarbeiter)
    ListView lvVerfugbare;
    @BindView(R.id.lv_show_selected)
    ListView showLvVerfugbare;

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.rl_next)
    RelativeLayout rlNext;
    @BindView(R.id.txv_projk_item)
    TextView txvProjekItem;


    boolean isMA0;
    boolean isMA1;
    boolean isMA2;
    LocalStorageDB localStorageDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projekt_init4von4);
        initViews();

    }

    public void initViews(){
        ButterKnife.bind(this);
        setOnClickListener();
        String getProjektItem = getValueFromSharedPreferences("projekt_exist", ProjektInit4von4Act.this);
        if (getProjektItem!=null){
            txvProjekItem.setText(getProjektItem);
        }

        localStorageDB = new LocalStorageDB(ProjektInit4von4Act.this);
        verfugbareList = new ArrayList<>();
        showVerfugbareList= new ArrayList<>();
        verfugbareList.add(new RelevanteFehlebilderModel("MA1"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA2"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA3"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA4"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA5"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA6"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA7"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA8"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA9"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA10"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA11"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA12"));

        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(verfugbareList,ProjektInit4von4Act.this);
        lvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);

        lvVerfugbare.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adpterView, View view, int position,
                                    long id) {


                if(position==0){
                    if(!isMA0){
                        lvVerfugbare.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA0 =true;

                         localStorageDB.open();
                         localStorageDB.saveItemName("MA1");

                         showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);

                    }else {
                        lvVerfugbare.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA0=false;

                        localStorageDB.open();
                        localStorageDB.delete("MA1");
                        showVerfugbareList= localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    }


                }

                else if(position==1) {
                    if (!isMA1) {
                        lvVerfugbare.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA1 = true;

                        localStorageDB.open();
                        localStorageDB.saveItemName("MA2");

                        showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    } else {
                        lvVerfugbare.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA1 = false;

                        try{
                            localStorageDB.open();
                            localStorageDB.delete("MA2");
                            showVerfugbareList= localStorageDB.getAllData();

                            relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                            showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }
                }else if(position==2){

                    if (!isMA2) {
                        lvVerfugbare.getChildAt(2).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA2 = true;

                        localStorageDB.open();
                        localStorageDB.saveItemName("MA3");

                        showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    } else {
                        lvVerfugbare.getChildAt(2).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA2 = false;

                        try{
                            localStorageDB.open();
                            localStorageDB.delete("MA3");
                            showVerfugbareList= localStorageDB.getAllData();

                            relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                            showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }


                }


            }
        });

    }

    public void setOnClickListener(){
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjektInit4von4Act.this,ProjektInit3von4Act.class);
                startActivity(intent);
            }
        });

        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjektInit4von4Act.this,FehlerauFnahmeAct.class);
                startActivity(intent);
            }
        });
    }
}
