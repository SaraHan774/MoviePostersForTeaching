package com.gahee.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.gahee.movies.Constants.DETAIL_DATA_KEY;

public class DetailActivity extends AppCompatActivity {

    TextView textViewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //getIntent()를 호출해서 넘겨져온 intent 에 맞는 데이터를 가져옵니다.
        String dataFromMain = getIntent().getStringExtra(DETAIL_DATA_KEY);
        textViewDetail = findViewById(R.id.tv_detail_dummy_text);
        textViewDetail.setText(String.format(getString(R.string.detail_welcome), dataFromMain));
        //물론 그냥 "WELCOME " + dataFromMain 을 해도 되지만 위의 방법을 권장합니다.
    }
}
