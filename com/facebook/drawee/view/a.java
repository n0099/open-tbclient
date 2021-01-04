package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C1023a {
        public int height;
        public int width;
    }

    public static void a(C1023a c1023a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Qy(layoutParams.height)) {
                c1023a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c1023a.width) - i) / f) + i2), c1023a.height), 1073741824);
            } else if (Qy(layoutParams.width)) {
                c1023a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c1023a.height) - i2) * f) + i), c1023a.width), 1073741824);
            }
        }
    }

    private static boolean Qy(int i) {
        return i == 0 || i == -2;
    }
}
