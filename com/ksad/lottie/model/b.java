package com.ksad.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f32097a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32098b;

    /* renamed from: c  reason: collision with root package name */
    public final double f32099c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32100d;

    /* renamed from: e  reason: collision with root package name */
    public final int f32101e;

    /* renamed from: f  reason: collision with root package name */
    public final double f32102f;

    /* renamed from: g  reason: collision with root package name */
    public final double f32103g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public final int f32104h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    public final int f32105i;
    public final double j;
    public final boolean k;

    public b(String str, String str2, double d2, int i2, int i3, double d3, double d4, @ColorInt int i4, @ColorInt int i5, double d5, boolean z) {
        this.f32097a = str;
        this.f32098b = str2;
        this.f32099c = d2;
        this.f32100d = i2;
        this.f32101e = i3;
        this.f32102f = d3;
        this.f32103g = d4;
        this.f32104h = i4;
        this.f32105i = i5;
        this.j = d5;
        this.k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f32097a.hashCode() * 31) + this.f32098b.hashCode()) * 31) + this.f32099c)) * 31) + this.f32100d) * 31) + this.f32101e;
        long doubleToLongBits = Double.doubleToLongBits(this.f32102f);
        return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f32104h;
    }
}
