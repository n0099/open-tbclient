package com.facebook.fresco.animation.drawable.animator;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class AnimatedDrawableValueAnimatorHelper {
    @Nullable
    public static ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 11 || !(drawable instanceof AnimatedDrawable2)) {
            return null;
        }
        return AnimatedDrawable2ValueAnimatorHelper.createAnimatorUpdateListener((AnimatedDrawable2) drawable);
    }

    @Nullable
    public static ValueAnimator createValueAnimator(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 11 || !(drawable instanceof AnimatedDrawable2)) {
            return null;
        }
        return AnimatedDrawable2ValueAnimatorHelper.createValueAnimator((AnimatedDrawable2) drawable);
    }

    @Nullable
    public static ValueAnimator createValueAnimator(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT < 11 || !(drawable instanceof AnimatedDrawable2)) {
            return null;
        }
        return AnimatedDrawable2ValueAnimatorHelper.createValueAnimator((AnimatedDrawable2) drawable, i);
    }
}
