package d.b.c0.a.k;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
/* loaded from: classes2.dex */
public class h {
    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static DisplayMetrics b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static int c(Context context, int i) {
        try {
            return (int) (i * d(context));
        } catch (Exception unused) {
            return i;
        }
    }

    public static float d(Context context) {
        return b(context).density;
    }

    public static boolean e(View view) {
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            long height = rect.height() * rect.width();
            long height2 = view.getHeight() * view.getWidth();
            return height2 > 0 && height * 100 >= height2 * 50;
        }
        return false;
    }
}
