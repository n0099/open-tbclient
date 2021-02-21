package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C1050a {
        public int height;
        public int width;
    }

    public static void a(C1050a c1050a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Ps(layoutParams.height)) {
                c1050a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c1050a.width) - i) / f) + i2), c1050a.height), 1073741824);
            } else if (Ps(layoutParams.width)) {
                c1050a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c1050a.height) - i2) * f) + i), c1050a.width), 1073741824);
            }
        }
    }

    private static boolean Ps(int i) {
        return i == 0 || i == -2;
    }
}
