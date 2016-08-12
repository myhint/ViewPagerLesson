package com.ad.wubo.viewpagerlesson;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<View> views;
    private Context context;

    public ViewPagerAdapter(Context context,List<View> views) {
        this.views = views;
        this.context = context;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    //初始化视图item
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ((ViewPager)container).addView(views.get(position));
        return views.get(position);
    }

    //在滑动的同时移除之前的item
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);  //这句代码一定要去掉,否则程序会存在闪退现象
        //移除索引值所在的view
        container.removeView(views.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==object);
    }
}
