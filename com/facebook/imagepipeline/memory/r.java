package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final SparseIntArray kmA;
    public final int kmB;
    public final int kmC;
    public final int kmD;
    public final int kmy;
    public final int kmz;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.kmz = i;
        this.kmy = i2;
        this.kmA = sparseIntArray;
        this.kmB = i3;
        this.kmC = i4;
        this.kmD = i5;
    }
}
