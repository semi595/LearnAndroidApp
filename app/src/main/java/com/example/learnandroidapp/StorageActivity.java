package com.example.learnandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class StorageActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    private CheckBox ck_married;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        ck_married = findViewById(R.id.ck_married);

        preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
        reload();
    }

    private void reload() {
        String name = preferences.getString("name", null);
        if (name != null) {
            et_name.setText(name);
        }
        Integer age = preferences.getInt("age", 0);
        if (age != 0) {
            et_age.setText(String.valueOf(age));
        }
        float height = preferences.getFloat("height", 0f);
        if (height != 0f) {
            et_height.setText(String.valueOf(height));
        }
        float weight = preferences.getFloat("weight", 0f);
        if (weight != 0f) {
            et_weight.setText(String.valueOf(weight));
        }
        boolean married = preferences.getBoolean("married", false);
        ck_married.setChecked(married);

    }


    public void onSave(View view) {
        String name = et_name.getText().toString();
        String age = et_age.getText().toString();
        String height = et_height.getText().toString();
        String weight = et_weight.getText().toString();

        final SharedPreferences.Editor editor;
        editor = preferences.edit();
        editor.putString("name", name);
        editor.putInt("age", Integer.parseInt(age));
        editor.putFloat("height", Float.parseFloat(height));
        editor.putFloat("weight", Float.parseFloat(weight));
        editor.putBoolean("married", ck_married.isChecked());
        editor.apply();
    }
}