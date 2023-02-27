package com.facebook.fresco.animation.drawable.animator;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import javax.annotation.Nullable;
@TargetApi(11)
/* loaded from: classes7.dex */
public class AnimatedDrawable2ValueAnimatorHelper {
    public static ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener(final AnimatedDrawable2 animatedDrawable2) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.facebook.fresco.animation.drawable.animator.AnimatedDrawable2ValueAnimatorHelper.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            @TargetApi(11)
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimatedDrawable2.this.setLevel(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        };
    }

    public static ValueAnimator createValueAnimator(AnimatedDrawable2 animatedDrawable2) {
        int loopCount = animatedDrawable2.getLoopCount();
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, (int) animatedDrawable2.getLoopDurationMs());
        valueAnimator.setDuration(animatedDrawable2.getLoopDurationMs());
        if (loopCount == 0) {
            loopCount = -1;
        }
        valueAnimator.setRepeatCount(loopCount);
        valueAnimator.setRepeatMode(1);
        valueAnimator.setInterpolator(null);
        valueAnimator.addUpdateListener(createAnimatorUpdateListener(animatedDrawable2));
        return valueAnimator;
    }

    @Nullable
    public static ValueAnimator createValueAnimator(AnimatedDrawable2 animatedDrawable2, int i) {
        ValueAnimator createValueAnimator = createValueAnimator(animatedDrawable2);
        if (createValueAnimator == null) {
            return null;
        }
        createValueAnimator.setRepeatCount((int) Math.max(i / animatedDrawable2.getLoopDurationMs(), 1L));
        return createValueAnimator;
    }
}
