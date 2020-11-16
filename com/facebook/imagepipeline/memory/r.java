package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class r {
    public final int oZo;
    public final int oZp;
    public final SparseIntArray oZq;
    public final int oZr;
    public final int oZs;
    public boolean oZt;
    public final int oZu;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.oZp = i;
        this.oZo = i2;
        this.oZq = sparseIntArray;
        this.oZr = i3;
        this.oZs = i4;
        this.oZu = i5;
    }
}
