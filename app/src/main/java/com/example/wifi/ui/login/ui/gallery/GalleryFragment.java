package com.example.wifi.ui.login.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.wifi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GalleryFragment extends Fragment  {

    private GalleryViewModel galleryViewModel;
    private List<Map<String, Object>> lists;
    private SimpleAdapter adapter;
    private ListView listView;

    private String[] theme = {"鼻涕怪", "臭脚怪", "便便怪","呕吐怪"};
    private String[] content1 = {"战斗力 5", "战斗力 6", "战斗力 7", "战斗力 7"};
    private int[] imageViews = {R.drawable.mon1, R.drawable.mon2, R.drawable.mon3, R.drawable.mon4};
    private String[] data = {"稀有度3","稀有度2","稀有度4","稀有度5"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        lists = new ArrayList<>();
        for (int i = 0; i < theme.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", imageViews[i]);
            map.put("theme", theme[i]);
            map.put("content", content1[i]);
            map.put("data",data[i]);
            lists.add(map);
        }


        adapter = new SimpleAdapter(getActivity(), lists, R.layout.monsterunit, new String[]{"image", "theme", "content","data"}, new int[]{R.id.image1, R.id.text1, R.id.text2, R.id.text3});
        listView = (ListView) root.findViewById(R.id.listview);
        listView.setAdapter(adapter);
        return root;
    }
}