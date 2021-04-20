package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class AspectRatioMeasure {

    /* loaded from: classes5.dex */
    public static class Spec {
        public int height;
        public int width;
    }

    public static boolean shouldAdjust(int i) {
        return i == 0 || i == -2;
    }

    public static void updateMeasureSpec(Spec spec, float f2, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f2 <= 0.0f || layoutParams == null) {
            return;
        }
        if (shouldAdjust(layoutParams.height)) {
            spec.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(spec.width) - i) / f2) + i2), spec.height), 1073741824);
        } else if (shouldAdjust(layoutParams.width)) {
            spec.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(spec.height) - i2) * f2) + i), spec.width), 1073741824);
        }
    }
}
