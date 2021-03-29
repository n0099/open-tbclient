package com.ksad.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class a<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final T f31383a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f31384b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f31385c;

    /* renamed from: d  reason: collision with root package name */
    public final float f31386d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public Float f31387e;

    /* renamed from: f  reason: collision with root package name */
    public PointF f31388f;

    /* renamed from: g  reason: collision with root package name */
    public PointF f31389g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.d f31390h;
    public float i;
    public float j;

    public a(com.ksad.lottie.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f31388f = null;
        this.f31389g = null;
        this.f31390h = dVar;
        this.f31383a = t;
        this.f31384b = t2;
        this.f31385c = interpolator;
        this.f31386d = f2;
        this.f31387e = f3;
    }

    public a(T t) {
        this.i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f31388f = null;
        this.f31389g = null;
        this.f31390h = null;
        this.f31383a = t;
        this.f31384b = t;
        this.f31385c = null;
        this.f31386d = Float.MIN_VALUE;
        this.f31387e = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= b() && f2 < c();
    }

    public float b() {
        com.ksad.lottie.d dVar = this.f31390h;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.i == Float.MIN_VALUE) {
            this.i = (this.f31386d - dVar.d()) / this.f31390h.k();
        }
        return this.i;
    }

    public float c() {
        if (this.f31390h == null) {
            return 1.0f;
        }
        if (this.j == Float.MIN_VALUE) {
            if (this.f31387e == null) {
                this.j = 1.0f;
            } else {
                this.j = b() + ((this.f31387e.floatValue() - this.f31386d) / this.f31390h.k());
            }
        }
        return this.j;
    }

    public boolean d() {
        return this.f31385c == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f31383a + ", endValue=" + this.f31384b + ", startFrame=" + this.f31386d + ", endFrame=" + this.f31387e + ", interpolator=" + this.f31385c + '}';
    }
}
