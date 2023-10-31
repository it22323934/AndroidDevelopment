package com.example.actual_challenge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7;
    FloatingActionButton f1;
    Button b1,b2;
    RadioGroup radioGroup1;
    Spinner sp1;
    CheckBox ch1;
    RelativeLayout r1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.edit1);
        e2=findViewById(R.id.editusername);
        e3=findViewById(R.id.editusername1);
        e4=findViewById(R.id.eidtpassword);
        e5=findViewById(R.id.editpassword1);
        e6=findViewById(R.id.editemail);
        e7=findViewById(R.id.editemail1);
        f1=findViewById(R.id.floating1);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        radioGroup1=findViewById(R.id.radiogroup);
        sp1=findViewById(R.id.spinner1);
        ch1=findViewById(R.id.check1);
        r1=findViewById(R.id.parent2);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radiobtn1:
                        Toast.makeText(MainActivity.this, "Male selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radiobtn2:
                        Toast.makeText(MainActivity.this, "Female selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radiobtn3:
                        Toast.makeText(MainActivity.this, "Other selected", Toast.LENGTH_SHORT).show();
                        break;
                    default:break;
                }
            }
        });
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, sp1.getSelectedItem().toString()+" Selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "You have agreed to the licence conditions.", Toast.LENGTH_SHORT).show();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();
            }
        });
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Support will be with you in a moment.", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().matches("")&&e2.getText().toString().matches("")&&e3.getText().toString().matches("")&&e4.getText().toString().matches("")&&e5.getText().toString().matches("")&&e6.getText().toString().matches("")&&e7.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Please input the data in to the fields.", Toast.LENGTH_SHORT).show();
                }
                else if(e1.getText().toString().matches("")||e2.getText().toString().matches("")||e3.getText().toString().matches("")||e4.getText().toString().matches("")||e5.getText().toString().matches("")||e6.getText().toString().matches("")||e7.getText().toString().matches("")){
                    if(e1.getText().toString().matches("")){
                        Toast.makeText(MainActivity.this, "Please input your name.", Toast.LENGTH_SHORT).show();
                    }
                    else if(e2.getText().toString().matches("")){
                        Toast.makeText(MainActivity.this, "Please input your username.", Toast.LENGTH_SHORT).show();
                    }
                    else if(e3.getText().toString().matches("")){
                        Toast.makeText(MainActivity.this, "Please input your confirmed username.", Toast.LENGTH_SHORT).show();
                    }
                    else if(e4.getText().toString().matches("")){
                        Toast.makeText(MainActivity.this, "Please input your password.", Toast.LENGTH_SHORT).show();
                    }
                    else if(e5.getText().toString().matches("")){
                        Toast.makeText(MainActivity.this, "Please input your confrmed password.", Toast.LENGTH_SHORT).show();
                    }
                    else if(e6.getText().toString().matches("")){
                        Toast.makeText(MainActivity.this, "please input your email.", Toast.LENGTH_SHORT).show();
                    }
                    else if(e7.getText().toString().matches("")){
                        Toast.makeText(MainActivity.this, "Please input your confirmed email.", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(e2.getText().toString().equals(e3.getText().toString())&&e4.getText().toString().equals(e5.getText().toString())&&e6.getText().toString().equals(e7.getText().toString())){
                    Toast.makeText(MainActivity.this, "Everything is a match", Toast.LENGTH_SHORT).show();
                    Snackbar.make(r1,"Name: "+e1.getText().toString()+"\n"+"Email: "+e6.getText().toString()+"\n"+"Country: "+sp1.getSelectedItem().toString(),Snackbar.LENGTH_INDEFINITE)
                            .setAction("Dismiss", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(MainActivity.this, "Data registered successfully", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .show();
                }
                else if(!e2.getText().toString().equals(e3.getText().toString())||!e4.getText().toString().equals(e5.getText().toString())||!e6.getText().toString().equals(e7.getText().toString())){
                    if(!e2.getText().toString().equals(e3.getText().toString())){
                        Toast.makeText(MainActivity.this, "Username is not a match", Toast.LENGTH_SHORT).show();
                    }
                    else if(!e4.getText().toString().equals(e5.getText().toString())){
                        Toast.makeText(MainActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                    else if(!e6.getText().toString().equals(e7.getText().toString())){
                        Toast.makeText(MainActivity.this, "Email does not match", Toast.LENGTH_SHORT).show();
                    }
                }
                /*else if(!e2.getText().toString().equals(e3.getText().toString())){
                    Toast.makeText(MainActivity.this, "Username is not a match", Toast.LENGTH_SHORT).show();
                }
                else if(e4.getText().toString().equals(e5.getText().toString())){
                    Toast.makeText(MainActivity.this, "Password match", Toast.LENGTH_SHORT).show();
                }
                else if(!e4.getText().toString().equals(e5.getText().toString())){
                    Toast.makeText(MainActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
                else if(e6.getText().toString().equals(e7.getText().toString())){
                    Toast.makeText(MainActivity.this, "Email match", Toast.LENGTH_SHORT).show();
                }
                else if(!e6.getText().toString().equals(e7.getText().toString())){
                    Toast.makeText(MainActivity.this, "Email does not match", Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.settings1:
                Toast.makeText(this, "Settings selected.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.alarm1:
                Toast.makeText(this, "Alarm selected", Toast.LENGTH_SHORT).show();
                return true;
            default:return super.onOptionsItemSelected(item);
        }
    }
}