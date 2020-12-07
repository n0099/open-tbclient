package com.tb.airbnb.lottie.e;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
/* loaded from: classes20.dex */
public class a<T> {
    public final float Ce;
    @Nullable
    public final T If;
    @Nullable
    public final T Ig;
    @Nullable
    public final Interpolator Ih;
    @Nullable
    public Float Ii;
    private float Ij;
    private float Ik;
    public PointF Il;
    public PointF Im;
    @Nullable
    private final com.tb.airbnb.lottie.e composition;

    public a(com.tb.airbnb.lottie.e eVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.Ij = Float.MIN_VALUE;
        this.Ik = Float.MIN_VALUE;
        this.Il = null;
        this.Im = null;
        this.composition = eVar;
        this.If = t;
        this.Ig = t2;
        this.Ih = interpolator;
        this.Ce = f;
        this.Ii = f2;
    }

    public a(T t) {
        this.Ij = Float.MIN_VALUE;
        this.Ik = Float.MIN_VALUE;
        this.Il = null;
        this.Im = null;
        this.composition = null;
        this.If = t;
        this.Ig = t;
        this.Ih = null;
        this.Ce = Float.MIN_VALUE;
        this.Ii = Float.valueOf(Float.MAX_VALUE);
    }

    public float kz() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.Ij == Float.MIN_VALUE) {
            this.Ij = (this.Ce - this.composition.iw()) / this.composition.iD();
        }
        return this.Ij;
    }

    public float jm() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.Ik == Float.MIN_VALUE) {
            if (this.Ii == null) {
                this.Ik = 1.0f;
            } else {
                this.Ik = kz() + ((this.Ii.floatValue() - this.Ce) / this.composition.iD());
            }
        }
        return this.Ik;
    }

    public boolean lc() {
        return this.Ih == null;
    }

    public boolean l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= kz() && f < jm();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.If + ", endValue=" + this.Ig + ", startFrame=" + this.Ce + ", endFrame=" + this.Ii + ", interpolator=" + this.Ih + '}';
    }
}
