package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0662a {
        public int height;
        public int width;
    }

    public static void a(C0662a c0662a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (HY(layoutParams.height)) {
                c0662a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0662a.width) - i) / f) + i2), c0662a.height), 1073741824);
            } else if (HY(layoutParams.width)) {
                c0662a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0662a.height) - i2) * f) + i), c0662a.width), 1073741824);
            }
        }
    }

    private static boolean HY(int i) {
        return i == 0 || i == -2;
    }
}
