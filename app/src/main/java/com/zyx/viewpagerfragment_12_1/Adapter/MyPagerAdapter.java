package com.zyx.viewpagerfragment_12_1.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/1 0001.
 * Administrator  ZYX
 */
public class MyPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> listdata;


    public MyPagerAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        listdata=list;
    }

    @Override
    public Fragment getItem(int position) {
        return listdata.get(position);
    }

    @Override
    public int getCount() {
        return listdata.size();
    }


}
