package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class r {
    public final int ndC;
    public final int ndD;
    public final SparseIntArray ndE;
    public final int ndF;
    public final int ndG;
    public boolean ndH;
    public final int ndI;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.ndD = i;
        this.ndC = i2;
        this.ndE = sparseIntArray;
        this.ndF = i3;
        this.ndG = i4;
        this.ndI = i5;
    }
}
