package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class r {
    public final int mzr;
    public final int mzs;
    public final SparseIntArray mzt;
    public final int mzu;
    public final int mzv;
    public boolean mzw;
    public final int mzx;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.mzs = i;
        this.mzr = i2;
        this.mzt = sparseIntArray;
        this.mzu = i3;
        this.mzv = i4;
        this.mzx = i5;
    }
}
