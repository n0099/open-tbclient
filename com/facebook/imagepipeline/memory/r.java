package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int igu;
    public final int igv;
    public final SparseIntArray igw;
    public final int igx;
    public final int igy;
    public final int igz;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.igv = i;
        this.igu = i2;
        this.igw = sparseIntArray;
        this.igx = i3;
        this.igy = i4;
        this.igz = i5;
    }
}
