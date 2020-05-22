package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class r {
    public final int myh;
    public final int myi;
    public final SparseIntArray myj;
    public final int myk;
    public final int myl;
    public boolean mym;
    public final int myn;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.myi = i;
        this.myh = i2;
        this.myj = sparseIntArray;
        this.myk = i3;
        this.myl = i4;
        this.myn = i5;
    }
}
