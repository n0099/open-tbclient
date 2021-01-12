package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1044a {
        public int height;
        public int width;
    }

    public static void a(C1044a c1044a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (OW(layoutParams.height)) {
                c1044a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c1044a.width) - i) / f) + i2), c1044a.height), 1073741824);
            } else if (OW(layoutParams.width)) {
                c1044a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c1044a.height) - i2) * f) + i), c1044a.width), 1073741824);
            }
        }
    }

    private static boolean OW(int i) {
        return i == 0 || i == -2;
    }
}
