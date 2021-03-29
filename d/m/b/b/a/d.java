package d.m.b.b.a;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f66295a;

    /* renamed from: b  reason: collision with root package name */
    public static int f66296b;

    /* renamed from: c  reason: collision with root package name */
    public static int f66297c;

    public static String a(Context context) {
        try {
            b(context);
            c(context);
            d(context);
        } catch (Throwable unused) {
        }
        return "" + f66297c + "[<!>]" + f66295a + "*" + f66296b + "[<!>]";
    }

    public static void b(Context context) {
        int height;
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
                f66295a = point.x;
            } else if (Build.VERSION.SDK_INT < 13) {
                f66295a = defaultDisplay.getWidth();
                height = defaultDisplay.getHeight();
                f66296b = height;
            } else {
                defaultDisplay.getSize(point);
                f66295a = point.x;
            }
            height = point.y;
            f66296b = height;
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context) {
        if (context == null) {
            return;
        }
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float f2 = displayMetrics.density;
            f66297c = displayMetrics.densityDpi;
        } catch (Throwable unused) {
        }
    }

    public static void d(Context context) {
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float f2 = displayMetrics.xdpi;
            float f3 = displayMetrics.ydpi;
        } catch (Throwable unused) {
        }
    }
}
