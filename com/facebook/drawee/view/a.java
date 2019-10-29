package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0564a {
        public int height;
        public int width;
    }

    public static void a(C0564a c0564a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Cp(layoutParams.height)) {
                c0564a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0564a.width) - i) / f) + i2), c0564a.height), 1073741824);
            } else if (Cp(layoutParams.width)) {
                c0564a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0564a.height) - i2) * f) + i), c0564a.width), 1073741824);
            }
        }
    }

    private static boolean Cp(int i) {
        return i == 0 || i == -2;
    }
}
