package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Johnny on 12/8/2017.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
//            DayFragment mon = new DayFragment();
//            mon.setDay("Monday");
            return new NumbersFragment();
        }
        else if (position == 1) {
//            DayFragment tue = new DayFragment();
//            tue.setDay("Tuesday");
//            return tue;
            return new FamilyFragment();
        } else if (position == 2) {
//            DayFragment wed = new DayFragment();
//            wed.setDay("Wednesday");
//            return wed;
            return new ColorsFragment();
        }
        else {
//            DayFragment fri = new DayFragment();
//            fri.setDay("Friday");
//            return fri;
            return new PhraseFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
