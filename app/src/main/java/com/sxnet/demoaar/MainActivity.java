package com.sxnet.demoaar;

import android.os.Bundle;
import android.widget.TextView;

import com.sxnet.liba.TestA;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        TextView text = findViewById(R.id.tv_content);
        text.setText(String.valueOf(new TestA().compute()));
    }
}
