package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0781a {
        public int height;
        public int width;
    }

    public static void a(C0781a c0781a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Hl(layoutParams.height)) {
                c0781a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0781a.width) - i) / f) + i2), c0781a.height), 1073741824);
            } else if (Hl(layoutParams.width)) {
                c0781a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0781a.height) - i2) * f) + i), c0781a.width), 1073741824);
            }
        }
    }

    private static boolean Hl(int i) {
        return i == 0 || i == -2;
    }
}
