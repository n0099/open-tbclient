package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class r {
    public final int nxA;
    public final int nxu;
    public final int nxv;
    public final SparseIntArray nxw;
    public final int nxx;
    public final int nxy;
    public boolean nxz;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.nxv = i;
        this.nxu = i2;
        this.nxw = sparseIntArray;
        this.nxx = i3;
        this.nxy = i4;
        this.nxA = i5;
    }
}
