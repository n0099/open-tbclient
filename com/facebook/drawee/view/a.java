package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0647a {
        public int height;
        public int width;
    }

    public static void a(C0647a c0647a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (HE(layoutParams.height)) {
                c0647a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0647a.width) - i) / f) + i2), c0647a.height), 1073741824);
            } else if (HE(layoutParams.width)) {
                c0647a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0647a.height) - i2) * f) + i), c0647a.width), 1073741824);
            }
        }
    }

    private static boolean HE(int i) {
        return i == 0 || i == -2;
    }
}
