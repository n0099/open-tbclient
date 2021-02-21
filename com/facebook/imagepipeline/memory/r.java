package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class r {
    public final int pLA;
    public final int pLB;
    public boolean pLC;
    public final int pLD;
    public final int pLx;
    public final int pLy;
    public final SparseIntArray pLz;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.pLy = i;
        this.pLx = i2;
        this.pLz = sparseIntArray;
        this.pLA = i3;
        this.pLB = i4;
        this.pLD = i5;
    }
}
