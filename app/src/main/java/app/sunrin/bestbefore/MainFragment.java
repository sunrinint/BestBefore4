package app.sunrin.bestbefore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainFragment extends Fragment {

    String[][][] foods  = {
        {
            //채소
            {"대파", "10", "30"},
            {"양파", "7", "0"},
            {"가지", "5", "0"},
            {"애호박", "6", "0"},
            {"브로콜리", "7", "30"},
            {"당근", "15", "0"},
            {"양배추", "10", "0"},
            {"오이", "7", "0"},
            {"버섯", "5", "30"},
            {"감자", "5", "0"},
            {"마늘", "10", "0"},
            {"시금치", "3", "0"},
            {"고구마", "60", "0"},
            {"고추", "30", "0"},
            {"꺳잎", "90", "0"},
            {"배추&양배추", "7", "0"},
            {"도라지", "5", "0"},
            {"버섯류", "6", "0"},
            {"부추", "7", "45"},
            {"상추", "3", "0"},
            {"숙주나물", "4", "0"},
            {"콩나물", "10", "0"},
            {"방울토마토", "7", "30"},
            {"파프리카&피망", "25", "0"},
            {"호박", "30", "0"},
        },
        {
            //과일
            {"파인애플", "4", "0"},
            {"참외", "5", "0"},
            {"무화과", "4", "0"},
            {"체리", "7", "0"},
            {"복숭아", "4", "0"},
            {"블루베리", "3", "10"},
            {"아보카도", "4", "120"},
            {"산딸기", "7", "0"},
            {"자두", "4", "0"},
            {"레몬", "21", "0"},
            {"대추", "360", "0"},
            {"사과", "20", "0"},
            {"배", "6", "0"},
            {"포도", "3", "0"},
            {"복숭아", "4", "0"},
            {"수박", "5", "0"},
            {"바나나", "3", "20"}
        },
        {
            //육류
            {"소고기", "4", "180"},
            {"돼지고기", "3", "150"},
            {"닭고기", "2", "60"},
            {"익힌고기", "2", "0"},
            {"양고기", "7", "0"},
            {"오리고기", "10", "30"},
            {"소시지&햄", "60", "60"},
            {"베이컨", "14", "240"},
            {"달걀", "30", "0"},
        },
        {
            //해산물
            {"생선", "2", "90"},
            {"조개", "2", "30"},
            {"마른미역&다시마", "480", "0"},
            {"불린미역", "0", "60"},
            {"삶은문어", "0", "720"},
        },
        {
            //장&기름&조미료
            {"고추가루", "360", "360"},
            {"간장", "720", "0"},
            {"고추장", "600", "0"},
            {"된장", "720", "0"},
            {"마늘", "15", "0"},
            {"참기름", "360", "0"},
            {"식용유", "720", "0"},
            {"핫소스", "1080", "0"},
            {"다대기", "21", "90"},

        },
        {
            //냉동식품
            {"냉동채소&야채", "0", "40"},
            {"냉동과일", "0", "180"},
            {"냉동간편식품", "0", "180"},
            {"냉동닭가슴살", "60", "270"},
        },
        {
            //음료
            {"물", "360", "0"},
            {"식혜", "5", "360"},
            {"탄산음료", "360", "360"},
            {"맥주(CAN)", "360", "0"},
            {"맥주(PET)", "180", "0"},
            {"증류주(소주)", "-1", "0"},
            {"막걸리", "12", "0"},
            {"전통주", "720", "0"},
            {"과실주", "360", "0"},
            {"이온음료", "360", "360"},
            {"주스", "180", "180"},
            {"탄산수", "360", "0"}
        },
        {
            //기타
            {"국&반찬", "30", "30"},
            {"두부", "4", "0"},
            {"견과류", "0", "1080"},
            {"떡", "1", "30"},
            {"빵", "3", "90"},
            {"찹쌀가루", "0", "360"},
            {"멸치젓", "360", "0"},
            {"새우젓", "180", "0"},
            {"조개젓", "180", "0"},
            {"청란젓", "130", "0"}
        },
        {
            //유제품
            {"우유", "45", "0"},
            {"치즈", "60", "70"},
            {"버터", "210", "0"},
            {"크림", "7", "0"},
            {"연유", "180", "0"},
            {"요거트&요구르트", "30", "0"},
            {"아이스크림", "0", "-1"},
        },

    };

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    LinearLayoutManager layoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);


        recyclerView = root.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        for(int i = 0; i<foods.length; i++)
        {
            for(int j = 0; j<foods[i].length; j++)
            {
                Data data = new Data();
                data.setProductName(foods[i][j][0]);
                data.setProductCategory("그럴듯한 카테고리");
                data.setProductDate(foods[i][j][1]); // 추후 수정 필요
                adapter.addItem(data);
            }
        }

        adapter.notifyDataSetChanged();
        return root;
    }

}