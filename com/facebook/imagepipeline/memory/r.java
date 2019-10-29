package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int kkK;
    public final int kkL;
    public final SparseIntArray kkM;
    public final int kkN;
    public final int kkO;
    public final int kkP;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.kkL = i;
        this.kkK = i2;
        this.kkM = sparseIntArray;
        this.kkN = i3;
        this.kkO = i4;
        this.kkP = i5;
    }
}
