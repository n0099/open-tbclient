package com.ksad.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class a<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final T f31913a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f31914b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f31915c;

    /* renamed from: d  reason: collision with root package name */
    public final float f31916d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public Float f31917e;

    /* renamed from: f  reason: collision with root package name */
    public PointF f31918f;

    /* renamed from: g  reason: collision with root package name */
    public PointF f31919g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.d f31920h;

    /* renamed from: i  reason: collision with root package name */
    public float f31921i;
    public float j;

    public a(com.ksad.lottie.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.f31921i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f31918f = null;
        this.f31919g = null;
        this.f31920h = dVar;
        this.f31913a = t;
        this.f31914b = t2;
        this.f31915c = interpolator;
        this.f31916d = f2;
        this.f31917e = f3;
    }

    public a(T t) {
        this.f31921i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f31918f = null;
        this.f31919g = null;
        this.f31920h = null;
        this.f31913a = t;
        this.f31914b = t;
        this.f31915c = null;
        this.f31916d = Float.MIN_VALUE;
        this.f31917e = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= b() && f2 < c();
    }

    public float b() {
        com.ksad.lottie.d dVar = this.f31920h;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.f31921i == Float.MIN_VALUE) {
            this.f31921i = (this.f31916d - dVar.d()) / this.f31920h.k();
        }
        return this.f31921i;
    }

    public float c() {
        if (this.f31920h == null) {
            return 1.0f;
        }
        if (this.j == Float.MIN_VALUE) {
            if (this.f31917e == null) {
                this.j = 1.0f;
            } else {
                this.j = b() + ((this.f31917e.floatValue() - this.f31916d) / this.f31920h.k());
            }
        }
        return this.j;
    }

    public boolean d() {
        return this.f31915c == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f31913a + ", endValue=" + this.f31914b + ", startFrame=" + this.f31916d + ", endFrame=" + this.f31917e + ", interpolator=" + this.f31915c + '}';
    }
}
