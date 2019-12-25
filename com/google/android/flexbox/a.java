package com.google.android.flexbox;

import android.view.View;
import java.util.List;
/* loaded from: classes4.dex */
interface a {
    View LQ(int i);

    View LR(int i);

    void a(View view, int i, int i2, b bVar);

    void a(b bVar);

    int am(int i, int i2, int i3);

    int an(int i, int i2, int i3);

    int dg(View view);

    boolean dxN();

    int g(View view, int i, int i2);

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

    void m(int i, View view);

    void setFlexLines(List<b> list);
}
