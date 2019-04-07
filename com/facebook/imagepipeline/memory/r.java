package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int jIW;
    public final int jIX;
    public final SparseIntArray jIY;
    public final int jIZ;
    public final int jJa;
    public final int jJb;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.jIX = i;
        this.jIW = i2;
        this.jIY = sparseIntArray;
        this.jIZ = i3;
        this.jJa = i4;
        this.jJb = i5;
    }
}
