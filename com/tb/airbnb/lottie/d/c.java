package com.tb.airbnb.lottie.d;

import android.support.annotation.FloatRange;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.Choreographer;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes7.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    private com.tb.airbnb.lottie.d composition;
    private float speed = 1.0f;
    private boolean GL = false;
    private long GM = 0;
    private float GN = 0.0f;
    private int repeatCount = 0;
    private float GO = -2.1474836E9f;
    private float GP = 2.1474836E9f;
    @VisibleForTesting
    protected boolean GQ = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(kT());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float kT() {
        if (this.composition == null) {
            return 0.0f;
        }
        return (this.GN - this.composition.iv()) / (this.composition.iw() - this.composition.iv());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.GN) / (getMaxFrame() - getMinFrame());
        }
        return (this.GN - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return this.composition.iu();
    }

    public float kU() {
        return this.GN;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.GQ;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        kW();
        if (this.composition != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float kV = ((float) (nanoTime - this.GM)) / kV();
            float f = this.GN;
            if (isReversed()) {
                kV = -kV;
            }
            this.GN = kV + f;
            boolean z = !e.d(this.GN, getMinFrame(), getMaxFrame());
            this.GN = e.clamp(this.GN, getMinFrame(), getMaxFrame());
            this.GM = nanoTime;
            kS();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.GN = getMaxFrame();
                    kX();
                    ab(isReversed());
                } else {
                    kQ();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.GL = this.GL ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.GN = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.GM = nanoTime;
                }
            }
            kY();
        }
    }

    private float kV() {
        if (this.composition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.composition.ix()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.GO = -2.1474836E9f;
        this.GP = 2.1474836E9f;
    }

    public void setComposition(com.tb.airbnb.lottie.d dVar) {
        boolean z = this.composition == null;
        this.composition = dVar;
        if (z) {
            k((int) Math.max(this.GO, dVar.iv()), (int) Math.min(this.GP, dVar.iw()));
        } else {
            k((int) dVar.iv(), (int) dVar.iw());
        }
        setFrame((int) this.GN);
        this.GM = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.GN != i) {
            this.GN = e.clamp(i, getMinFrame(), getMaxFrame());
            this.GM = System.nanoTime();
            kS();
        }
    }

    public void setMinFrame(int i) {
        k(i, (int) this.GP);
    }

    public void setMaxFrame(int i) {
        k((int) this.GO, i);
    }

    public void k(int i, int i2) {
        float iv = this.composition == null ? -3.4028235E38f : this.composition.iv();
        float iw = this.composition == null ? Float.MAX_VALUE : this.composition.iw();
        this.GO = e.clamp(i, iv, iw);
        this.GP = e.clamp(i2, iv, iw);
        setFrame((int) e.clamp(this.GN, i, i2));
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public float getSpeed() {
        return this.speed;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.GL) {
            this.GL = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.GQ = true;
        aa(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.GM = System.nanoTime();
        this.repeatCount = 0;
        kW();
    }

    @MainThread
    public void endAnimation() {
        kX();
        ab(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        kX();
    }

    @MainThread
    public void resumeAnimation() {
        this.GQ = true;
        kW();
        this.GM = System.nanoTime();
        if (isReversed() && kU() == getMinFrame()) {
            this.GN = getMaxFrame();
        } else if (!isReversed() && kU() == getMaxFrame()) {
            this.GN = getMinFrame();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        kR();
        kX();
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.GO == -2.1474836E9f ? this.composition.iv() : this.GO;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.GP == 2.1474836E9f ? this.composition.iw() : this.GP;
    }

    protected void kW() {
        if (isRunning()) {
            ac(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void kX() {
        ac(true);
    }

    @MainThread
    protected void ac(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.GQ = false;
        }
    }

    private void kY() {
        if (this.composition != null) {
            if (this.GN < this.GO || this.GN > this.GP) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.GO), Float.valueOf(this.GP), Float.valueOf(this.GN)));
            }
        }
    }
}
