package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int jJK;
    public final int jJL;
    public final SparseIntArray jJM;
    public final int jJN;
    public final int jJO;
    public final int jJP;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.jJL = i;
        this.jJK = i2;
        this.jJM = sparseIntArray;
        this.jJN = i3;
        this.jJO = i4;
        this.jJP = i5;
    }
}
