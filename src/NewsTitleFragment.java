package com.example.activitytest.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.activitytest.Activity.NewsContentActiviry;
import com.example.activitytest.CustomType.News;
import com.example.activitytest.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsTitleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        // 滚动控件实例
        RecyclerView newsTitleRecyclerView = view.findViewById(R.id.news_title_recycler_view);
        // 布局方式
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        // 设置RecyclerView布局方式为线性布局
        newsTitleRecyclerView.setLayoutManager(layoutManager);
        // 为布局添加适配器
        newsTitleRecyclerView.setAdapter(new NewsAdapter(getNews()));
        return view;
    }

    // 创建一个List<News>并返回
    private List<News> getNews(){
        List<News> newsList = new ArrayList<>();
        for(int i=1; i<=50; i++){
            News news = new News();
            news.setTitle("News Title" + i);
            news.setContent(getRandomLengthContent("News Content"+i+"."));
            newsList.add(news);
        }
        return newsList;
    }

    private String getRandomLengthContent(String content){
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<length; i++){
            builder.append(content);
        }
        return  builder.toString();
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
        private List<News> NewsList;

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView newsTitleText;

            public ViewHolder(View itemView) {
                super(itemView);
                newsTitleText = itemView.findViewById(R.id.news_title);
            }
        }

        public NewsAdapter(List<News> newsList){
            NewsList = newsList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.news_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            // 点击RecyclerView中的新闻标题时，启动NewsContentActiviry
            view.setOnClickListener((View v)->{
                // 获取点击项的News实例
                News news = NewsList.get(holder.getAdapterPosition());
                /* 单页模式 */
                // 启动新的活动显示新闻内容
                NewsContentActiviry.actionStart(getActivity(), news.getTitle(), news.getContent());
                /* 双页模式 */
                /*NewsContentFragment newsContentFragment = (NewsContentFragment) getParentFragmentManager()
                        .findFragmentById(R.id.news_content_fragment);
                newsContentFragment.refresh(news.getTitle(), news.getContent());*/
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = NewsList.get(position);
            holder.newsTitleText.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return NewsList.size();
        }
    }
}