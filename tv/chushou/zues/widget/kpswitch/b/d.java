package tv.chushou.zues.widget.kpswitch.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import tv.chushou.zues.b;
/* loaded from: classes6.dex */
public class d {
    private static int qgm = 0;
    private static int qgn = 0;
    private static int qgo = 0;

    /* loaded from: classes6.dex */
    public interface a {
        void jX(boolean z);
    }

    public static void bz(View view) {
        if (view != null) {
            view.requestFocus();
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }
    }

    public static void eh(View view) {
        if (view != null) {
            if (view.isFocused()) {
                view.clearFocus();
            }
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (activity.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
            }
        }
    }

    public static boolean y(Context context, int i) {
        if (i < 0) {
            return false;
        }
        qgm = i;
        tv.chushou.zues.utils.e.l("KeyBordUtil", "%s%s", "save keyboard:", Integer.valueOf(i));
        return b.O(context, i);
    }

    public static int ek(Context context) {
        if (qgm == 0) {
            qgm = b.P(context, c(context.getResources()));
        }
        return qgm;
    }

    public static int el(Context context) {
        return Math.min(b(context.getResources()), Math.max(c(context.getResources()), ek(context)));
    }

    public static int b(Resources resources) {
        if (qgn == 0) {
            qgn = resources.getDimensionPixelSize(b.c.zues_keyboard_pannel_max_height);
        }
        return qgn;
    }

    public static int c(Resources resources) {
        if (qgo == 0) {
            qgo = resources.getDimensionPixelSize(b.c.zues_keyboard_pannel_min_height);
        }
        return qgo;
    }

    public static c a(Activity activity, tv.chushou.zues.widget.kpswitch.b bVar, a aVar, boolean z) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        c cVar = new c(e.af(activity), z, e.ag(activity), viewGroup, bVar, aVar);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(cVar);
        return cVar;
    }

    @TargetApi(16)
    public static void a(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (Build.VERSION.SDK_INT >= 16) {
            viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
        tv.chushou.zues.widget.kpswitch.b.a.qgd = null;
    }
}
