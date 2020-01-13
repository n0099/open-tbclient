package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class r {
    public final int lTW;
    public final int lTX;
    public final SparseIntArray lTY;
    public final int lTZ;
    public final int lUa;
    public boolean lUb;
    public final int lUc;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.lTX = i;
        this.lTW = i2;
        this.lTY = sparseIntArray;
        this.lTZ = i3;
        this.lUa = i4;
        this.lUc = i5;
    }
}
