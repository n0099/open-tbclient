package com.ksad.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class a<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final T f31382a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f31383b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f31384c;

    /* renamed from: d  reason: collision with root package name */
    public final float f31385d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public Float f31386e;

    /* renamed from: f  reason: collision with root package name */
    public PointF f31387f;

    /* renamed from: g  reason: collision with root package name */
    public PointF f31388g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.d f31389h;
    public float i;
    public float j;

    public a(com.ksad.lottie.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f31387f = null;
        this.f31388g = null;
        this.f31389h = dVar;
        this.f31382a = t;
        this.f31383b = t2;
        this.f31384c = interpolator;
        this.f31385d = f2;
        this.f31386e = f3;
    }

    public a(T t) {
        this.i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f31387f = null;
        this.f31388g = null;
        this.f31389h = null;
        this.f31382a = t;
        this.f31383b = t;
        this.f31384c = null;
        this.f31385d = Float.MIN_VALUE;
        this.f31386e = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= b() && f2 < c();
    }

    public float b() {
        com.ksad.lottie.d dVar = this.f31389h;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.i == Float.MIN_VALUE) {
            this.i = (this.f31385d - dVar.d()) / this.f31389h.k();
        }
        return this.i;
    }

    public float c() {
        if (this.f31389h == null) {
            return 1.0f;
        }
        if (this.j == Float.MIN_VALUE) {
            if (this.f31386e == null) {
                this.j = 1.0f;
            } else {
                this.j = b() + ((this.f31386e.floatValue() - this.f31385d) / this.f31389h.k());
            }
        }
        return this.j;
    }

    public boolean d() {
        return this.f31384c == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f31382a + ", endValue=" + this.f31383b + ", startFrame=" + this.f31385d + ", endFrame=" + this.f31386e + ", interpolator=" + this.f31384c + '}';
    }
}
