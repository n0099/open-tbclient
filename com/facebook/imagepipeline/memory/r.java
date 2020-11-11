package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class r {
    public final int oXL;
    public final int oXM;
    public final SparseIntArray oXN;
    public final int oXO;
    public final int oXP;
    public boolean oXQ;
    public final int oXR;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.oXM = i;
        this.oXL = i2;
        this.oXN = sparseIntArray;
        this.oXO = i3;
        this.oXP = i4;
        this.oXR = i5;
    }
}
