package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0994a {
        public int height;
        public int width;
    }

    public static void a(C0994a c0994a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Qp(layoutParams.height)) {
                c0994a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0994a.width) - i) / f) + i2), c0994a.height), 1073741824);
            } else if (Qp(layoutParams.width)) {
                c0994a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0994a.height) - i2) * f) + i), c0994a.width), 1073741824);
            }
        }
    }

    private static boolean Qp(int i) {
        return i == 0 || i == -2;
    }
}
