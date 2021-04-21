package com.ksad.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class a<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final T f31767a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f31768b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f31769c;

    /* renamed from: d  reason: collision with root package name */
    public final float f31770d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public Float f31771e;

    /* renamed from: f  reason: collision with root package name */
    public PointF f31772f;

    /* renamed from: g  reason: collision with root package name */
    public PointF f31773g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.d f31774h;
    public float i;
    public float j;

    public a(com.ksad.lottie.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f31772f = null;
        this.f31773g = null;
        this.f31774h = dVar;
        this.f31767a = t;
        this.f31768b = t2;
        this.f31769c = interpolator;
        this.f31770d = f2;
        this.f31771e = f3;
    }

    public a(T t) {
        this.i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f31772f = null;
        this.f31773g = null;
        this.f31774h = null;
        this.f31767a = t;
        this.f31768b = t;
        this.f31769c = null;
        this.f31770d = Float.MIN_VALUE;
        this.f31771e = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= b() && f2 < c();
    }

    public float b() {
        com.ksad.lottie.d dVar = this.f31774h;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.i == Float.MIN_VALUE) {
            this.i = (this.f31770d - dVar.d()) / this.f31774h.k();
        }
        return this.i;
    }

    public float c() {
        if (this.f31774h == null) {
            return 1.0f;
        }
        if (this.j == Float.MIN_VALUE) {
            if (this.f31771e == null) {
                this.j = 1.0f;
            } else {
                this.j = b() + ((this.f31771e.floatValue() - this.f31770d) / this.f31774h.k());
            }
        }
        return this.j;
    }

    public boolean d() {
        return this.f31769c == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f31767a + ", endValue=" + this.f31768b + ", startFrame=" + this.f31770d + ", endFrame=" + this.f31771e + ", interpolator=" + this.f31769c + '}';
    }
}
