package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class AspectRatioMeasure {

    /* loaded from: classes7.dex */
    public static class Spec {
        public int height;
        public int width;
    }

    public static boolean shouldAdjust(int i) {
        return i == 0 || i == -2;
    }

    public static void updateMeasureSpec(Spec spec, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (shouldAdjust(layoutParams.height)) {
                spec.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(spec.width) - i) / f) + i2), spec.height), 1073741824);
            } else if (shouldAdjust(layoutParams.width)) {
                spec.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(spec.height) - i2) * f) + i), spec.width), 1073741824);
            }
        }
    }
}
