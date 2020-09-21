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
    private static int oZE = 0;
    private static int oZF = 0;
    private static int oZG = 0;

    /* loaded from: classes6.dex */
    public interface a {
        void jm(boolean z);
    }

    public static void bu(View view) {
        if (view != null) {
            view.requestFocus();
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }
    }

    public static void dV(View view) {
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
        oZE = i;
        tv.chushou.zues.utils.e.l("KeyBordUtil", "%s%s", "save keyboard:", Integer.valueOf(i));
        return b.L(context, i);
    }

    public static int ed(Context context) {
        if (oZE == 0) {
            oZE = b.M(context, c(context.getResources()));
        }
        return oZE;
    }

    public static int ee(Context context) {
        return Math.min(b(context.getResources()), Math.max(c(context.getResources()), ed(context)));
    }

    public static int b(Resources resources) {
        if (oZF == 0) {
            oZF = resources.getDimensionPixelSize(b.c.zues_keyboard_pannel_max_height);
        }
        return oZF;
    }

    public static int c(Resources resources) {
        if (oZG == 0) {
            oZG = resources.getDimensionPixelSize(b.c.zues_keyboard_pannel_min_height);
        }
        return oZG;
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
        tv.chushou.zues.widget.kpswitch.b.a.oZv = null;
    }
}
