package com.ad.wubo.viewpagerlesson;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager vp;
    private ViewPagerAdapter viewPagerAdapter;
    private Button btnEnter;
    private ArrayList<View> views;
    private ImageView[] dots;
    private int[] ids = new int[]{R.id.dot1,R.id.dot2,R.id.dot3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initView();
        //初始化索引点的集合
        initDots();
        vp = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(this,views);
        vp.setAdapter(viewPagerAdapter);
//        vp.setOnPageChangeListener(this);
        vp.addOnPageChangeListener(this);

    }

    private void initDots() {
        dots = new ImageView[views.size()];

        for (int i=0;i<views.size();i++){
            dots[i]= (ImageView) findViewById(ids[i]);
        }
    }

    private void initView() {
        views = new ArrayList<>();  //实例化
        LayoutInflater inflater = LayoutInflater.from(this);  //获取视图解析器的实例

        views.add(inflater.inflate(R.layout.one,null));
        views.add(inflater.inflate(R.layout.two,null));
        views.add(inflater.inflate(R.layout.three,null));

        btnEnter = (Button) views.get(2).findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i=0;i<ids.length;i++){
            if (i==position){
                dots[i].setImageResource(R.drawable.login_point_selected);
            }else {
                dots[i].setImageResource(R.drawable.login_point);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(GuideActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
