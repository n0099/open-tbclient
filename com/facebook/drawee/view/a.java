package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0434a {
        public int height;
        public int width;
    }

    public static void a(C0434a c0434a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Cc(layoutParams.height)) {
                c0434a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0434a.width) - i) / f) + i2), c0434a.height), 1073741824);
            } else if (Cc(layoutParams.width)) {
                c0434a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0434a.height) - i2) * f) + i), c0434a.width), 1073741824);
            }
        }
    }

    private static boolean Cc(int i) {
        return i == 0 || i == -2;
    }
}
