package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class r {
    public final int lUV;
    public final int lUW;
    public final SparseIntArray lUX;
    public final int lUY;
    public final int lUZ;
    public boolean lVa;
    public final int lVb;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.lUW = i;
        this.lUV = i2;
        this.lUX = sparseIntArray;
        this.lUY = i3;
        this.lUZ = i4;
        this.lVb = i5;
    }
}
