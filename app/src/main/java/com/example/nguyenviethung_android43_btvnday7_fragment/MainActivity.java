package com.example.nguyenviethung_android43_btvnday7_fragment;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.nguyenviethung_android43_btvnday7_fragment.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements ISave{
    ActivityMainBinding binding;

//    Button btnsave;
//    Spinner spinner;
//    TextView tvtags, tvweeks,tvdate,tvtime;
    SavePresenter savePresenter;
    Calendar myCal = Calendar.getInstance();

    private void getFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_btn_tune, fragment)
                .commit();
    }// end getFragment



    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view,
                              int year, int monthOfYear, int dayOfMonth) {
            myCal.set(Calendar.YEAR, year);
            myCal.set(Calendar.MONTH, monthOfYear);
            myCal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            binding.tvdate.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
        }
    };
    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myCal.set(Calendar.HOUR_OF_DAY, hourOfDay);
            myCal.set(Calendar.MINUTE, minute);
            binding.tvtime.setText(hourOfDay+":"+minute);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        //spinner
//        spinner = findViewById(R.id.spinner);
        ArrayList<String> type = new ArrayList<>();
        type.add("Friend");
        type.add("Work");
        type.add("Family");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, type);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(arrayAdapter);

        //btnsave
//        btnsave = findViewById(R.id.btnsave);
        binding.btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.menu, popupMenu.getMenu());
                popupMenu.show();
            }
        });


        savePresenter = new SavePresenter(this);
        binding.tvsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.app.AlertDialog alertDialog=new androidx.appcompat.app.AlertDialog.Builder(MainActivity.this)
                        .setTitle("Thông Báo")
                        .setMessage("Bạn có muốn lưu không")
                        .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                savePresenter.onSave(1);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                savePresenter.onSave(0);
                            }
                        })
                        .create();
                alertDialog.show();
            }
        });

        //btntune
        binding.btntune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(TuneFragment.newInstance());
            }
        });




        //tv tags
//        tvtags=findViewById(R.id.tvtags);
        binding.tvtags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"Family", "Game", "Android", "VTC", "Friend"};
                boolean[] booleans = {false, false, false, false, false};

                List<String> s = new ArrayList<>();
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).setTitle("Choose Tags:")
                        .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                                s.add(strings[which]);
                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).create();
                alertDialog.show();
            }
        });


        //tvweeks
//        tvweeks=findViewById(R.id.tvweeks);
        binding.tvweeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
                boolean[] booleans = {false, false, false, false, false, false, false};

                List<String> listWeek = new ArrayList<>();
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).setTitle("Choose Tags:")
                        .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                                listWeek.add(strings[which]);
                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).create();
                alertDialog.show();
            }
        });


        //tvdate
//        tvdate=findViewById(R.id.tvdate);
        binding.tvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, d,
                        myCal.get(Calendar.YEAR),
                        myCal.get(Calendar.MONTH),
                        myCal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        //tvtime
//        tvtime=findViewById(R.id.tvtime);
        binding.tvtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(MainActivity.this, t, myCal.get(Calendar.HOUR_OF_DAY), myCal.get(Calendar.MINUTE), true).show();

            }
        });



    }


    @Override
    public void onSaveSuccessful(String mess) {
        Toast.makeText(this,mess,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNotSave(String mess) {
        Toast.makeText(this,mess,Toast.LENGTH_LONG).show();
    }
}