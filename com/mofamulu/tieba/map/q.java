package com.mofamulu.tieba.map;

import android.support.v4.view.ViewPager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ FreeNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FreeNearbyActivity freeNearbyActivity) {
        this.a = freeNearbyActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        boolean z2;
        ViewPager viewPager;
        ViewPager viewPager2;
        RadioButton radioButton;
        ViewPager viewPager3;
        ViewPager viewPager4;
        ViewPager viewPager5;
        ViewPager viewPager6;
        if (z) {
            com.baidu.tieba.util.z.c("onCheckedChanged id = " + String.valueOf(compoundButton.getId()));
            z2 = this.a.A;
            if (!z2) {
                viewPager = this.a.m;
                if (viewPager != null) {
                    viewPager2 = this.a.m;
                    if (viewPager2.getChildCount() >= 2) {
                        this.a.z = true;
                        radioButton = this.a.t;
                        if (compoundButton == radioButton) {
                            viewPager5 = this.a.m;
                            if (viewPager5.getCurrentItem() != 0) {
                                viewPager6 = this.a.m;
                                viewPager6.a(0, true);
                            }
                        } else {
                            viewPager3 = this.a.m;
                            if (viewPager3.getCurrentItem() != 1) {
                                viewPager4 = this.a.m;
                                viewPager4.a(1, true);
                            }
                        }
                        this.a.z = false;
                    }
                }
            }
        }
    }
}
