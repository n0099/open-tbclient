package com.ksad.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31756a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31757b;

    /* renamed from: c  reason: collision with root package name */
    public final double f31758c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31759d;

    /* renamed from: e  reason: collision with root package name */
    public final int f31760e;

    /* renamed from: f  reason: collision with root package name */
    public final double f31761f;

    /* renamed from: g  reason: collision with root package name */
    public final double f31762g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public final int f31763h;
    @ColorInt
    public final int i;
    public final double j;
    public final boolean k;

    public b(String str, String str2, double d2, int i, int i2, double d3, double d4, @ColorInt int i3, @ColorInt int i4, double d5, boolean z) {
        this.f31756a = str;
        this.f31757b = str2;
        this.f31758c = d2;
        this.f31759d = i;
        this.f31760e = i2;
        this.f31761f = d3;
        this.f31762g = d4;
        this.f31763h = i3;
        this.i = i4;
        this.j = d5;
        this.k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f31756a.hashCode() * 31) + this.f31757b.hashCode()) * 31) + this.f31758c)) * 31) + this.f31759d) * 31) + this.f31760e;
        long doubleToLongBits = Double.doubleToLongBits(this.f31761f);
        return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f31763h;
    }
}
