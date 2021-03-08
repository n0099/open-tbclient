package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class r {
    public final int pNC;
    public final int pND;
    public final SparseIntArray pNE;
    public final int pNF;
    public final int pNG;
    public boolean pNH;
    public final int pNI;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.pND = i;
        this.pNC = i2;
        this.pNE = sparseIntArray;
        this.pNF = i3;
        this.pNG = i4;
        this.pNI = i5;
    }
}
