package com.fire.reader.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 * FragmentPagerAdapter
 */
public class PagerFragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mFragmentTitles;
    private Context mContext;

    public PagerFragmentAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        mFragmentTitles = new ArrayList<>();
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }

    public PagerFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    public List<Fragment> getmFragments() {
        return mFragments;
    }

    public void addFragment(Fragment fragment, String title) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }
    public void addFragment(Fragment fragment, String title, int type) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    public void addFragment(Fragment fragment, Bundle bundle) {
        fragment.setArguments(bundle);

        mFragments.add(fragment);
        mFragmentTitles.add(bundle.getString("title"));
    }

    public void addFragment(Fragment fragment) {
        mFragments.add(fragment);
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position < mFragmentTitles.size()) {
            return mFragmentTitles.get(position);
        } else {
            return "";
        }
    }

}
