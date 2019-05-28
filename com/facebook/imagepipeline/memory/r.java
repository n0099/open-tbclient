package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int kbL;
    public final int kbM;
    public final SparseIntArray kbN;
    public final int kbO;
    public final int kbP;
    public final int kbQ;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.kbM = i;
        this.kbL = i2;
        this.kbN = sparseIntArray;
        this.kbO = i3;
        this.kbP = i4;
        this.kbQ = i5;
    }
}
