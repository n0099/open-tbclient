package com.google.android.material.transition;

import android.graphics.RectF;
/* loaded from: classes3.dex */
public interface FitModeEvaluator {
    void applyMask(RectF rectF, float f2, FitModeResult fitModeResult);

    FitModeResult evaluate(float f2, float f3, float f4, float f5, float f6, float f7, float f8);

    boolean shouldMaskStartBounds(FitModeResult fitModeResult);
}
