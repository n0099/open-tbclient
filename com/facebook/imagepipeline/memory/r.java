package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int jJC;
    public final int jJD;
    public final SparseIntArray jJE;
    public final int jJF;
    public final int jJG;
    public final int jJH;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.jJD = i;
        this.jJC = i2;
        this.jJE = sparseIntArray;
        this.jJF = i3;
        this.jJG = i4;
        this.jJH = i5;
    }
}
