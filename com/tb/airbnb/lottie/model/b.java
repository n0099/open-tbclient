package com.tb.airbnb.lottie.model;

import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class b {
    @ColorInt
    public final int color;
    public final String fontName;
    public final double hr;
    final int hs;
    public final int ht;
    final double hu;
    public final double hv;
    @ColorInt
    public final int hw;
    public final double hx;
    public final boolean hy;
    public final String text;

    public b(String str, String str2, double d, int i, int i2, double d2, double d3, @ColorInt int i3, @ColorInt int i4, double d4, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.hr = d;
        this.hs = i;
        this.ht = i2;
        this.hu = d2;
        this.hv = d3;
        this.color = i3;
        this.hw = i4;
        this.hx = d4;
        this.hy = z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.hu);
        return (((((((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.hr)) * 31) + this.hs) * 31) + this.ht) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
