package com.qq.e.comm.plugin.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
/* loaded from: classes3.dex */
public class bc {
    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }
}
