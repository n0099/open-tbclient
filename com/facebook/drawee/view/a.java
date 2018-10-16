package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0321a {
        public int height;
        public int width;
    }

    public static void a(C0321a c0321a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (xu(layoutParams.height)) {
                c0321a.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0321a.width) - i) / f) + i2), c0321a.height), AiAppsFileUtils.GB);
            } else if (xu(layoutParams.width)) {
                c0321a.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0321a.height) - i2) * f) + i), c0321a.width), AiAppsFileUtils.GB);
            }
        }
    }

    private static boolean xu(int i) {
        return i == 0 || i == -2;
    }
}
