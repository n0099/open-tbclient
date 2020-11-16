package com.google.android.flexbox;

import android.view.View;
import java.util.List;
/* loaded from: classes8.dex */
interface a {
    View Qy(int i);

    View Qz(int i);

    void a(View view, int i, int i2, b bVar);

    void a(b bVar);

    int ak(int i, int i2, int i3);

    int al(int i, int i2, int i3);

    int ef(View view);

    boolean esd();

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<b> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    int k(View view, int i, int i2);

    void n(int i, View view);

    void setFlexLines(List<b> list);
}
