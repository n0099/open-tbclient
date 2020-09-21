package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0866a {
        public int height;
        public int width;
    }

    public static void a(C0866a c0866a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (LY(layoutParams.height)) {
                c0866a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0866a.width) - i) / f) + i2), c0866a.height), 1073741824);
            } else if (LY(layoutParams.width)) {
                c0866a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0866a.height) - i2) * f) + i), c0866a.width), 1073741824);
            }
        }
    }

    private static boolean LY(int i) {
        return i == 0 || i == -2;
    }
}
