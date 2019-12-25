package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class r {
    public final int lQk;
    public final int lQl;
    public final SparseIntArray lQm;
    public final int lQn;
    public final int lQo;
    public boolean lQp;
    public final int lQq;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.lQl = i;
        this.lQk = i2;
        this.lQm = sparseIntArray;
        this.lQn = i3;
        this.lQo = i4;
        this.lQq = i5;
    }
}
