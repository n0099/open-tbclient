package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0801a {
        public int height;
        public int width;
    }

    public static void a(C0801a c0801a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Iu(layoutParams.height)) {
                c0801a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0801a.width) - i) / f) + i2), c0801a.height), 1073741824);
            } else if (Iu(layoutParams.width)) {
                c0801a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0801a.height) - i2) * f) + i), c0801a.width), 1073741824);
            }
        }
    }

    private static boolean Iu(int i) {
        return i == 0 || i == -2;
    }
}
