package com.kwad.sdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
/* loaded from: classes6.dex */
public class am {
    public static ValueAnimator a(final View view, int i, final int i2) {
        c(view, i);
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.utils.am.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                am.c(view, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.utils.am.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                am.c(view, i2);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                am.c(view, i2);
            }
        });
        return ofInt;
    }

    public static ValueAnimator a(final View view, final View view2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(new DecelerateInterpolator(2.0f));
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.utils.am.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.setAlpha(1.0f - floatValue);
                view2.setAlpha(floatValue);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.utils.am.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view2.setAlpha(0.0f);
                view2.setVisibility(0);
            }
        });
        return ofFloat;
    }

    public static ValueAnimator a(@NonNull final View view, @NonNull final View view2, final int i) {
        ValueAnimator ofInt = ObjectAnimator.ofInt(0, i);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.utils.am.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setTranslationX(-((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.utils.am.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                am.d(view2, i);
            }
        });
        return ofInt;
    }

    public static ValueAnimator a(final View view, final boolean z) {
        float[] fArr = new float[2];
        fArr[0] = z ? 0.0f : 1.0f;
        fArr[1] = z ? 1.0f : 0.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.45f, 0.0f, 0.6f, 1.0f));
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.utils.am.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.utils.am.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (z) {
                    return;
                }
                view.setAlpha(0.0f);
                view.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z) {
                    view.setAlpha(0.0f);
                    view.setVisibility(0);
                }
            }
        });
        return ofFloat;
    }

    public static ValueAnimator b(final View view, int i, int i2) {
        ValueAnimator ofInt = ObjectAnimator.ofInt(i, i2);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.utils.am.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        return ofInt;
    }

    public static ValueAnimator c(final View view, int i, int i2) {
        ValueAnimator ofInt = ObjectAnimator.ofInt(i, i2);
        ofInt.setInterpolator(new DecelerateInterpolator(2.0f));
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.utils.am.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setTranslationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        return ofInt;
    }

    public static void c(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public static ValueAnimator d(final View view, int i, final int i2) {
        c(view, i);
        view.setVisibility(0);
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setInterpolator(new DecelerateInterpolator(2.0f));
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.utils.am.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                am.c(view, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.utils.am.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                am.c(view, i2);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                am.c(view, i2);
            }
        });
        return ofInt;
    }

    public static void d(final View view, int i) {
        ValueAnimator ofInt = ObjectAnimator.ofInt(i, 0);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.utils.am.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setTranslationX(-((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.start();
    }
}
