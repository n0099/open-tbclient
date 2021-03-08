package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1065a {
        public int height;
        public int width;
    }

    public static void a(C1065a c1065a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (Pw(layoutParams.height)) {
                c1065a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c1065a.width) - i) / f) + i2), c1065a.height), 1073741824);
            } else if (Pw(layoutParams.width)) {
                c1065a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c1065a.height) - i2) * f) + i), c1065a.width), 1073741824);
            }
        }
    }

    private static boolean Pw(int i) {
        return i == 0 || i == -2;
    }
}
