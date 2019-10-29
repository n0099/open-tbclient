package com.tb.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes6.dex */
public class c extends ValueAnimator {
    private long iF;
    private boolean iE = false;
    private float speed = 1.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float value = 0.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float iG = 0.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float iH = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.c.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.iE) {
                    c.this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        dr();
    }

    public void bg() {
        this.iE = true;
    }

    public void h(long j) {
        this.iF = j;
        dr();
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float clamp = e.clamp(f, this.iG, this.iH);
        this.value = clamp;
        float abs = (isReversed() ? this.iH - clamp : clamp - this.iG) / Math.abs(this.iH - this.iG);
        if (getDuration() > 0) {
            setCurrentPlayTime(abs * ((float) getDuration()));
        }
    }

    public float dq() {
        return this.value;
    }

    public void j(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.iG = f;
        this.iH = f2;
        dr();
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= this.iH) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        this.iG = f;
        dr();
    }

    public void n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= this.iG) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        this.iH = f;
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
        l(isReversed() ? this.iH : this.iG);
    }

    public void pauseAnimation() {
        float f = this.value;
        cancel();
        l(f);
    }

    public void resumeAnimation() {
        float f = this.value;
        if (isReversed() && this.value == this.iG) {
            f = this.iH;
        } else if (!isReversed() && this.value == this.iH) {
            f = this.iG;
        }
        start();
        l(f);
    }

    private boolean isReversed() {
        return this.speed < 0.0f;
    }

    private void dr() {
        setDuration((((float) this.iF) * (this.iH - this.iG)) / Math.abs(this.speed));
        float[] fArr = new float[2];
        fArr[0] = this.speed < 0.0f ? this.iH : this.iG;
        fArr[1] = this.speed < 0.0f ? this.iG : this.iH;
        setFloatValues(fArr);
        l(this.value);
    }
}
