package com.example.vmac.WatBot;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class BarCodeActivity extends AppCompatActivity {

    CameraSource cameraSource;
    SurfaceView cameraView;
    TextView barcodeInfo;
    Button confirmar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code);


        cameraView = (SurfaceView) findViewById(R.id.camera_view);

        BarcodeDetector barcodeDetector =
                new BarcodeDetector.Builder(this)
                        .setBarcodeFormats(Barcode.EAN_13)
                        .build();

        cameraSource = new CameraSource
                .Builder(this, barcodeDetector)
                .setRequestedPreviewSize(800, 800).setAutoFocusEnabled(true).build();


        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

                try {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    cameraSource.start(cameraView.getHolder());
                } catch (IOException ie) {
                    Log.e("CAMERA SOURCE", ie.getMessage());
                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();

            }

        });


        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {

                final SparseArray<Barcode> barcodes = detections.getDetectedItems();

                if (barcodes.size() != 0) {

                    if(barcodes.valueAt(0).displayValue.equals("7898290432082")) {
                        Bundle bundle = new Bundle();
                        bundle.putString("produto", "achocolatado");
                        Intent intent = new Intent(getApplicationContext(), ProdutoActivity.class);
                        barcodes.setValueAt(0,null);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                    if(barcodes.valueAt(0).displayValue.equals("7898290435571")) {
                        Bundle bundle = new Bundle();
                        bundle.putString("produto", "naturalle");
                        barcodes.setValueAt(0,null);
                        Intent intent = new Intent(getApplicationContext(), ProdutoActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                    if(barcodes.valueAt(0).displayValue.equals("7898290430767")) {
                        Bundle bundle = new Bundle();
                        bundle.putString("produto", "chocolade");
                        barcodes.setValueAt(0,null);
                        Intent intent = new Intent(getApplicationContext(), ProdutoActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                    if(barcodes.valueAt(0).displayValue.equals("7898290431917")) {
                        Bundle bundle = new Bundle();
                        bundle.putString("produto", "kids");
                        barcodes.setValueAt(0,null);
                        Intent intent = new Intent(getApplicationContext(), ProdutoActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }



                    barcodeInfo.post(new Runnable() {    // Use the post method of the TextView
                        public void run() {

                        }
                    });
                }


            }
        });
    }}