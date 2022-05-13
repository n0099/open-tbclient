package com.tachikoma.core.component.listview.viewpager;

import androidx.annotation.Px;
/* loaded from: classes7.dex */
public interface ITKOnPageChangeCallback {
    void onPageScrollStateChanged(int i);

    void onPageScrolled(int i, float f, @Px int i2);

    void onPageSelected(int i);
}
