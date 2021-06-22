package com.ksad.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class a<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final T f32011a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f32012b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f32013c;

    /* renamed from: d  reason: collision with root package name */
    public final float f32014d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public Float f32015e;

    /* renamed from: f  reason: collision with root package name */
    public PointF f32016f;

    /* renamed from: g  reason: collision with root package name */
    public PointF f32017g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.d f32018h;

    /* renamed from: i  reason: collision with root package name */
    public float f32019i;
    public float j;

    public a(com.ksad.lottie.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.f32019i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f32016f = null;
        this.f32017g = null;
        this.f32018h = dVar;
        this.f32011a = t;
        this.f32012b = t2;
        this.f32013c = interpolator;
        this.f32014d = f2;
        this.f32015e = f3;
    }

    public a(T t) {
        this.f32019i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f32016f = null;
        this.f32017g = null;
        this.f32018h = null;
        this.f32011a = t;
        this.f32012b = t;
        this.f32013c = null;
        this.f32014d = Float.MIN_VALUE;
        this.f32015e = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= b() && f2 < c();
    }

    public float b() {
        com.ksad.lottie.d dVar = this.f32018h;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.f32019i == Float.MIN_VALUE) {
            this.f32019i = (this.f32014d - dVar.d()) / this.f32018h.k();
        }
        return this.f32019i;
    }

    public float c() {
        if (this.f32018h == null) {
            return 1.0f;
        }
        if (this.j == Float.MIN_VALUE) {
            if (this.f32015e == null) {
                this.j = 1.0f;
            } else {
                this.j = b() + ((this.f32015e.floatValue() - this.f32014d) / this.f32018h.k());
            }
        }
        return this.j;
    }

    public boolean d() {
        return this.f32013c == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f32011a + ", endValue=" + this.f32012b + ", startFrame=" + this.f32014d + ", endFrame=" + this.f32015e + ", interpolator=" + this.f32013c + '}';
    }
}
