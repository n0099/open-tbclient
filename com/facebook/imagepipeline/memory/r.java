package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class r {
    public final int lUK;
    public final int lUL;
    public final SparseIntArray lUM;
    public final int lUN;
    public final int lUO;
    public boolean lUP;
    public final int lUQ;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.lUL = i;
        this.lUK = i2;
        this.lUM = sparseIntArray;
        this.lUN = i3;
        this.lUO = i4;
        this.lUQ = i5;
    }
}
