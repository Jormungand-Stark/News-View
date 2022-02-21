package com.example.activitytest.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.activitytest.Fragment.NewsContentFragment;
import com.example.activitytest.R;

// 新闻内容活动
public class NewsContentActiviry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.news_content));
        String newsTitle = getIntent().getStringExtra("news_title");
        String newsContent = getIntent().getStringExtra("news_content");
        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager()
                .findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTitle, newsContent); // 刷新NewsContentFragment界面
    }

    public static void actionStart(Context context, String newsTitle, String newsContent){
        Intent intent = new Intent(context, NewsContentActiviry.class);
        intent.putExtra("news_title", newsTitle);
        intent.putExtra("news_content", newsContent);
        context.startActivity(intent);
    }
}
