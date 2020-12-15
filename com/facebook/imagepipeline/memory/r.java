package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class r {
    public final int pof;
    public final int pog;
    public final SparseIntArray poh;
    public final int poj;
    public final int pok;
    public boolean pol;
    public final int pom;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.pog = i;
        this.pof = i2;
        this.poh = sparseIntArray;
        this.poj = i3;
        this.pok = i4;
        this.pom = i5;
    }
}
