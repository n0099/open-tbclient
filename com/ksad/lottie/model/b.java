package com.ksad.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31467a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31468b;

    /* renamed from: c  reason: collision with root package name */
    public final double f31469c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31470d;

    /* renamed from: e  reason: collision with root package name */
    public final int f31471e;

    /* renamed from: f  reason: collision with root package name */
    public final double f31472f;

    /* renamed from: g  reason: collision with root package name */
    public final double f31473g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public final int f31474h;
    @ColorInt
    public final int i;
    public final double j;
    public final boolean k;

    public b(String str, String str2, double d2, int i, int i2, double d3, double d4, @ColorInt int i3, @ColorInt int i4, double d5, boolean z) {
        this.f31467a = str;
        this.f31468b = str2;
        this.f31469c = d2;
        this.f31470d = i;
        this.f31471e = i2;
        this.f31472f = d3;
        this.f31473g = d4;
        this.f31474h = i3;
        this.i = i4;
        this.j = d5;
        this.k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f31467a.hashCode() * 31) + this.f31468b.hashCode()) * 31) + this.f31469c)) * 31) + this.f31470d) * 31) + this.f31471e;
        long doubleToLongBits = Double.doubleToLongBits(this.f31472f);
        return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f31474h;
    }
}
