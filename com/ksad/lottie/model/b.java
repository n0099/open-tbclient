package com.ksad.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31466a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31467b;

    /* renamed from: c  reason: collision with root package name */
    public final double f31468c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31469d;

    /* renamed from: e  reason: collision with root package name */
    public final int f31470e;

    /* renamed from: f  reason: collision with root package name */
    public final double f31471f;

    /* renamed from: g  reason: collision with root package name */
    public final double f31472g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public final int f31473h;
    @ColorInt
    public final int i;
    public final double j;
    public final boolean k;

    public b(String str, String str2, double d2, int i, int i2, double d3, double d4, @ColorInt int i3, @ColorInt int i4, double d5, boolean z) {
        this.f31466a = str;
        this.f31467b = str2;
        this.f31468c = d2;
        this.f31469d = i;
        this.f31470e = i2;
        this.f31471f = d3;
        this.f31472g = d4;
        this.f31473h = i3;
        this.i = i4;
        this.j = d5;
        this.k = z;
    }

    public int hashCode() {
        double hashCode = ((this.f31466a.hashCode() * 31) + this.f31467b.hashCode()) * 31;
        double d2 = this.f31468c;
        Double.isNaN(hashCode);
        int i = (((((int) (hashCode + d2)) * 31) + this.f31469d) * 31) + this.f31470e;
        long doubleToLongBits = Double.doubleToLongBits(this.f31471f);
        return (((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f31473h;
    }
}
