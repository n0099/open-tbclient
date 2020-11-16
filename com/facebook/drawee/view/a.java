package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0978a {
        public int height;
        public int width;
    }

    public static void a(C0978a c0978a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Pt(layoutParams.height)) {
                c0978a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0978a.width) - i) / f) + i2), c0978a.height), 1073741824);
            } else if (Pt(layoutParams.width)) {
                c0978a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0978a.height) - i2) * f) + i), c0978a.width), 1073741824);
            }
        }
    }

    private static boolean Pt(int i) {
        return i == 0 || i == -2;
    }
}
