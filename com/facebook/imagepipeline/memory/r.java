package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class r {
    public final int lUI;
    public final int lUJ;
    public final SparseIntArray lUK;
    public final int lUL;
    public final int lUM;
    public boolean lUN;
    public final int lUO;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.lUJ = i;
        this.lUI = i2;
        this.lUK = sparseIntArray;
        this.lUL = i3;
        this.lUM = i4;
        this.lUO = i5;
    }
}
