package com.tb.airbnb.lottie.model;

import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class b {
    final double DA;
    public final double DC;
    @ColorInt
    public final int DD;
    public final double DE;
    public final boolean DG;
    public final double Dx;
    final int Dy;
    public final int Dz;
    @ColorInt
    public final int color;
    public final String fontName;
    public final String text;

    public b(String str, String str2, double d, int i, int i2, double d2, double d3, @ColorInt int i3, @ColorInt int i4, double d4, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.Dx = d;
        this.Dy = i;
        this.Dz = i2;
        this.DA = d2;
        this.DC = d3;
        this.color = i3;
        this.DD = i4;
        this.DE = d4;
        this.DG = z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.DA);
        return (((((((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.Dx)) * 31) + this.Dy) * 31) + this.Dz) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
