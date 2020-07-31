package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0811a {
        public int height;
        public int width;
    }

    public static void a(C0811a c0811a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (IP(layoutParams.height)) {
                c0811a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0811a.width) - i) / f) + i2), c0811a.height), 1073741824);
            } else if (IP(layoutParams.width)) {
                c0811a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0811a.height) - i2) * f) + i), c0811a.width), 1073741824);
            }
        }
    }

    private static boolean IP(int i) {
        return i == 0 || i == -2;
    }
}
