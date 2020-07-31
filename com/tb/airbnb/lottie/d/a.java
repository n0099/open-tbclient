package com.tb.airbnb.lottie.d;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes5.dex */
public abstract class a extends ValueAnimator {
    private final Set<ValueAnimator.AnimatorUpdateListener> Gd = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorListener> Ge = new CopyOnWriteArraySet();

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Gd.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Gd.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.Gd.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.Ge.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.Ge.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.Ge.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.Ge) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jr() {
        for (Animator.AnimatorListener animatorListener : this.Ge) {
            animatorListener.onAnimationRepeat(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aa(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.Ge) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void js() {
        for (Animator.AnimatorListener animatorListener : this.Ge) {
            animatorListener.onAnimationCancel(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jt() {
        for (ValueAnimator.AnimatorUpdateListener animatorUpdateListener : this.Gd) {
            animatorUpdateListener.onAnimationUpdate(this);
        }
    }
}
