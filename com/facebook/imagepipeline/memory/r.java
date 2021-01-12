package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import androidx.appcompat.widget.ActivityChooserView;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class r {
    public final int pAO;
    public final int pAP;
    public final SparseIntArray pAQ;
    public final int pAR;
    public final int pAS;
    public boolean pAT;
    public final int pAU;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.pAP = i;
        this.pAO = i2;
        this.pAQ = sparseIntArray;
        this.pAR = i3;
        this.pAS = i4;
        this.pAU = i5;
    }
}
