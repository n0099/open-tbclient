package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0869a {
        public int height;
        public int width;
    }

    public static void a(C0869a c0869a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Lt(layoutParams.height)) {
                c0869a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0869a.width) - i) / f) + i2), c0869a.height), 1073741824);
            } else if (Lt(layoutParams.width)) {
                c0869a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0869a.height) - i2) * f) + i), c0869a.width), 1073741824);
            }
        }
    }

    private static boolean Lt(int i) {
        return i == 0 || i == -2;
    }
}
