package com.kwad.sdk.widget;

import android.animation.ValueAnimator;
/* loaded from: classes10.dex */
public final class a {
    public static ValueAnimator ofArgb(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        valueAnimator.setEvaluator(b.Bv());
        return valueAnimator;
    }
}
