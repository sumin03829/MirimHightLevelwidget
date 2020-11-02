package kr.hs.emirim.s2019s38.mirimhightlevelwidget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioButton radioDate,radioTime;
    DatePicker datePink;
    TimePicker timaPick1;
    Chronometer chrono;
    TextView textResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        radioDate=findViewById(R.id.radio_date);
        radioTime=findViewById(R.id.radio_time);
        radioDate.setOnClickListener(radioListener);
        radioTime.setOnClickListener(radioListener);
        datePink=findViewById(R.id.date_pick);
        timaPick1=findViewById(R.id.time_pick);
        chrono = findViewById(R.id.chrono1);
        textResult=findViewById(R.id.text_result);
        chrono.setOnClickListener(chronoListener);
        textResult.setOnLongClickListener(textListener);
        radioDate.setVisibility(View.INVISIBLE);
        radioTime.setVisibility(View.INVISIBLE);
        datePink.setVisibility(View.INVISIBLE);
        timaPick1.setVisibility(View.INVISIBLE);


    }
    View.OnClickListener radioListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.radio_date:
                    datePink.setVisibility(View.VISIBLE);
                    timaPick1.setVisibility(View.INVISIBLE);
                    break;
                case R.id.radio_time:
                    datePink.setVisibility(View.INVISIBLE);
                    timaPick1.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    View.OnClickListener chronoListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            chrono.setBase(SystemClock.elapsedRealtime());
            chrono.start();
            chrono.setTextColor(Color.RED);
            radioDate.setVisibility(View.VISIBLE);
            radioTime.setVisibility(View.VISIBLE);
        }
    };

    View.OnLongClickListener textListener=new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            chrono.stop();
            chrono.setTextColor(Color.BLUE);
            textResult.setText(datePink.getYear()+"년"+(1+datePink.getMonth())+"월" +
                    datePink.getDayOfMonth()+"일");
            radioDate.setVisibility(View.INVISIBLE);
            radioTime.setVisibility(View.INVISIBLE);
            datePink.setVisibility(View.INVISIBLE);
            timaPick1.setVisibility(View.INVISIBLE);
            return false;
        }
    };



}