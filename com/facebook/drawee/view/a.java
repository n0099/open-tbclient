package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0338a {
        public int height;
        public int width;
    }

    public static void a(C0338a c0338a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Cl(layoutParams.height)) {
                c0338a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0338a.width) - i) / f) + i2), c0338a.height), 1073741824);
            } else if (Cl(layoutParams.width)) {
                c0338a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0338a.height) - i2) * f) + i), c0338a.width), 1073741824);
            }
        }
    }

    private static boolean Cl(int i) {
        return i == 0 || i == -2;
    }
}
