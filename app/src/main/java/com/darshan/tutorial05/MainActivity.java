package com.darshan.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout tl_fName,tl_lName,tl_email,tl_password;
    TextInputEditText tv_fName,tv_lName,tv_email,tv_password;
    MaterialButton btnRegister;
    RadioGroup gender;
    SwitchMaterial sw_branch;
    RadioButton rb_male,rb_female;
    CheckBox cb_pStatus;
    private TextInputLayout textInputLayout;
    AutoCompleteTextView dropDownList;

    String[] itemDropDown = {"Ahmedabad", "Baroda", "Bhavnagar", "Gondal", "Junagadh", "Kutch", "Rajkot", "Surat"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item,itemDropDown);
        dropDownList = findViewById(R.id.dropdown);
        textInputLayout = findViewById(R.id.city_dropdown);
        dropDownList.setAdapter(adapter);

        tl_fName = findViewById(R.id.tl_fName);
        tv_fName = findViewById(R.id.tv_fName);
        tl_lName = findViewById(R.id.tl_lName);
        tv_lName = findViewById(R.id.tv_lName);
        tl_email = findViewById(R.id.tl_email);
        tv_email = findViewById(R.id.tv_email);
        tl_password = findViewById(R.id.tl_password);
        tv_password = findViewById(R.id.tv_password);
        btnRegister = findViewById(R.id.btnRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                if (tv_fName.getText().toString().equals("")){
                    tl_fName.setError("Ennter First Name");
                }else {
                    tl_fName.setErrorEnabled(false);
                }
            }
        });
    }
}