package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
/* loaded from: classes6.dex */
public class b {
    public final Bitmap bitmap;
    public final int myA;
    public final int myB;
    public final float myC;
    public final int myD;
    public final float myE;
    public final float myF;
    public final boolean myG;
    public final int myv;
    public final Layout.Alignment myy;
    public final float myz;
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
        this.myy = alignment;
        this.bitmap = bitmap;
        this.myz = f;
        this.myA = i;
        this.myB = i2;
        this.myC = f2;
        this.myD = i3;
        this.myE = f3;
        this.myF = f4;
        this.myG = z;
        this.myv = i4;
    }
}
