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
    private boolean FB = false;
    private long FC = 0;
    private float FD = 0.0f;
    private int repeatCount = 0;
    private float FE = -2.1474836E9f;
    private float FF = 2.1474836E9f;
    @VisibleForTesting
    protected boolean FG = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(je());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float je() {
        if (this.composition == null) {
            return 0.0f;
        }
        return (this.FD - this.composition.gE()) / (this.composition.gF() - this.composition.gE());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.FD) / (getMaxFrame() - getMinFrame());
        }
        return (this.FD - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return this.composition.gD();
    }

    public float jf() {
        return this.FD;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.FG;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        jh();
        if (this.composition != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float jg = ((float) (nanoTime - this.FC)) / jg();
            float f = this.FD;
            if (isReversed()) {
                jg = -jg;
            }
            this.FD = jg + f;
            boolean z = !e.d(this.FD, getMinFrame(), getMaxFrame());
            this.FD = e.clamp(this.FD, getMinFrame(), getMaxFrame());
            this.FC = nanoTime;
            jd();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.FD = getMaxFrame();
                    ji();
                    Z(isReversed());
                } else {
                    jb();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.FB = this.FB ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.FD = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.FC = nanoTime;
                }
            }
            jj();
        }
    }

    private float jg() {
        if (this.composition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.composition.gG()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.FE = -2.1474836E9f;
        this.FF = 2.1474836E9f;
    }

    public void setComposition(com.tb.airbnb.lottie.d dVar) {
        boolean z = this.composition == null;
        this.composition = dVar;
        if (z) {
            h((int) Math.max(this.FE, dVar.gE()), (int) Math.min(this.FF, dVar.gF()));
        } else {
            h((int) dVar.gE(), (int) dVar.gF());
        }
        setFrame((int) this.FD);
        this.FC = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.FD != i) {
            this.FD = e.clamp(i, getMinFrame(), getMaxFrame());
            this.FC = System.nanoTime();
            jd();
        }
    }

    public void setMinFrame(int i) {
        h(i, (int) this.FF);
    }

    public void setMaxFrame(int i) {
        h((int) this.FE, i);
    }

    public void h(int i, int i2) {
        float gE = this.composition == null ? -3.4028235E38f : this.composition.gE();
        float gF = this.composition == null ? Float.MAX_VALUE : this.composition.gF();
        this.FE = e.clamp(i, gE, gF);
        this.FF = e.clamp(i2, gE, gF);
        setFrame((int) e.clamp(this.FD, i, i2));
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
        if (i != 2 && this.FB) {
            this.FB = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.FG = true;
        Y(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.FC = System.nanoTime();
        this.repeatCount = 0;
        jh();
    }

    @MainThread
    public void endAnimation() {
        ji();
        Z(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        ji();
    }

    @MainThread
    public void resumeAnimation() {
        this.FG = true;
        jh();
        this.FC = System.nanoTime();
        if (isReversed() && jf() == getMinFrame()) {
            this.FD = getMaxFrame();
        } else if (!isReversed() && jf() == getMaxFrame()) {
            this.FD = getMinFrame();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        jc();
        ji();
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.FE == -2.1474836E9f ? this.composition.gE() : this.FE;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.FF == 2.1474836E9f ? this.composition.gF() : this.FF;
    }

    protected void jh() {
        if (isRunning()) {
            aa(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void ji() {
        aa(true);
    }

    @MainThread
    protected void aa(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.FG = false;
        }
    }

    private void jj() {
        if (this.composition != null) {
            if (this.FD < this.FE || this.FD > this.FF) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.FE), Float.valueOf(this.FF), Float.valueOf(this.FD)));
            }
        }
    }
}
