package com.example.fragmentloadingdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    CheckBox cb_cancelable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb_cancelable = findViewById(R.id.cb_cancelable);
    }

    public void showDialogLoading(View view) {
        LoadingDialogFragment.newInstance(cb_cancelable.isChecked()).show(getSupportFragmentManager(), LoadingDialogFragment.TAG);
    }
}