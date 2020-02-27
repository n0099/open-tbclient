package com.tb.airbnb.lottie.model;

import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class b {
    @ColorInt
    public final int color;
    public final String fontName;
    public final double hs;
    final int ht;
    public final int hu;
    final double hv;
    public final double hw;
    @ColorInt
    public final int hx;
    public final double hy;
    public final boolean hz;
    public final String text;

    public b(String str, String str2, double d, int i, int i2, double d2, double d3, @ColorInt int i3, @ColorInt int i4, double d4, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.hs = d;
        this.ht = i;
        this.hu = i2;
        this.hv = d2;
        this.hw = d3;
        this.color = i3;
        this.hx = i4;
        this.hy = d4;
        this.hz = z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.hv);
        return (((((((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.hs)) * 31) + this.ht) * 31) + this.hu) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
