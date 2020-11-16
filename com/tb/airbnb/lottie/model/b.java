package com.tb.airbnb.lottie.model;

import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes17.dex */
public class b {
    final double EA;
    public final double EB;
    public final double ED;
    public final boolean EE;
    public final double Ey;
    final int Ez;
    @ColorInt
    public final int color;
    public final String fontName;
    @ColorInt
    public final int strokeColor;
    public final String text;
    public final int tracking;

    public b(String str, String str2, double d, int i, int i2, double d2, double d3, @ColorInt int i3, @ColorInt int i4, double d4, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.Ey = d;
        this.Ez = i;
        this.tracking = i2;
        this.EA = d2;
        this.EB = d3;
        this.color = i3;
        this.strokeColor = i4;
        this.ED = d4;
        this.EE = z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.EA);
        return (((((((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.Ey)) * 31) + this.Ez) * 31) + this.tracking) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
