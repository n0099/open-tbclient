package com.tb.airbnb.lottie.d;

import android.support.annotation.FloatRange;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.Choreographer;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes16.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    private com.tb.airbnb.lottie.e composition;
    private float speed = 1.0f;
    private boolean He = false;
    private long Hf = 0;
    private float Hg = 0.0f;
    private int repeatCount = 0;
    private float Hh = -2.1474836E9f;
    private float Hi = 2.1474836E9f;
    @VisibleForTesting
    protected boolean running = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(kV());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float kV() {
        if (this.composition == null) {
            return 0.0f;
        }
        return (this.Hg - this.composition.iw()) / (this.composition.ix() - this.composition.iw());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.Hg) / (getMaxFrame() - getMinFrame());
        }
        return (this.Hg - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return this.composition.iv();
    }

    public float kW() {
        return this.Hg;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.running;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        kY();
        if (this.composition != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float kX = ((float) (nanoTime - this.Hf)) / kX();
            float f = this.Hg;
            if (isReversed()) {
                kX = -kX;
            }
            this.Hg = kX + f;
            boolean z = !e.d(this.Hg, getMinFrame(), getMaxFrame());
            this.Hg = e.clamp(this.Hg, getMinFrame(), getMaxFrame());
            this.Hf = nanoTime;
            kU();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.Hg = getMaxFrame();
                    kZ();
                    aa(isReversed());
                } else {
                    kS();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.He = this.He ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.Hg = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.Hf = nanoTime;
                }
            }
            la();
        }
    }

    private float kX() {
        if (this.composition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.composition.iy()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.Hh = -2.1474836E9f;
        this.Hi = 2.1474836E9f;
    }

    public void setComposition(com.tb.airbnb.lottie.e eVar) {
        boolean z = this.composition == null;
        this.composition = eVar;
        if (z) {
            k((int) Math.max(this.Hh, eVar.iw()), (int) Math.min(this.Hi, eVar.ix()));
        } else {
            k((int) eVar.iw(), (int) eVar.ix());
        }
        setFrame((int) this.Hg);
        this.Hf = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.Hg != i) {
            this.Hg = e.clamp(i, getMinFrame(), getMaxFrame());
            this.Hf = System.nanoTime();
            kU();
        }
    }

    public void setMinFrame(int i) {
        k(i, (int) this.Hi);
    }

    public void setMaxFrame(int i) {
        k((int) this.Hh, i);
    }

    public void k(int i, int i2) {
        float iw = this.composition == null ? -3.4028235E38f : this.composition.iw();
        float ix = this.composition == null ? Float.MAX_VALUE : this.composition.ix();
        this.Hh = e.clamp(i, iw, ix);
        this.Hi = e.clamp(i2, iw, ix);
        setFrame((int) e.clamp(this.Hg, i, i2));
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
        if (i != 2 && this.He) {
            this.He = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.running = true;
        Z(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.Hf = System.nanoTime();
        this.repeatCount = 0;
        kY();
    }

    @MainThread
    public void endAnimation() {
        kZ();
        aa(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        kZ();
    }

    @MainThread
    public void resumeAnimation() {
        this.running = true;
        kY();
        this.Hf = System.nanoTime();
        if (isReversed() && kW() == getMinFrame()) {
            this.Hg = getMaxFrame();
        } else if (!isReversed() && kW() == getMaxFrame()) {
            this.Hg = getMinFrame();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        kT();
        kZ();
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.Hh == -2.1474836E9f ? this.composition.iw() : this.Hh;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.Hi == 2.1474836E9f ? this.composition.ix() : this.Hi;
    }

    protected void kY() {
        if (isRunning()) {
            ab(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void kZ() {
        ab(true);
    }

    @MainThread
    protected void ab(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }

    private void la() {
        if (this.composition != null) {
            if (this.Hg < this.Hh || this.Hg > this.Hi) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.Hh), Float.valueOf(this.Hi), Float.valueOf(this.Hg)));
            }
        }
    }
}
