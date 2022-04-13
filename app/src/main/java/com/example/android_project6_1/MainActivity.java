package com.example.android_project6_1;

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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer1;
    Button btnStart, btnEnd;
    RadioButton radioCal, radioTime;
    TimePicker timePicker1;
    CalendarView calendarView1;
    TextView Year,Month, Day, Hour, Minute;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        btnStart=(Button)findViewById(R.id.btnStart);
        btnEnd=(Button)findViewById(R.id.btnEnd);
        chronometer1=(Chronometer)findViewById(R.id.chronometer1);
        radioCal=(RadioButton) findViewById(R.id.radioCal);
        radioTime=(RadioButton) findViewById(R.id.radioTime);
        timePicker1=(TimePicker) findViewById(R.id.timePicker1);
        calendarView1=(CalendarView) findViewById(R.id.calendarView1);
        Year=(TextView) findViewById(R.id.Year);
        Month=(TextView) findViewById(R.id.Month);
        Day=(TextView) findViewById(R.id.Day);
        Hour=(TextView) findViewById(R.id.Hour);
        Minute=(TextView) findViewById(R.id.Minute);

        timePicker1.setVisibility(View.INVISIBLE);
        calendarView1.setVisibility(View.INVISIBLE);

        radioCal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                timePicker1.setVisibility(View.INVISIBLE);
                calendarView1.setVisibility(View.VISIBLE);
            }
        });
        radioTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker1.setVisibility(View.VISIBLE);
                calendarView1.setVisibility(View.INVISIBLE);
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                chronometer1.setBase(SystemClock.elapsedRealtime());
                chronometer1.start();
                chronometer1.setTextColor(Color.RED);
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                chronometer1.stop();
                chronometer1.setTextColor(Color.BLUE);
                Year.setText(Integer.toString(selectYear));
                Month.setText(Integer.toString(selectMonth));
                Day.setText(Integer.toString(selectDay));

                Hour.setText(Integer.toString(timePicker1.getCurrentHour()));
                Minute.setText(Integer.toString(timePicker1.getCurrentMinute()));
            }
        });
        calendarView1.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth){
                selectYear=year;
                selectMonth=month+1;
                selectDay=dayOfMonth;
            }
        });
    }
}