package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0363a {
        public int height;
        public int width;
    }

    public static void a(C0363a c0363a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (yk(layoutParams.height)) {
                c0363a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0363a.width) - i) / f) + i2), c0363a.height), AiAppsFileUtils.GB);
            } else if (yk(layoutParams.width)) {
                c0363a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0363a.height) - i2) * f) + i), c0363a.width), AiAppsFileUtils.GB);
            }
        }
    }

    private static boolean yk(int i) {
        return i == 0 || i == -2;
    }
}
