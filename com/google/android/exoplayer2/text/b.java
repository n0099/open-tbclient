package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
/* loaded from: classes5.dex */
public class b {
    public final Bitmap bitmap;
    public final int mxK;
    public final Layout.Alignment mxN;
    public final float mxO;
    public final int mxP;
    public final int mxQ;
    public final float mxR;
    public final int mxS;
    public final float mxT;
    public final float mxU;
    public final boolean mxV;
    public final CharSequence text;

    public b(Bitmap bitmap, float f, int i, float f2, int i2, float f3, float f4) {
        this(null, null, bitmap, f2, 0, i2, f, i, f3, f4, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public b(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        this(charSequence, alignment, f, i, i2, f2, i3, f3, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4) {
        this(charSequence, alignment, null, f, i, i2, f2, i3, f3, Float.MIN_VALUE, z, i4);
    }

    private b(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f, int i, int i2, float f2, int i3, float f3, float f4, boolean z, int i4) {
        this.text = charSequence;
        this.mxN = alignment;
        this.bitmap = bitmap;
        this.mxO = f;
        this.mxP = i;
        this.mxQ = i2;
        this.mxR = f2;
        this.mxS = i3;
        this.mxT = f3;
        this.mxU = f4;
        this.mxV = z;
        this.mxK = i4;
    }
}
