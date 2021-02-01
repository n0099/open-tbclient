package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class r {
    public final int pKX;
    public final int pKY;
    public final SparseIntArray pKZ;
    public final int pLa;
    public final int pLb;
    public boolean pLc;
    public final int pLd;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.pKY = i;
        this.pKX = i2;
        this.pKZ = sparseIntArray;
        this.pLa = i3;
        this.pLb = i4;
        this.pLd = i5;
    }
}
