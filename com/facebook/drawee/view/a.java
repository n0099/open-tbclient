package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0956a {
        public int height;
        public int width;
    }

    public static void a(C0956a c0956a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Ov(layoutParams.height)) {
                c0956a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0956a.width) - i) / f) + i2), c0956a.height), 1073741824);
            } else if (Ov(layoutParams.width)) {
                c0956a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0956a.height) - i2) * f) + i), c0956a.width), 1073741824);
            }
        }
    }

    private static boolean Ov(int i) {
        return i == 0 || i == -2;
    }
}
