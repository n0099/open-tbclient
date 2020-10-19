package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0884a {
        public int height;
        public int width;
    }

    public static void a(C0884a c0884a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (ME(layoutParams.height)) {
                c0884a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0884a.width) - i) / f) + i2), c0884a.height), 1073741824);
            } else if (ME(layoutParams.width)) {
                c0884a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0884a.height) - i2) * f) + i), c0884a.width), 1073741824);
            }
        }
    }

    private static boolean ME(int i) {
        return i == 0 || i == -2;
    }
}
