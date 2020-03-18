package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class r {
    public final int lWB;
    public final int lWC;
    public final SparseIntArray lWD;
    public final int lWE;
    public final int lWF;
    public boolean lWG;
    public final int lWH;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.lWC = i;
        this.lWB = i2;
        this.lWD = sparseIntArray;
        this.lWE = i3;
        this.lWF = i4;
        this.lWH = i5;
    }
}
