package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int jIX;
    public final int jIY;
    public final SparseIntArray jIZ;
    public final int jJa;
    public final int jJb;
    public final int jJc;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.jIY = i;
        this.jIX = i2;
        this.jIZ = sparseIntArray;
        this.jJa = i3;
        this.jJb = i4;
        this.jJc = i5;
    }
}
