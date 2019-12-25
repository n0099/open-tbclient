package com.tb.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes2.dex */
public class c extends ValueAnimator {
    private long mPe;
    private boolean mPd = false;
    private float speed = 1.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float value = 0.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float mPf = 0.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float mPg = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.c.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.mPd) {
                    c.this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        dCt();
    }

    public void dBb() {
        this.mPd = true;
    }

    public void gR(long j) {
        this.mPe = j;
        dCt();
    }

    public void bG(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float clamp = e.clamp(f, this.mPf, this.mPg);
        this.value = clamp;
        float abs = (isReversed() ? this.mPg - clamp : clamp - this.mPf) / Math.abs(this.mPg - this.mPf);
        if (getDuration() > 0) {
            setCurrentPlayTime(abs * ((float) getDuration()));
        }
    }

    public float dCs() {
        return this.value;
    }

    public void F(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.mPf = f;
        this.mPg = f2;
        dCt();
    }

    public void bH(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= this.mPg) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        this.mPf = f;
        dCt();
    }

    public void bI(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= this.mPf) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        this.mPg = f;
        dCt();
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setSpeed(float f) {
        this.speed = f;
        dCt();
    }

    public float getSpeed() {
        return this.speed;
    }

    public void playAnimation() {
        start();
        bG(isReversed() ? this.mPg : this.mPf);
    }

    public void pauseAnimation() {
        float f = this.value;
        cancel();
        bG(f);
    }

    public void resumeAnimation() {
        float f = this.value;
        if (isReversed() && this.value == this.mPf) {
            f = this.mPg;
        } else if (!isReversed() && this.value == this.mPg) {
            f = this.mPf;
        }
        start();
        bG(f);
    }

    private boolean isReversed() {
        return this.speed < 0.0f;
    }

    private void dCt() {
        setDuration((((float) this.mPe) * (this.mPg - this.mPf)) / Math.abs(this.speed));
        float[] fArr = new float[2];
        fArr[0] = this.speed < 0.0f ? this.mPg : this.mPf;
        fArr[1] = this.speed < 0.0f ? this.mPf : this.mPg;
        setFloatValues(fArr);
        bG(this.value);
    }
}
