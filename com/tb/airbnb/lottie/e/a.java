package com.tb.airbnb.lottie.e;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
/* loaded from: classes5.dex */
public class a<T> {
    @Nullable
    private final com.tb.airbnb.lottie.d composition;
    public final float ec;
    @Nullable
    public final T km;
    @Nullable
    public final T kn;
    @Nullable
    public final Interpolator ko;
    @Nullable
    public Float kp;
    private float kq;
    private float kr;
    public PointF ks;
    public PointF kt;

    public a(com.tb.airbnb.lottie.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.kq = Float.MIN_VALUE;
        this.kr = Float.MIN_VALUE;
        this.ks = null;
        this.kt = null;
        this.composition = dVar;
        this.km = t;
        this.kn = t2;
        this.ko = interpolator;
        this.ec = f;
        this.kp = f2;
    }

    public a(T t) {
        this.kq = Float.MIN_VALUE;
        this.kr = Float.MIN_VALUE;
        this.ks = null;
        this.kt = null;
        this.composition = null;
        this.km = t;
        this.kn = t;
        this.ko = null;
        this.ec = Float.MIN_VALUE;
        this.kp = Float.valueOf(Float.MAX_VALUE);
    }

    public float di() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.kq == Float.MIN_VALUE) {
            this.kq = (this.ec - this.composition.bg()) / this.composition.bn();
        }
        return this.kq;
    }

    public float bV() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.kr == Float.MIN_VALUE) {
            if (this.kp == null) {
                this.kr = 1.0f;
            } else {
                this.kr = di() + ((this.kp.floatValue() - this.ec) / this.composition.bn());
            }
        }
        return this.kr;
    }

    public boolean dL() {
        return this.ko == null;
    }

    public boolean n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= di() && f < bV();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.km + ", endValue=" + this.kn + ", startFrame=" + this.ec + ", endFrame=" + this.kp + ", interpolator=" + this.ko + '}';
    }
}
