package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1061a {
        public int height;
        public int width;
    }

    public static void a(C1061a c1061a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (QD(layoutParams.height)) {
                c1061a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c1061a.width) - i) / f) + i2), c1061a.height), 1073741824);
            } else if (QD(layoutParams.width)) {
                c1061a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c1061a.height) - i2) * f) + i), c1061a.width), 1073741824);
            }
        }
    }

    private static boolean QD(int i) {
        return i == 0 || i == -2;
    }
}
