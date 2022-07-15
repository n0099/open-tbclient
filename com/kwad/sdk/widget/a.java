package com.kwad.sdk.widget;

import android.animation.ValueAnimator;
/* loaded from: classes5.dex */
public final class a {
    public static ValueAnimator a(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        valueAnimator.setEvaluator(b.a());
        return valueAnimator;
    }
}
