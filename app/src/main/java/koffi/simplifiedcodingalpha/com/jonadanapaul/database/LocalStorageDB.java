package koffi.simplifiedcodingalpha.com.jonadanapaul.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;

import koffi.simplifiedcodingalpha.com.jonadanapaul.model.RelevanteFehlebilderModel;


/**
 * Created by User on 2/3/2018.
 */

public class LocalStorageDB {
    //to local storage table
    public static final String KEY_ROWID = "id";
    public static final String KEY_ITEM_NAME = "item_name";



    // db version
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "alpha";
    private static final String DATABASE_TABLE_VERFUGBARE = "verfugbare";


    private LocalStorageDB.DBHelper dbhelper;
    private final Context context;
    private SQLiteDatabase database;

    private TableLayout mtableLayout,mCloumnHeader;

    String RESPONSE_UPDATE = "update";

    private static class DBHelper extends SQLiteOpenHelper {

        @SuppressLint("NewApi")
        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            // create table to store msgs
            db.execSQL("CREATE TABLE " + DATABASE_TABLE_VERFUGBARE + " ("
                    + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "

                    + KEY_ITEM_NAME + " TEXT UNIQUE);");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_VERFUGBARE);
            //db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_BASIC_INFORMATION);

            onCreate(db);
        }

    }
    // constructor
    public LocalStorageDB(Context c) {
        context = c;


    }

    // open db
    public LocalStorageDB open() {
        dbhelper = new  DBHelper(context);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    // close db
    public void close() {
        dbhelper.close();
    }

    // insert login information
    public long saveItemName(String itemName){
        ContentValues cv = new ContentValues();
        cv.put(KEY_ITEM_NAME, itemName);



        long dbInsert = database.insert(DATABASE_TABLE_VERFUGBARE, null, cv);
        //saveToSharedPreferences("rowid", String.valueOf(dbInsert),context);

//        if(dbInsert != -1) {
//            Toast.makeText(context, "New row added in local storage, row id: " + dbInsert, Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show();
//        }

        return dbInsert;

    }


//    public void clearPhotoTable(){
//        database.execSQL("delete from "+ DATABASE_TABLE_PICURI );
//    }


    public void delete(String itemName)
    {
        try {
            long dbDelete =  database.delete(DATABASE_TABLE_VERFUGBARE, KEY_ITEM_NAME + "=?", new String[] {itemName});
         // long dbDelete  = database.delete(DATABASE_TABLE_VERFUGBARE, "item_name="+Id, null);
//            if(dbDelete != -1) {
//                Toast.makeText(context, "delete, row id: " + dbDelete, Toast.LENGTH_SHORT).show();
//            }else{
//                Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show();
//            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }




//    public boolean checkOutletId(String outletId) throws SQLException
//    {
//        Cursor cursor = database.query(DATABASE_TABLE_SERVEY_STORAGE, null, " outlet_code=? ",
//                new String[] { outletId }, null, null, null);
//
//        if (cursor != null) {
//            if(cursor.getCount() > 0)
//            {
//                return true;
//            }
//        }
//        return false;
//    }





    public ArrayList getAllData(){

        ArrayList<RelevanteFehlebilderModel> serveyList = new ArrayList<>();

        //Tr: Modified
        String select_query = "SELECT item_name FROM " + DATABASE_TABLE_VERFUGBARE ;


        Cursor cursor = database.rawQuery(select_query,null);

        // if(cursor != null && cursor.moveToFirst()){
        //int iDbId = cursor.getColumnIndex(KEY_ROWID);
        int iItemName = cursor.getColumnIndex(KEY_ITEM_NAME);



        for (cursor.moveToLast(); ! cursor.isBeforeFirst(); cursor.moveToPrevious()) {
            //    for (cursor.moveToFirst(); ! cursor.isAfterLast(); cursor.moveToNext()) {

            RelevanteFehlebilderModel serveyModel = new RelevanteFehlebilderModel();
            serveyModel.setItemName(cursor.getString(iItemName));

            serveyList.add(serveyModel);

            // }
            //
        }
        cursor.close();
        return serveyList;
    }


}
