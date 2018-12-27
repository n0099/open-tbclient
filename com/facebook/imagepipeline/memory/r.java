package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int isB;
    public final int isC;
    public final SparseIntArray isD;
    public final int isE;
    public final int isF;
    public final int isG;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.isC = i;
        this.isB = i2;
        this.isD = sparseIntArray;
        this.isE = i3;
        this.isF = i4;
        this.isG = i5;
    }
}
