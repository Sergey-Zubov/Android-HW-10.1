package com.szubov.android_hw_101;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final String KEY1 = "key1";
    private final String KEY2 = "key2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = findViewById(R.id.list);

        List<Map<String,String>> arrayList = prepareContent();
        BaseAdapter listContentAdapter = createAdapter(arrayList);
        mListView.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String,String>> arrayList) {
        return new SimpleAdapter(this, arrayList, R.layout.list_item,
                new String[]{KEY1,KEY2}, new int[]{R.id.textView1, R.id.textView2});
    }

    @NonNull
    private List<Map<String,String>> prepareContent() {
        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        List<Map<String,String>> list = new ArrayList<>();
        for (String s : arrayContent) {
            Map<String, String> map = new HashMap<>();
            map.put(KEY1, s);
            map.put(KEY2, s.length() + "");
            list.add(map);
        }
        return list;
    }
}