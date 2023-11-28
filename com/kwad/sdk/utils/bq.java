package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes10.dex */
public final class bq {
    public static boolean a(View view2, int i, boolean z) {
        if (view2 == null || !b(view2, i, z) || !cs(view2.getContext())) {
            return false;
        }
        return true;
    }

    public static boolean b(View view2, int i, boolean z) {
        if (view2 == null || view2.getParent() == null) {
            return false;
        }
        Activity m186do = com.kwad.sdk.m.l.m186do(view2.getContext());
        if ((m186do != null && m186do.isFinishing()) || !view2.isShown() || view2.getVisibility() != 0 || (z && !view2.hasWindowFocus())) {
            return false;
        }
        Rect rect = new Rect();
        if (view2.getGlobalVisibleRect(rect)) {
            long height = rect.height() * rect.width();
            long height2 = view2.getHeight() * view2.getWidth();
            if (height2 > 0 && height * 100 >= i * height2) {
                return true;
            }
        }
        return false;
    }

    public static boolean cs(Context context) {
        return ao.Ky().cs(context);
    }

    public static boolean o(View view2, int i) {
        if (view2 == null || !b(view2, i, true) || !view2.hasWindowFocus() || !cs(view2.getContext())) {
            return false;
        }
        return true;
    }
}
