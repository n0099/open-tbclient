package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int jJr;
    public final int jJs;
    public final SparseIntArray jJt;
    public final int jJu;
    public final int jJv;
    public final int jJw;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.jJs = i;
        this.jJr = i2;
        this.jJt = sparseIntArray;
        this.jJu = i3;
        this.jJv = i4;
        this.jJw = i5;
    }
}
