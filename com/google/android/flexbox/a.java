package com.google.android.flexbox;

import android.view.View;
import java.util.List;
/* loaded from: classes9.dex */
interface a {
    View PA(int i);

    View PB(int i);

    void a(View view, int i, int i2, b bVar);

    void a(b bVar);

    int ah(int i, int i2, int i3);

    int ai(int i, int i2, int i3);

    int dQ(View view);

    boolean eoq();

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

    void n(int i, View view);

    void setFlexLines(List<b> list);
}
