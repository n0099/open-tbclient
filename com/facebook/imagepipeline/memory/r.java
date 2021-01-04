package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import androidx.appcompat.widget.ActivityChooserView;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class r {
    public final int pDI;
    public final int pDJ;
    public final SparseIntArray pDK;
    public final int pDL;
    public final int pDM;
    public boolean pDN;
    public final int pDO;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.pDJ = i;
        this.pDI = i2;
        this.pDK = sparseIntArray;
        this.pDL = i3;
        this.pDM = i4;
        this.pDO = i5;
    }
}
