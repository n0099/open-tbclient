package com.tb.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes6.dex */
public class c extends ValueAnimator {
    private long ia;
    private boolean hZ = false;
    private float speed = 1.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float value = 0.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float ib = 0.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float ic = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.c.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.hZ) {
                    c.this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        dr();
    }

    public void bg() {
        this.hZ = true;
    }

    public void g(long j) {
        this.ia = j;
        dr();
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float clamp = e.clamp(f, this.ib, this.ic);
        this.value = clamp;
        float abs = (isReversed() ? this.ic - clamp : clamp - this.ib) / Math.abs(this.ic - this.ib);
        if (getDuration() > 0) {
            setCurrentPlayTime(abs * ((float) getDuration()));
        }
    }

    public float dq() {
        return this.value;
    }

    public void j(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.ib = f;
        this.ic = f2;
        dr();
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= this.ic) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        this.ib = f;
        dr();
    }

    public void n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= this.ib) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        this.ic = f;
        dr();
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setSpeed(float f) {
        this.speed = f;
        dr();
    }

    public float getSpeed() {
        return this.speed;
    }

    public void playAnimation() {
        start();
        l(isReversed() ? this.ic : this.ib);
    }

    public void pauseAnimation() {
        float f = this.value;
        cancel();
        l(f);
    }

    public void resumeAnimation() {
        float f = this.value;
        if (isReversed() && this.value == this.ib) {
            f = this.ic;
        } else if (!isReversed() && this.value == this.ic) {
            f = this.ib;
        }
        start();
        l(f);
    }

    private boolean isReversed() {
        return this.speed < 0.0f;
    }

    private void dr() {
        setDuration((((float) this.ia) * (this.ic - this.ib)) / Math.abs(this.speed));
        float[] fArr = new float[2];
        fArr[0] = this.speed < 0.0f ? this.ic : this.ib;
        fArr[1] = this.speed < 0.0f ? this.ib : this.ic;
        setFloatValues(fArr);
        l(this.value);
    }
}
