package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0362a {
        public int height;
        public int width;
    }

    public static void a(C0362a c0362a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (yz(layoutParams.height)) {
                c0362a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0362a.width) - i) / f) + i2), c0362a.height), AiAppsFileUtils.GB);
            } else if (yz(layoutParams.width)) {
                c0362a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0362a.height) - i2) * f) + i), c0362a.width), AiAppsFileUtils.GB);
            }
        }
    }

    private static boolean yz(int i) {
        return i == 0 || i == -2;
    }
}
