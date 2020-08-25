package com.tb.airbnb.lottie.model;

import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes7.dex */
public class b {
    public final double Eh;
    final int Ei;
    final double Ej;
    public final double Ek;
    public final double El;
    public final boolean Em;
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
        this.Eh = d;
        this.Ei = i;
        this.tracking = i2;
        this.Ej = d2;
        this.Ek = d3;
        this.color = i3;
        this.strokeColor = i4;
        this.El = d4;
        this.Em = z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.Ej);
        return (((((((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.Eh)) * 31) + this.Ei) * 31) + this.tracking) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
