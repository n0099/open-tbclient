package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int kiV;
    public final int kiW;
    public final SparseIntArray kiX;
    public final int kiY;
    public final int kiZ;
    public final int kja;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.kiW = i;
        this.kiV = i2;
        this.kiX = sparseIntArray;
        this.kiY = i3;
        this.kiZ = i4;
        this.kja = i5;
    }
}
