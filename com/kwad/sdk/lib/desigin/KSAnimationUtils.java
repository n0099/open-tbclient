package com.kwad.sdk.lib.desigin;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Keep;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
@Keep
/* loaded from: classes6.dex */
public class KSAnimationUtils {
    public static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    public static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    public static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
    public static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();

    public static float lerp(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int lerp(int i, int i2, float f2) {
        return i + Math.round(f2 * (i2 - i));
    }
}
