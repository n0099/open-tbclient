package com.tachikoma.core.component.listview.viewpager;

import androidx.annotation.Px;
/* loaded from: classes4.dex */
public interface ITKOnPageChangeCallback {
    void onPageScrollStateChanged(int i2);

    void onPageScrolled(int i2, float f2, @Px int i3);

    void onPageSelected(int i2);
}
