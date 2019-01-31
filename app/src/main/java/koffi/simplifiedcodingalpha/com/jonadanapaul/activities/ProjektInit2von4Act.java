package koffi.simplifiedcodingalpha.com.jonadanapaul.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import koffi.simplifiedcodingalpha.com.jonadanapaul.R;

import static koffi.simplifiedcodingalpha.com.jonadanapaul.utils.SaveLocalStorage.getValueFromSharedPreferences;

public class ProjektInit2von4Act extends AppCompatActivity {

    public static final int REQUEST_PERM_WRITE_STORAGE = 102;
    @BindView(R.id.lin_Warenbegleitschein_fotographieren1)
    LinearLayout linWarenbegPhotoOne;
    @BindView(R.id.lin_Warenbegleitschein_fotographieren2)
    LinearLayout linWarenbegPhotoTwo;
    @BindView(R.id.lin_Warenbegleitschein_fotographieren3)
    LinearLayout linWarenbegPhotoThree;
    @BindView(R.id.btn_Warenbegleitschein_fotographieren1)
    Button btnWarenbegPhotoOne;
    @BindView(R.id.btn_Warenbegleitschein_fotographieren2)
    Button btnWarenbegPhotoTwo;
    @BindView(R.id.btn_Warenbegleitschein_fotographieren3)
    Button btnWarenbegPhotoThree;

    @BindView(R.id.txv_projk_item)
    TextView txvProjekItem;

    @BindView(R.id.imgv_pic_one)
    ImageView imgvPicOne;
    @BindView(R.id.imgv_pic_two)
    ImageView imgvPicTwo;
    @BindView(R.id.imgv_pic_three)
    ImageView imgvPicThree;

    @BindView(R.id.btn_again_pic_one)
    Button btnAgainPicOne;
    @BindView(R.id.btn_again_pic_two)
    Button btnAgainPicTwo;
    @BindView(R.id.btn_again_pic_three)
    Button btnAgainPicThree;

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.rl_next)
    RelativeLayout rlNext;

    private int GALLERY = 1;
    private int GALLERY1 = 2;
    private int GALLERY2 = 3;
    private static final String IMAGE_DIRECTORY = "/alpha";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projekt_init2von4);
        initViews();
    }

    public void initViews(){
        ButterKnife.bind(this);
        setOnClickListener();

        String getProjektItem = getValueFromSharedPreferences("projekt_exist", ProjektInit2von4Act.this);
        if (getProjektItem!=null){
            txvProjekItem.setText(getProjektItem);
        }
    }
    public void setOnClickListener(){
        btnWarenbegPhotoOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                        ActivityCompat.requestPermissions(ProjektInit2von4Act.this,
                                new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERM_WRITE_STORAGE);

                    } else{
                        //takeOutletPhotoOneByCamera();
                        choosePhotoFromGallary();
                    }
                }
            });

        btnWarenbegPhotoTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(ProjektInit2von4Act.this,
                            new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERM_WRITE_STORAGE);

                } else{
                    //takeOutletPhotoOneByCamera();
                    choosePhotoFromGallaryOne();
                }
            }
        });

        btnWarenbegPhotoThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(ProjektInit2von4Act.this,
                            new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERM_WRITE_STORAGE);

                } else{
                    //takeOutletPhotoOneByCamera();
                    choosePhotoFromGallaryTwo();
                }
            }
        });


        btnAgainPicOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(ProjektInit2von4Act.this,
                            new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERM_WRITE_STORAGE);

                } else{
                    //takeOutletPhotoOneByCamera();
                    choosePhotoFromGallary();
                }
            }
        });
        btnAgainPicTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(ProjektInit2von4Act.this,
                            new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERM_WRITE_STORAGE);

                } else{
                    //takeOutletPhotoOneByCamera();
                    choosePhotoFromGallaryOne();
                }
            }
        });

        btnAgainPicThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(ProjektInit2von4Act.this,
                            new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERM_WRITE_STORAGE);

                } else{
                    //takeOutletPhotoOneByCamera();
                    choosePhotoFromGallaryTwo();
                }
            }
        });

        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjektInit2von4Act.this,ProjektInit1von4Act.class);
                startActivity(intent);
            }
        });

        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ProjektInit2von4Act.this,ProjektInit2von4Act.class);
//                startActivity(intent);
            }
        });

    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    public void choosePhotoFromGallaryOne() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY1);
    }
    public void choosePhotoFromGallaryTwo() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY2);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    String path = saveImage(bitmap);
                    Toast.makeText(ProjektInit2von4Act.this, "Image Saved!", Toast.LENGTH_SHORT).show();


                   // imgvPIC.setImageBitmap(bitmap);
                    btnWarenbegPhotoOne.setVisibility(View.GONE);
                    imgvPicOne.setImageBitmap(bitmap);
                    btnAgainPicOne.setVisibility(View.VISIBLE);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(ProjektInit2von4Act.this, "Failed!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }else if (requestCode == GALLERY1){
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    String path = saveImage(bitmap);
                    Toast.makeText(ProjektInit2von4Act.this, "Image Saved!", Toast.LENGTH_SHORT).show();


                    // imgvPIC.setImageBitmap(bitmap);
                    btnWarenbegPhotoTwo.setVisibility(View.GONE);
                    imgvPicTwo.setImageBitmap(bitmap);
                    btnAgainPicTwo.setVisibility(View.VISIBLE);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(ProjektInit2von4Act.this, "Failed!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else if (requestCode == GALLERY2){
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    String path = saveImage(bitmap);
                    Toast.makeText(ProjektInit2von4Act.this, "Image Saved!", Toast.LENGTH_SHORT).show();


                    // imgvPIC.setImageBitmap(bitmap);
                    btnWarenbegPhotoThree.setVisibility(View.GONE);
                    imgvPicThree.setImageBitmap(bitmap);
                    btnAgainPicThree.setVisibility(View.VISIBLE);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(ProjektInit2von4Act.this, "Failed!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::---&gt;" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }
}
