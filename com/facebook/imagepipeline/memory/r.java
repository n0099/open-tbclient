package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import androidx.appcompat.widget.ActivityChooserView;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class r {
    public final int pAP;
    public final int pAQ;
    public final SparseIntArray pAR;
    public final int pAS;
    public final int pAT;
    public boolean pAU;
    public final int pAV;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.pAQ = i;
        this.pAP = i2;
        this.pAR = sparseIntArray;
        this.pAS = i3;
        this.pAT = i4;
        this.pAV = i5;
    }
}
