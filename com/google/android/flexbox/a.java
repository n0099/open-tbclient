package com.google.android.flexbox;

import android.view.View;
import java.util.List;
/* loaded from: classes5.dex */
interface a {
    View Iq(int i);

    View Ir(int i);

    void a(View view, int i, int i2, b bVar);

    void a(b bVar);

    int ag(int i, int i2, int i3);

    int ah(int i, int i2, int i3);

    boolean dCq();

    int dk(View view);

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

    int j(View view, int i, int i2);

    void l(int i, View view);

    void setFlexLines(List<b> list);
}
