package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int kjT;
    public final int kjU;
    public final SparseIntArray kjV;
    public final int kjW;
    public final int kjX;
    public final int kjY;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.kjU = i;
        this.kjT = i2;
        this.kjV = sparseIntArray;
        this.kjW = i3;
        this.kjX = i4;
        this.kjY = i5;
    }
}
