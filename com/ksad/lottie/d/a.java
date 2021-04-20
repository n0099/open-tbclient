package com.ksad.lottie.d;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes6.dex */
public abstract class a extends ValueAnimator {

    /* renamed from: a  reason: collision with root package name */
    public final Set<ValueAnimator.AnimatorUpdateListener> f31644a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    public final Set<Animator.AnimatorListener> f31645b = new CopyOnWriteArraySet();

    public void a() {
        for (Animator.AnimatorListener animatorListener : this.f31645b) {
            animatorListener.onAnimationRepeat(this);
        }
    }

    public void a(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.f31645b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f31645b.add(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f31644a.add(animatorUpdateListener);
    }

    public void b() {
        for (Animator.AnimatorListener animatorListener : this.f31645b) {
            animatorListener.onAnimationCancel(this);
        }
    }

    public void b(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.f31645b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    public void c() {
        for (ValueAnimator.AnimatorUpdateListener animatorUpdateListener : this.f31644a) {
            animatorUpdateListener.onAnimationUpdate(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.f31645b.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f31644a.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f31645b.remove(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f31644a.remove(animatorUpdateListener);
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

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }
}
