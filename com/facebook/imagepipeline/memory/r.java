package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class r {
    public final int oOs;
    public final int oOt;
    public final SparseIntArray oOu;
    public final int oOv;
    public final int oOw;
    public boolean oOx;
    public final int oOy;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.oOt = i;
        this.oOs = i2;
        this.oOu = sparseIntArray;
        this.oOv = i3;
        this.oOw = i4;
        this.oOy = i5;
    }
}
