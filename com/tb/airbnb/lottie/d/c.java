package com.tb.airbnb.lottie.d;

import android.support.annotation.FloatRange;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.Choreographer;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes6.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    private com.tb.airbnb.lottie.d composition;
    private float speed = 1.0f;
    private boolean Gf = false;
    private long Gg = 0;
    private float Gh = 0.0f;
    private int repeatCount = 0;
    private float Gi = -2.1474836E9f;
    private float Gj = 2.1474836E9f;
    @VisibleForTesting
    protected boolean Gk = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(ju());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float ju() {
        if (this.composition == null) {
            return 0.0f;
        }
        return (this.Gh - this.composition.gU()) / (this.composition.gV() - this.composition.gU());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.Gh) / (getMaxFrame() - getMinFrame());
        }
        return (this.Gh - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return this.composition.gT();
    }

    public float jv() {
        return this.Gh;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.Gk;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        jx();
        if (this.composition != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float jw = ((float) (nanoTime - this.Gg)) / jw();
            float f = this.Gh;
            if (isReversed()) {
                jw = -jw;
            }
            this.Gh = jw + f;
            boolean z = !e.d(this.Gh, getMinFrame(), getMaxFrame());
            this.Gh = e.clamp(this.Gh, getMinFrame(), getMaxFrame());
            this.Gg = nanoTime;
            jt();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.Gh = getMaxFrame();
                    jy();
                    aa(isReversed());
                } else {
                    jr();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.Gf = this.Gf ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.Gh = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.Gg = nanoTime;
                }
            }
            jz();
        }
    }

    private float jw() {
        if (this.composition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.composition.gW()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.Gi = -2.1474836E9f;
        this.Gj = 2.1474836E9f;
    }

    public void setComposition(com.tb.airbnb.lottie.d dVar) {
        boolean z = this.composition == null;
        this.composition = dVar;
        if (z) {
            i((int) Math.max(this.Gi, dVar.gU()), (int) Math.min(this.Gj, dVar.gV()));
        } else {
            i((int) dVar.gU(), (int) dVar.gV());
        }
        setFrame((int) this.Gh);
        this.Gg = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.Gh != i) {
            this.Gh = e.clamp(i, getMinFrame(), getMaxFrame());
            this.Gg = System.nanoTime();
            jt();
        }
    }

    public void setMinFrame(int i) {
        i(i, (int) this.Gj);
    }

    public void setMaxFrame(int i) {
        i((int) this.Gi, i);
    }

    public void i(int i, int i2) {
        float gU = this.composition == null ? -3.4028235E38f : this.composition.gU();
        float gV = this.composition == null ? Float.MAX_VALUE : this.composition.gV();
        this.Gi = e.clamp(i, gU, gV);
        this.Gj = e.clamp(i2, gU, gV);
        setFrame((int) e.clamp(this.Gh, i, i2));
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
        if (i != 2 && this.Gf) {
            this.Gf = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.Gk = true;
        Z(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.Gg = System.nanoTime();
        this.repeatCount = 0;
        jx();
    }

    @MainThread
    public void endAnimation() {
        jy();
        aa(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        jy();
    }

    @MainThread
    public void resumeAnimation() {
        this.Gk = true;
        jx();
        this.Gg = System.nanoTime();
        if (isReversed() && jv() == getMinFrame()) {
            this.Gh = getMaxFrame();
        } else if (!isReversed() && jv() == getMaxFrame()) {
            this.Gh = getMinFrame();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        js();
        jy();
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.Gi == -2.1474836E9f ? this.composition.gU() : this.Gi;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.Gj == 2.1474836E9f ? this.composition.gV() : this.Gj;
    }

    protected void jx() {
        if (isRunning()) {
            ab(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void jy() {
        ab(true);
    }

    @MainThread
    protected void ab(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.Gk = false;
        }
    }

    private void jz() {
        if (this.composition != null) {
            if (this.Gh < this.Gi || this.Gh > this.Gj) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.Gi), Float.valueOf(this.Gj), Float.valueOf(this.Gh)));
            }
        }
    }
}
