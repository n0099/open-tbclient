package com.pgl.sys.ces.a;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f11693a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f11694b = 0;
    private static int d = 0;
    public static int c = 0;
    private static int e = 0;
    private static int f = 0;

    public static String a(Context context) {
        try {
            b(context);
            c(context);
            d(context);
        } catch (Throwable th) {
        }
        return "" + c + "[<!>]" + f11693a + "*" + f11694b + "[<!>]";
    }

    private static void b(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
                f11693a = point.x;
                f11694b = point.y;
            } else if (Build.VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
                f11693a = point.x;
                f11694b = point.y;
            } else {
                f11693a = defaultDisplay.getWidth();
                f11694b = defaultDisplay.getHeight();
            }
        } catch (Throwable th) {
        }
    }

    private static void c(Context context) {
        if (context == null) {
            return;
        }
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d = (int) displayMetrics.density;
            c = displayMetrics.densityDpi;
        } catch (Throwable th) {
        }
    }

    private static void d(Context context) {
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            e = (int) displayMetrics.xdpi;
            f = (int) displayMetrics.ydpi;
        } catch (Throwable th) {
        }
    }
}
