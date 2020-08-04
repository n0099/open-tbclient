package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class r {
    public final int ndE;
    public final int ndF;
    public final SparseIntArray ndG;
    public final int ndH;
    public final int ndI;
    public boolean ndJ;
    public final int ndK;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.ndF = i;
        this.ndE = i2;
        this.ndG = sparseIntArray;
        this.ndH = i3;
        this.ndI = i4;
        this.ndK = i5;
    }
}
