package com.ahmetoguzdavarci.covid19;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView tvToplamOlu, tvToplamVaka, textView2, textView4, textView5;
    TextView tvTurkiye,tvTr1, tvTr2, tvTr3,
            tvItalya, tvItl1, tvItl2, tvItl3,
            tvCin, tvCin1, tvCin2, tvCin3,
            tvAbd, tvAbd1, tvAbd2, tvAbd3,
            tvIspanya, tvIspanya1, tvIspanya2, tvIspanya3 ;
    Handler handler = new Handler();

    private SensorManager sensorManager;
    Sensor light;
    ConstraintLayout clArkaPlan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView2 = findViewById(R.id.textView2);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        tvToplamVaka = findViewById(R.id.tvToplamVaka);
        tvToplamOlu = findViewById(R.id.tvToplamOlu);
        tvTurkiye = findViewById(R.id.tvTurkiye);
        tvTr1 = findViewById(R.id.tvTr1);
        tvTr2 = findViewById(R.id.tvTr2);
        tvTr3 = findViewById(R.id.tvTr3);
        tvItalya = findViewById(R.id.tvItalya);
        tvItl1 = findViewById(R.id.tvItl1);
        tvItl2 = findViewById(R.id.tvItl2);
        tvItl3 = findViewById(R.id.tvItl3);
        tvCin = findViewById(R.id.tvCin);
        tvCin1 = findViewById(R.id.tvCin1);
        tvCin2 = findViewById(R.id.tvCin2);
        tvCin3 = findViewById(R.id.tvCin3);
        tvAbd = findViewById(R.id.tvAbd);
        tvAbd1 = findViewById(R.id.tvAbd1);
        tvAbd2 = findViewById(R.id.tvAbd2);
        tvAbd3 = findViewById(R.id.tvAbd3);
        tvIspanya = findViewById(R.id.tvIspanya);
        tvIspanya1 = findViewById(R.id.tvIspanya1);
        tvIspanya2 = findViewById(R.id.tvIspanya2);
        tvIspanya3 = findViewById(R.id.tvIspanya3);

        clArkaPlan = findViewById(R.id.clArkaPlan);

        textView2.setVisibility(TextView.INVISIBLE);
        textView4.setVisibility(TextView.INVISIBLE);
        textView5.setVisibility(TextView.INVISIBLE);

        tvTurkiye.setVisibility(TextView.INVISIBLE);
        tvTr1.setVisibility(TextView.INVISIBLE);
        tvTr2.setVisibility(TextView.INVISIBLE);
        tvTr3.setVisibility(TextView.INVISIBLE);

        tvItalya.setVisibility(TextView.INVISIBLE);
        tvItl1.setVisibility(TextView.INVISIBLE);
        tvItl2.setVisibility(TextView.INVISIBLE);
        tvItl3.setVisibility(TextView.INVISIBLE);

        tvCin.setVisibility(TextView.INVISIBLE);
        tvCin1.setVisibility(TextView.INVISIBLE);
        tvCin2.setVisibility(TextView.INVISIBLE);
        tvCin3.setVisibility(TextView.INVISIBLE);

        tvAbd.setVisibility(TextView.INVISIBLE);
        tvAbd1.setVisibility(TextView.INVISIBLE);
        tvAbd2.setVisibility(TextView.INVISIBLE);
        tvAbd3.setVisibility(TextView.INVISIBLE);

        tvIspanya.setVisibility(TextView.INVISIBLE);
        tvIspanya1.setVisibility(TextView.INVISIBLE);
        tvIspanya2.setVisibility(TextView.INVISIBLE);
        tvIspanya3.setVisibility(TextView.INVISIBLE);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(MainActivity.this, light, SensorManager.SENSOR_DELAY_NORMAL);

    }

    public void ServisAc(View view) {
        Intent intent =  new Intent(getApplicationContext(),IntentServis.class);
        MyResultReceiver myResultReceiver = new MyResultReceiver(null);
        intent.putExtra("receiver",myResultReceiver);
        ResultReceiver rr = intent.getParcelableExtra("receiver");

        textView2.setVisibility(TextView.VISIBLE);
        textView4.setVisibility(TextView.VISIBLE);
        textView5.setVisibility(TextView.VISIBLE);

        tvTurkiye.setVisibility(TextView.VISIBLE);
        tvTr1.setVisibility(TextView.VISIBLE);
        tvTr2.setVisibility(TextView.VISIBLE);
        tvTr3.setVisibility(TextView.VISIBLE);

        tvItalya.setVisibility(TextView.VISIBLE);
        tvItl1.setVisibility(TextView.VISIBLE);
        tvItl2.setVisibility(TextView.VISIBLE);
        tvItl3.setVisibility(TextView.VISIBLE);

        tvCin.setVisibility(TextView.VISIBLE);
        tvCin1.setVisibility(TextView.VISIBLE);
        tvCin2.setVisibility(TextView.VISIBLE);
        tvCin3.setVisibility(TextView.VISIBLE);

        tvAbd.setVisibility(TextView.VISIBLE);
        tvAbd1.setVisibility(TextView.VISIBLE);
        tvAbd2.setVisibility(TextView.VISIBLE);
        tvAbd3.setVisibility(TextView.VISIBLE);

        tvIspanya.setVisibility(TextView.VISIBLE);
        tvIspanya1.setVisibility(TextView.VISIBLE);
        tvIspanya2.setVisibility(TextView.VISIBLE);
        tvIspanya3.setVisibility(TextView.VISIBLE);

        startService(intent);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float isik =sensorEvent.values[0];
        if(isik<10000){
            clArkaPlan.setBackgroundColor(Color.parseColor("#F5A9BC"));
        }
        else if(isik>=10000 && isik<30000){
            clArkaPlan.setBackgroundColor(Color.parseColor("#F7FE2E"));
        }
        else if(isik>=30000){
            clArkaPlan.setBackgroundColor(Color.parseColor("#045FB4"));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(MainActivity.this, light,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    public class MyResultReceiver extends ResultReceiver{
        public MyResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, final Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);

            if(resultCode==10 && resultData!=null){
                handler.post(new Runnable() {
                    @Override
                    public void run() {


                        String oluSayilari = (String) resultData.get("gelenVeri1");
                        String vakaSayilari = (String) resultData.get("gelenVeri2");

                        String tVaka = vakaSayilari;
                        String tOlu = oluSayilari;

                        tvToplamVaka.setText(tVaka);
                        tvToplamOlu.setText(tOlu);

                        String tr = (String) resultData.get("turkey");
                        String[] dizi = tr.split("\\s");

                        tvTr1.setText(dizi[0]);
                        tvTr2.setText(dizi[1]);
                        tvTr3.setText(dizi[2]);

                        String italya = (String) resultData.get("italya");
                        String[] dizi1 = italya.split("\\s");

                        tvItl1.setText(dizi1[0]);
                        tvItl2.setText(dizi1[1]);
                        tvItl3.setText(dizi1[2]);

                        String cin = (String) resultData.get("cin");
                        String[] dizi2 = cin.split("\\s");

                        tvCin1.setText(dizi2[0]);
                        tvCin2.setText(dizi2[1]);
                        tvCin3.setText(dizi2[2]);

                        String abd = (String) resultData.get("abd");
                        String[] dizi3 = abd.split("\\s");

                        tvAbd1.setText(dizi3[0]);
                        tvAbd2.setText(dizi3[1]);
                        tvAbd3.setText(dizi3[2]);

                        String ispanya = (String) resultData.get("ispanya");
                        String[] dizi4 = ispanya.split("\\s");

                        tvIspanya1.setText(dizi4[0]);
                        tvIspanya2.setText(dizi4[1]);
                        tvIspanya3.setText(dizi4[2]);

                    }
                });
            }
        }
    }
}
