package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0349a {
        public int height;
        public int width;
    }

    public static void a(C0349a c0349a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (xN(layoutParams.height)) {
                c0349a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0349a.width) - i) / f) + i2), c0349a.height), AiAppsFileUtils.GB);
            } else if (xN(layoutParams.width)) {
                c0349a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0349a.height) - i2) * f) + i), c0349a.width), AiAppsFileUtils.GB);
            }
        }
    }

    private static boolean xN(int i) {
        return i == 0 || i == -2;
    }
}
