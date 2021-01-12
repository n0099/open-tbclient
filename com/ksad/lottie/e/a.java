package com.ksad.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class a<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final T f8001a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f8002b;
    @Nullable
    public final Interpolator c;
    public final float d;
    @Nullable
    public Float e;
    public PointF f;
    public PointF g;
    @Nullable
    private final com.ksad.lottie.d h;
    private float i;
    private float j;

    public a(com.ksad.lottie.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f = null;
        this.g = null;
        this.h = dVar;
        this.f8001a = t;
        this.f8002b = t2;
        this.c = interpolator;
        this.d = f;
        this.e = f2;
    }

    public a(T t) {
        this.i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f = null;
        this.g = null;
        this.h = null;
        this.f8001a = t;
        this.f8002b = t;
        this.c = null;
        this.d = Float.MIN_VALUE;
        this.e = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= b() && f < c();
    }

    public float b() {
        if (this.h == null) {
            return 0.0f;
        }
        if (this.i == Float.MIN_VALUE) {
            this.i = (this.d - this.h.d()) / this.h.k();
        }
        return this.i;
    }

    public float c() {
        if (this.h == null) {
            return 1.0f;
        }
        if (this.j == Float.MIN_VALUE) {
            if (this.e == null) {
                this.j = 1.0f;
            } else {
                this.j = b() + ((this.e.floatValue() - this.d) / this.h.k());
            }
        }
        return this.j;
    }

    public boolean d() {
        return this.c == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f8001a + ", endValue=" + this.f8002b + ", startFrame=" + this.d + ", endFrame=" + this.e + ", interpolator=" + this.c + '}';
    }
}
