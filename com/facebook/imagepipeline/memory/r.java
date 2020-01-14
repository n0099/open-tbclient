package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class r {
    public final int lUb;
    public final int lUc;
    public final SparseIntArray lUd;
    public final int lUe;
    public final int lUf;
    public boolean lUg;
    public final int lUh;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.lUc = i;
        this.lUb = i2;
        this.lUd = sparseIntArray;
        this.lUe = i3;
        this.lUf = i4;
        this.lUh = i5;
    }
}
