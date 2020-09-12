package com.darshan.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
    RadioButton rb_Checked;
    CheckBox cb_pStatus;
    private TextInputLayout textInputLayout;
    AutoCompleteTextView dropDownList;
    int idSelected;

    String[] itemDropDown = {"Select City","Ahmedabad", "Baroda", "Bhavnagar", "Gondal", "Junagadh", "Kutch", "Rajkot", "Surat"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tl_fName = findViewById(R.id.tl_fName);
        tv_fName = findViewById(R.id.tv_fName);
        tl_lName = findViewById(R.id.tl_lName);
        tv_lName = findViewById(R.id.tv_lName);
        tl_email = findViewById(R.id.tl_email);
        tv_email = findViewById(R.id.tv_email);
        tl_password = findViewById(R.id.tl_password);
        tv_password = findViewById(R.id.tv_password);
        sw_branch = findViewById(R.id.sw_branch);
        gender = findViewById(R.id.gender);
        dropDownList = findViewById(R.id.dropdown);
        textInputLayout = findViewById(R.id.city_dropdown);
        cb_pStatus = findViewById(R.id.cb_pStatus);
        btnRegister = findViewById(R.id.btnRegister);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item,itemDropDown);
        dropDownList.setAdapter(adapter);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String valEmail = tv_email.getText().toString();
                Intent intent = new Intent(MainActivity.this,Home.class);
                if (tv_fName.getText().toString().equals("")){
                    tl_fName.setError("Enter First Name");
                }else if (tv_lName.getText().toString().equals("")) {
                    tl_lName.setError("Enter Last Name");
                }else if (tv_email.getText().toString().equals("")){
                    tl_email.setError("Please Enter Email!");
                }else if(!Patterns.EMAIL_ADDRESS.matcher(valEmail).matches()){
                    tl_email.setError("Please Enter Valid Email!");
                }else if (tv_password.getText().toString().equals("")){
                    tl_password.setError("Password should not be empty");
                }else if (dropDownList.getText().toString().equals("Select City")){
                    textInputLayout.setError("Please Select City");
                }else{
                    tl_fName.setErrorEnabled(false);
                    tl_lName.setErrorEnabled(false);
                    tl_email.setErrorEnabled(false);
                    tl_email.setErrorEnabled(false);
                    tl_password.setErrorEnabled(false);
                    textInputLayout.setErrorEnabled(false);
                    idSelected=gender.getCheckedRadioButtonId();
                    rb_Checked=findViewById(idSelected);
                    intent.putExtra("FirstName",tv_fName.getText().toString());
                    intent.putExtra("LastName",tv_lName.getText().toString());
                    intent.putExtra("Email",tv_email.getText().toString());
                    intent.putExtra("Password",tv_password.getText().toString());
                    intent.putExtra("Gender",rb_Checked.getText());
                    intent.putExtra("City",dropDownList.getText().toString());
                    if(sw_branch.isChecked()){
                        intent.putExtra("Branch","IT");
                    }else{
                        intent.putExtra("Branch","CE");
                    }
                    if(cb_pStatus.isChecked()){
                        intent.putExtra("Status","Active");
                    }else{
                        intent.putExtra("Status","Inactive");
                    }
                    startActivity(intent);
                }
            }
        });
    }
}