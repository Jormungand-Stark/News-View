package com.example.activitytest.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.activitytest.R;

// 新闻内容碎片
public class NewsContentFragment extends Fragment {
    private View view;

    // 加载布局
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag, container, false);
        return view;
    }

    // 将新闻标题和内容显示到界面上
    public void refresh(String newTitle, String newContent){
        View view1 = view.findViewById(R.id.visible_layout);
        view1.setVisibility(View.VISIBLE);
        TextView title = view.findViewById(R.id.news_title);
        TextView content = view.findViewById(R.id.news_content);
        title.setText(newTitle); // 刷新新闻标题
        content.setText(newContent); // 刷新新闻内容
    }
}
