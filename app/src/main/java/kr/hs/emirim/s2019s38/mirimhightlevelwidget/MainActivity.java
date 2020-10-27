package kr.hs.emirim.s2019s38.mirimhightlevelwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioButton radioDate,radioTime;
    CalendarView calender1;
    TimePicker timaPick1;

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
}