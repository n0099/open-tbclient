package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int iif;
    public final int iig;
    public final SparseIntArray iih;
    public final int iii;
    public final int iij;
    public final int iik;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.iig = i;
        this.iif = i2;
        this.iih = sparseIntArray;
        this.iii = i3;
        this.iij = i4;
        this.iik = i5;
    }
}
