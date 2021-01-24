package com.example.zpo_lab14;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private static final String TAG = "EDUIB";
    private long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float timeStamp = event.timestamp;
        float [] values = event.values;
        float ax = values[0];
        float ay = values[1];
        float az = values[2];

        Log.d(TAG, ax+" "+ ay + "  " + az);

        BallView ballView = new BallView(this,(int)-ax*40,(int)ay*50 );
//        ballView.setX((int)-ax+ballView.getViewWidth()/2*75);
//        ballView.setY((int)ay+ballView.getViewHeight()/2*30);
        setContentView(ballView);


    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                2);
        startTime = System.currentTimeMillis();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}