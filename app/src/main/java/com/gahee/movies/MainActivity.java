package com.gahee.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //TODO(6) recyclerView 레이아웃과 Adapter 객체를 선언해 줍니다.
    RecyclerView recyclerViewMain;
    MovieAdapter movieAdapter;

//액티비티 생명주기
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //화면에 보이는 레이아웃 초기화
        Toast.makeText(this, "On Create : 화면이 시작됩니다.", Toast.LENGTH_SHORT).show();
        //변수 초기화는 onCreate 에서 대부분 해줄 것.

        //TODO(7) 각각의 선언된 객체를 초기화 해 줍니다. 리소스를 초기화 할 때 findViewById 를 사용합니다.
        recyclerViewMain = findViewById(R.id.rv_main);
        movieAdapter = new MovieAdapter(this, createDummyTextList());

        //TODO(8) 아래의 세 setter 는 recycler view 사용 시 관례적으로 해주는 것들입니다.
        recyclerViewMain.setAdapter(movieAdapter);
        recyclerViewMain.setLayoutManager(new LinearLayoutManager(this));
        //TODO(8-1) setHasFixedSize 는 필수는 아닙니다. 위의 두개는 필수.
        recyclerViewMain.setHasFixedSize(true);
    }

    //TODO (7-1) MovieAdapter 객체 초기화 시 생성자에 넘겨줄 dummy text list 를 만듦니다.
    private ArrayList<String> createDummyTextList(){
        ArrayList<String> dummyText = new ArrayList<>();
        for(int i = 0; i < 16; i++){
            dummyText.add("My name is dummy " + i);
        }
        return dummyText;
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "On Start : 화면을 사용할 수 있도록 준비합니다.", Toast.LENGTH_SHORT).show();
        //액티비티가 사용자게에 보이게 되고, 앱은 액티비티를 foreground 에 보내 사용자가
        //앱과 상호작용 할 수 있도록 준비함.
        //앱이 UI를 관리하는 코드를 초기화
    }


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume : 화면에서 이벤트를 받을 수 있습니다.", Toast.LENGTH_SHORT).show();
        //앱이 이벤트를 받을 수 있는 상태가 됨. (이벤트 - 사용자 클릭 등)
        //다른 액티비티로 넘어가거나, 다른 앱이 열리는 등 앱에서 포커스가 떠나는 시점 까지는
        //onResume 상태에 있음
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "On Pause : 화면이 일시적으로 포커스를 잃습니다.", Toast.LENGTH_SHORT).show();
        //액티비티 떠날 때 처음으로 호출됨 - 소멸되는 것은 아님.
        //대화상자가 뜰 경우 포커스는 대화상자에 있고 뒷면은 반투명 처리될 때
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "On Stop : 화면이 중단됩니다.", Toast.LENGTH_SHORT).show();
        //액티비티가 중단됨
        //필요하지 않은 리소스를 해제하거나 조정 - ex. 애니메이션 정지 등
        //CPU 를 많이 소모하는 종료 작업을 실행해야. - ex. DB에 정보를 저장하는 작업.

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "On Destroy : 화면이 소멸됩니다.", Toast.LENGTH_SHORT).show();
        //액티비티가 완전히 소멸되기 전에 호출됨
        //아직 해제되지 않는 리소스를 해제
    }

}
