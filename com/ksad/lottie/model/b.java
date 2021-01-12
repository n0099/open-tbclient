package com.ksad.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f8049a;

    /* renamed from: b  reason: collision with root package name */
    public final String f8050b;
    public final double c;
    final int d;
    public final int e;
    final double f;
    public final double g;
    @ColorInt
    public final int h;
    @ColorInt
    public final int i;
    public final double j;
    public final boolean k;

    public b(String str, String str2, double d, int i, int i2, double d2, double d3, @ColorInt int i3, @ColorInt int i4, double d4, boolean z) {
        this.f8049a = str;
        this.f8050b = str2;
        this.c = d;
        this.d = i;
        this.e = i2;
        this.f = d2;
        this.g = d3;
        this.h = i3;
        this.i = i4;
        this.j = d4;
        this.k = z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f);
        return (((((((((int) ((((this.f8049a.hashCode() * 31) + this.f8050b.hashCode()) * 31) + this.c)) * 31) + this.d) * 31) + this.e) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.h;
    }
}
