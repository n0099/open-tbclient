package com.ksad.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31851a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31852b;

    /* renamed from: c  reason: collision with root package name */
    public final double f31853c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31854d;

    /* renamed from: e  reason: collision with root package name */
    public final int f31855e;

    /* renamed from: f  reason: collision with root package name */
    public final double f31856f;

    /* renamed from: g  reason: collision with root package name */
    public final double f31857g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public final int f31858h;
    @ColorInt
    public final int i;
    public final double j;
    public final boolean k;

    public b(String str, String str2, double d2, int i, int i2, double d3, double d4, @ColorInt int i3, @ColorInt int i4, double d5, boolean z) {
        this.f31851a = str;
        this.f31852b = str2;
        this.f31853c = d2;
        this.f31854d = i;
        this.f31855e = i2;
        this.f31856f = d3;
        this.f31857g = d4;
        this.f31858h = i3;
        this.i = i4;
        this.j = d5;
        this.k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f31851a.hashCode() * 31) + this.f31852b.hashCode()) * 31) + this.f31853c)) * 31) + this.f31854d) * 31) + this.f31855e;
        long doubleToLongBits = Double.doubleToLongBits(this.f31856f);
        return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f31858h;
    }
}
