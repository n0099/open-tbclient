package com.tb.airbnb.lottie.model;

import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class b {
    final int DA;
    final double DC;
    public final double DD;
    public final double DE;
    public final boolean DG;
    public final double Dz;
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
        this.Dz = d;
        this.DA = i;
        this.tracking = i2;
        this.DC = d2;
        this.DD = d3;
        this.color = i3;
        this.strokeColor = i4;
        this.DE = d4;
        this.DG = z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.DC);
        return (((((((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.Dz)) * 31) + this.DA) * 31) + this.tracking) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
