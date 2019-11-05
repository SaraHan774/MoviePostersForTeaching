package com.gahee.movies;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.gahee.movies.Constants.DETAIL_DATA_KEY;

//TODO(1) Adapter class 를 작성해 줍니다.
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    Context context;
    ArrayList<String> dummyTextList;
    // TODO(3) Main Activity 에서 정보를 넘겨받을 생성자를 만들어 줍니다.  Context 받는 것 잊지 마세요.
    public MovieAdapter(Context context, ArrayList<String> arrayList){
        this.context = context;
        dummyTextList = arrayList;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO(4) 넘겨받은 context 와 미리 만들어 둔 view holder layout 를 사용해 view 를 inflate 시켜줍니다.
        //레이아웃을 깔아준다
        //뷰홀더 객체를 레이아웃으로 초기화 해서 return 해준다.
        View viewHolderLayout  = LayoutInflater.from(context).inflate(R.layout.rv_main_view_holder, parent, false);
        return new MovieViewHolder(viewHolderLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {
        //TODO(5) 넘겨받은 dummy text 의 리스트를 뷰 홀더의 포지션마다 binding 시켜줍니다.

        //뷰 홀더가 화면에 여러개 뜨는데, 그 때 각 뷰홀더 마다 어떤 정보를 넘겨줄지
        //매개변수 : 뷰 홀더 객체, 뷰 홀더의 위치 0, 1, 2, ...
        // 1번 뷰 홀더에 text sample 을 띄워주겠다, 그 다음 2번엔 text sample2 이런식으로.
        if(dummyTextList != null){
            holder.textViewDummy.setText(dummyTextList.get(position));
        }

        holder.buttonDummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DETAIL_DATA_KEY, dummyTextList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //리사이클러뷰에 총 몇 개의 아이템이 들어가 있는지 return 값에 명시해준다.
        //본 예제의 경우 MovieAdapter 의 생성자로 넘어오는 리스트의 길이를 반환해 주면 됨.
        return dummyTextList.size();
    }

    //TODO(2) ViewHolder 를 inner class 로 만들어 줍니다.
    //Adapter class 에서만 쓰이는 클래스 이므로 inner class 로 만들어 준다.
    class MovieViewHolder extends RecyclerView.ViewHolder {
        //뷰 홀더 레이아웃에 들어있는 View 들을 선언, 아래의 생성자에서 초기화 해준다.
        //XML 에서 view 에 ID 설정 해주는 것 잊지 말기.

        TextView textViewDummy;
        Button buttonDummy;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            //뷰 홀더가 어떤 모양이 될지 위의 onCreateViewHolder 메소드에서 정해졌다.
            //레이아웃의 각 요소를 초기화 해준다.
            //ex) imageView = itemView.findViewById(R.id.poster);
            textViewDummy = itemView.findViewById(R.id.tv_main_dummy_text);
            buttonDummy = itemView.findViewById(R.id.btn_main_dummy_button);
        }
    }
}
