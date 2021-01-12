package com.win.opensdk;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
/* loaded from: classes3.dex */
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

    public static int[] iX(Context context) {
        int iQ;
        int iR;
        if (context instanceof Activity) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                iQ = point.x;
                iR = point.y;
            } else {
                iQ = defaultDisplay.getWidth();
                iR = defaultDisplay.getHeight();
            }
        } else {
            iQ = bd.iQ(context);
            iR = bd.iR(context);
        }
        return new int[]{iQ, iR};
    }

    public static int[] iY(Context context) {
        int[] iX = iX(context);
        b(context, iX);
        return iX;
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
