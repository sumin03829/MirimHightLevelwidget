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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioButton radioDate,radioTime;
    CalendarView calender1;
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
        calender1=findViewById(R.id.calender1);
        timaPick1=findViewById(R.id.time_pick);
        chrono = findViewById(R.id.chrono1);
        textResult=findViewById(R.id.text_result);
        Button btnStart=findViewById(R.id.btn_start);
        Button btnStop=findViewById(R.id.btn_stop);
        btnStart.setOnClickListener(btnListener);
        btnStop.setOnClickListener(btnListener);
        calender1.setOnDateChangeListener(calendarListener);

    }
    View.OnClickListener radioListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.radio_date:
                    calender1.setVisibility(View.VISIBLE);
                    timaPick1.setVisibility(View.INVISIBLE);
                    break;
                case R.id.radio_time:
                    calender1.setVisibility(View.INVISIBLE);
                    timaPick1.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    View.OnClickListener btnListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_start:
                    chrono.setBase(SystemClock.elapsedRealtime());
                    chrono.start();
                    chrono.setTextColor(Color.RED);
                    break;
                case R.id.btn_stop:
                    chrono.stop();
                    chrono.setTextColor(Color.BLUE);
                    textResult.setText(dateStr+timaPick1.getCurrentHour()+"시"+timaPick1.getCurrentMinute()+"분");
                    break;
            }
        }
    };

    String dateStr="";

    CalendarView.OnDateChangeListener calendarListener =new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
            dateStr=year+"년"+(month+1)+"월"+dayOfMonth+"일";
        }
    };
}