package com.example.wifi.ui.login.ui.slideshow;

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

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private List<Map<String, Object>> lists;
    private SimpleAdapter adapter;
    private ListView listView;

    private String[] theme = {"张明", "李明", "李明"};
    private String[] content = {"600 602 501", "666 620 502", "666 620 503"};
    private int[] imageViews = {R.drawable.icon1, R.drawable.icon2, R.drawable.icon3};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        lists = new ArrayList<>();
        for (int i = 0; i < theme.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", imageViews[i]);
            map.put("theme", theme[i]);
            map.put("content", content[i]);
            lists.add(map);
        }


        adapter = new SimpleAdapter(getActivity(), lists, R.layout.unit, new String[]{"image", "theme", "content"}, new int[]{R.id.image1, R.id.text1, R.id.text2});
        listView = (ListView) root.findViewById(R.id.listview2);
        listView.setAdapter(adapter);


        return root;
    }
}