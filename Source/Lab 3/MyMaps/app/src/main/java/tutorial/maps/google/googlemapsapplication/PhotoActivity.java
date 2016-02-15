package tutorial.maps.google.googlemapsapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


public class PhotoActivity extends AppCompatActivity {
    int TAKE_PHOTO_CODE = 0;
    ImageView userImage ;
    byte[] byteArray;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActionBar().setTitle("Capture image");
        setContentView(R.layout.activity_photoactivity);
        ImageButton capture = (ImageButton) findViewById(R.id.btn_take_photo);
        userImage = (ImageView) findViewById(R.id.view_photo);
        //Button click eventlistener. Initializes the camera.
        capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
            }
        });
    }
    //If the photo is captured then set the image view to the photo captured.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(photo);
            Log.d("CameraDemo", "Pic saved");
            //ByteArrayOutputStream stream = new ByteArrayOutputStream();
            //photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
            //byteArray = stream.toByteArray();
            ByteArrayOutputStream bStream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 100, bStream);
            byteArray = bStream.toByteArray();
        }
    }

    public void redirectToHome(View v) {
        Intent redirect = new Intent(PhotoActivity.this, Maps1Activity.class);
        redirect.putExtra("image", byteArray);
        startActivity(redirect);
        finish();
    }
    public void onPhotoClick(View v){
        ImageButton ibt = (ImageButton) findViewById(R.id.btn_take_photo);
        ibt.setVisibility(v.GONE);
    }

}