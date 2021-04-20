package com.ksad.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class a<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final T f31672a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f31673b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f31674c;

    /* renamed from: d  reason: collision with root package name */
    public final float f31675d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public Float f31676e;

    /* renamed from: f  reason: collision with root package name */
    public PointF f31677f;

    /* renamed from: g  reason: collision with root package name */
    public PointF f31678g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.d f31679h;
    public float i;
    public float j;

    public a(com.ksad.lottie.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f31677f = null;
        this.f31678g = null;
        this.f31679h = dVar;
        this.f31672a = t;
        this.f31673b = t2;
        this.f31674c = interpolator;
        this.f31675d = f2;
        this.f31676e = f3;
    }

    public a(T t) {
        this.i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f31677f = null;
        this.f31678g = null;
        this.f31679h = null;
        this.f31672a = t;
        this.f31673b = t;
        this.f31674c = null;
        this.f31675d = Float.MIN_VALUE;
        this.f31676e = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= b() && f2 < c();
    }

    public float b() {
        com.ksad.lottie.d dVar = this.f31679h;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.i == Float.MIN_VALUE) {
            this.i = (this.f31675d - dVar.d()) / this.f31679h.k();
        }
        return this.i;
    }

    public float c() {
        if (this.f31679h == null) {
            return 1.0f;
        }
        if (this.j == Float.MIN_VALUE) {
            if (this.f31676e == null) {
                this.j = 1.0f;
            } else {
                this.j = b() + ((this.f31676e.floatValue() - this.f31675d) / this.f31679h.k());
            }
        }
        return this.j;
    }

    public boolean d() {
        return this.f31674c == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f31672a + ", endValue=" + this.f31673b + ", startFrame=" + this.f31675d + ", endFrame=" + this.f31676e + ", interpolator=" + this.f31674c + '}';
    }
}
