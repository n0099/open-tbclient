package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C0653a {
        public int height;
        public int width;
    }

    public static void a(C0653a c0653a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (HN(layoutParams.height)) {
                c0653a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0653a.width) - i) / f) + i2), c0653a.height), 1073741824);
            } else if (HN(layoutParams.width)) {
                c0653a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0653a.height) - i2) * f) + i), c0653a.width), 1073741824);
            }
        }
    }

    private static boolean HN(int i) {
        return i == 0 || i == -2;
    }
}
