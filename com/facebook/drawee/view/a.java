package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C1048a {
        public int height;
        public int width;
    }

    public static void a(C1048a c1048a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Pr(layoutParams.height)) {
                c1048a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c1048a.width) - i) / f) + i2), c1048a.height), 1073741824);
            } else if (Pr(layoutParams.width)) {
                c1048a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c1048a.height) - i2) * f) + i), c1048a.width), 1073741824);
            }
        }
    }

    private static boolean Pr(int i) {
        return i == 0 || i == -2;
    }
}
