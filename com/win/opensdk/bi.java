package com.win.opensdk;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
/* loaded from: classes4.dex */
public final class bi {
    public static Context ey(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof View)) {
            if (view.getContext() instanceof MutableContextWrapper) {
                return ((MutableContextWrapper) view.getContext()).getBaseContext();
            }
            return view.getContext();
        }
        while (parent.getParent() != null && (parent.getParent() instanceof View)) {
            parent = parent.getParent();
        }
        return ((View) parent).getContext();
    }

    public static int[] iZ(Context context) {
        int iS;
        int iT;
        if (context instanceof Activity) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                iS = point.x;
                iT = point.y;
            } else {
                iS = defaultDisplay.getWidth();
                iT = defaultDisplay.getHeight();
            }
        } else {
            iS = bd.iS(context);
            iT = bd.iT(context);
        }
        return new int[]{iS, iT};
    }

    public static int[] ja(Context context) {
        int[] iZ = iZ(context);
        b(context, iZ);
        return iZ;
    }

    public static void b(Context context, int[] iArr) {
        float f = context.getResources().getDisplayMetrics().density;
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = l(context, iArr[i]);
        }
    }

    private static int l(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int k(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
