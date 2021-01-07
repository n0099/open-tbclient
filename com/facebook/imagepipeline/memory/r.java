package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import androidx.appcompat.widget.ActivityChooserView;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class r {
    public final int pFp;
    public final int pFq;
    public final SparseIntArray pFr;
    public final int pFs;
    public final int pFt;
    public boolean pFu;
    public final int pFv;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.pFq = i;
        this.pFp = i2;
        this.pFr = sparseIntArray;
        this.pFs = i3;
        this.pFt = i4;
        this.pFv = i5;
    }
}
