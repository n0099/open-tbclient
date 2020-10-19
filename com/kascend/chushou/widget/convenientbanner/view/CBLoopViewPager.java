package com.kascend.chushou.widget.convenientbanner.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
/* loaded from: classes6.dex */
public class CBLoopViewPager extends RecyclerView {
    private static boolean ozW = true;

    public CBLoopViewPager(Context context) {
        super(context);
    }

    public CBLoopViewPager(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CBLoopViewPager(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean fling(int i, int i2) {
        if (ozW) {
            i = tJ(i);
            i2 = tJ(i2);
        }
        return super.fling(i, i2);
    }

    private int tJ(int i) {
        return i > 0 ? Math.min(i, 3000) : Math.max(i, -3000);
    }
}
