package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0975a {
        public int height;
        public int width;
    }

    public static void a(C0975a c0975a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (OQ(layoutParams.height)) {
                c0975a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0975a.width) - i) / f) + i2), c0975a.height), 1073741824);
            } else if (OQ(layoutParams.width)) {
                c0975a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0975a.height) - i2) * f) + i), c0975a.width), 1073741824);
            }
        }
    }

    private static boolean OQ(int i) {
        return i == 0 || i == -2;
    }
}
