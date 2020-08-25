package com.tb.airbnb.lottie.e;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
/* loaded from: classes7.dex */
public class a<T> {
    public final float AX;
    @Nullable
    public final T GX;
    @Nullable
    public final T GY;
    @Nullable
    public final Interpolator GZ;
    @Nullable
    public Float Ha;
    private float Hb;
    private float Hc;
    public PointF Hd;
    public PointF He;
    @Nullable
    private final com.tb.airbnb.lottie.d composition;

    public a(com.tb.airbnb.lottie.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.Hb = Float.MIN_VALUE;
        this.Hc = Float.MIN_VALUE;
        this.Hd = null;
        this.He = null;
        this.composition = dVar;
        this.GX = t;
        this.GY = t2;
        this.GZ = interpolator;
        this.AX = f;
        this.Ha = f2;
    }

    public a(T t) {
        this.Hb = Float.MIN_VALUE;
        this.Hc = Float.MIN_VALUE;
        this.Hd = null;
        this.He = null;
        this.composition = null;
        this.GX = t;
        this.GY = t;
        this.GZ = null;
        this.AX = Float.MIN_VALUE;
        this.Ha = Float.valueOf(Float.MAX_VALUE);
    }

    public float kx() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.Hb == Float.MIN_VALUE) {
            this.Hb = (this.AX - this.composition.iv()) / this.composition.iC();
        }
        return this.Hb;
    }

    public float jk() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.Hc == Float.MIN_VALUE) {
            if (this.Ha == null) {
                this.Hc = 1.0f;
            } else {
                this.Hc = kx() + ((this.Ha.floatValue() - this.AX) / this.composition.iC());
            }
        }
        return this.Hc;
    }

    public boolean la() {
        return this.GZ == null;
    }

    public boolean m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= kx() && f < jk();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.GX + ", endValue=" + this.GY + ", startFrame=" + this.AX + ", endFrame=" + this.Ha + ", interpolator=" + this.GZ + '}';
    }
}
