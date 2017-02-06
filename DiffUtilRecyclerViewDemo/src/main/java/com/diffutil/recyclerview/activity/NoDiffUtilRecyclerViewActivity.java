package com.diffutil.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.diffutil.recyclerview.R;
import com.diffutil.recyclerview.adapter.DiffAdapter;
import com.diffutil.recyclerview.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobo on 2017/2/6.
 */

public class NoDiffUtilRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<TestBean> mDatas;
    private DiffAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_layout);
        initData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new DiffAdapter(this, mDatas);
        recyclerView.setAdapter(mAdapter);
        mAdapter.register(true);
    }

    private void initData() {
        mDatas = new ArrayList<>();
        mDatas.add(new TestBean("张旭童1", "Android", R.drawable.pic1));
        mDatas.add(new TestBean("张旭童2", "Java", R.drawable.pic2));
        mDatas.add(new TestBean("张旭童3", "背锅", R.drawable.pic3));
        mDatas.add(new TestBean("张旭童4", "手撕产品", R.drawable.pic4));
        mDatas.add(new TestBean("张旭童5", "手撕测试", R.drawable.pic5));
    }

    /**
     * 模拟刷新操作
     *
     * @param view
     */
    public void onRefresh(View view) {
        try {
            List<TestBean> newDatas = new ArrayList<>();
            for (TestBean bean : mDatas) {
                newDatas.add(bean.clone());//clone一遍旧数据 ，模拟刷新操作
            }
            newDatas.add(new TestBean("赵子龙", "帅", R.drawable.pic6));//模拟新增数据
            newDatas.get(0).setDesc("Android+");
            newDatas.get(0).setPic(R.drawable.pic7);//模拟修改数据
            TestBean testBean = newDatas.get(1);//模拟数据位移
            newDatas.remove(testBean);
            newDatas.add(testBean);
            //别忘了将新数据给Adapter
            mDatas = newDatas;
            mAdapter.setDatas(mDatas);
            mAdapter.notifyDataSetChanged();//以前我们大多数情况下只能这样
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.register(false);
    }
}
