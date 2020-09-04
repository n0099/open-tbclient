package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class r {
    public final int nxM;
    public final int nxN;
    public final SparseIntArray nxO;
    public final int nxP;
    public final int nxQ;
    public boolean nxR;
    public final int nxS;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.nxN = i;
        this.nxM = i2;
        this.nxO = sparseIntArray;
        this.nxP = i3;
        this.nxQ = i4;
        this.nxS = i5;
    }
}
