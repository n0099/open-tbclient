package com.ksad.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31999a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32000b;

    /* renamed from: c  reason: collision with root package name */
    public final double f32001c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32002d;

    /* renamed from: e  reason: collision with root package name */
    public final int f32003e;

    /* renamed from: f  reason: collision with root package name */
    public final double f32004f;

    /* renamed from: g  reason: collision with root package name */
    public final double f32005g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public final int f32006h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    public final int f32007i;
    public final double j;
    public final boolean k;

    public b(String str, String str2, double d2, int i2, int i3, double d3, double d4, @ColorInt int i4, @ColorInt int i5, double d5, boolean z) {
        this.f31999a = str;
        this.f32000b = str2;
        this.f32001c = d2;
        this.f32002d = i2;
        this.f32003e = i3;
        this.f32004f = d3;
        this.f32005g = d4;
        this.f32006h = i4;
        this.f32007i = i5;
        this.j = d5;
        this.k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f31999a.hashCode() * 31) + this.f32000b.hashCode()) * 31) + this.f32001c)) * 31) + this.f32002d) * 31) + this.f32003e;
        long doubleToLongBits = Double.doubleToLongBits(this.f32004f);
        return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f32006h;
    }
}
