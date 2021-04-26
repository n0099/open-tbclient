package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
/* loaded from: classes6.dex */
public final class FadeProvider implements VisibilityAnimatorProvider {
    public float incomingEndThreshold = 1.0f;

    public static Animator createFadeAnimator(final View view, final float f2, final float f3, @FloatRange(from = 0.0d, to = 1.0d) final float f4, @FloatRange(from = 0.0d, to = 1.0d) final float f5) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transition.platform.FadeProvider.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(TransitionUtils.lerp(f2, f3, f4, f5, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            }
        });
        return ofFloat;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createFadeAnimator(view, 0.0f, 1.0f, 0.0f, this.incomingEndThreshold);
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createFadeAnimator(view, 1.0f, 0.0f, 0.0f, 1.0f);
    }

    public float getIncomingEndThreshold() {
        return this.incomingEndThreshold;
    }

    public void setIncomingEndThreshold(float f2) {
        this.incomingEndThreshold = f2;
    }
}
