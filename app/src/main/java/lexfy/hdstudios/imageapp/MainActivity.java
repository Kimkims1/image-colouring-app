package lexfy.hdstudios.imageapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnTakePicture, btnSavePicture;
    private ImageView imageView;

    private SeekBar seekBarOne, seekBarTwo, seekBarThree;
    private TextView TextViewOne, TextViewTwo, TextViewThree;

    private static final int CAMERA_REQUEST_CODE = 100;

    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSavePicture = findViewById(R.id.btnSavePicture);
        btnTakePicture = findViewById(R.id.btnTakePicture);
        imageView = findViewById(R.id.imageView);

        seekBarOne = findViewById(R.id.seekBarOne);
        seekBarTwo = findViewById(R.id.seekBarTwo);
        seekBarThree = findViewById(R.id.seekBarThree);
        TextViewOne = findViewById(R.id.TextViewOne);
        TextViewTwo = findViewById(R.id.TextViewTwo);
        TextViewThree = findViewById(R.id.TextViewThree);

        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                requestCamera();
            }
        });
    }

    private void requestCamera() {
        int permissionResult = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);
        if (permissionResult == PackageManager.PERMISSION_GRANTED) {
            PackageManager packageManager = getPackageManager();
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
            } else {
                Toast.makeText(MainActivity.this, "Your device does not have a Camera", Toast.LENGTH_LONG).show();
            }
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, "onActivityResult is called", Toast.LENGTH_SHORT).show();

        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK){

            Bundle bundle = data.getExtras();
            bitmap = (Bitmap) bundle.get("data");

            imageView.setImageBitmap(bitmap);
        }
    }
}
