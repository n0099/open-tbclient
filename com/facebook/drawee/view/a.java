package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0782a {
        public int height;
        public int width;
    }

    public static void a(C0782a c0782a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Hn(layoutParams.height)) {
                c0782a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0782a.width) - i) / f) + i2), c0782a.height), 1073741824);
            } else if (Hn(layoutParams.width)) {
                c0782a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0782a.height) - i2) * f) + i), c0782a.width), 1073741824);
            }
        }
    }

    private static boolean Hn(int i) {
        return i == 0 || i == -2;
    }
}
