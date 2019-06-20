package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int kbO;
    public final int kbP;
    public final SparseIntArray kbQ;
    public final int kbR;
    public final int kbS;
    public final int kbT;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.kbP = i;
        this.kbO = i2;
        this.kbQ = sparseIntArray;
        this.kbR = i3;
        this.kbS = i4;
        this.kbT = i5;
    }
}
