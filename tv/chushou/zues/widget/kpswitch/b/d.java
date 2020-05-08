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
/* loaded from: classes5.dex */
public class d {
    private static int nvB = 0;
    private static int nvC = 0;
    private static int nvD = 0;

    /* loaded from: classes5.dex */
    public interface a {
        void wc(boolean z);
    }

    public static void dC(View view) {
        if (view != null) {
            view.requestFocus();
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }
    }

    public static void dD(View view) {
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

    public static boolean I(Context context, int i) {
        if (i < 0) {
            return false;
        }
        nvB = i;
        tv.chushou.zues.utils.e.m("KeyBordUtil", "%s%s", "save keyboard:", Integer.valueOf(i));
        return b.G(context, i);
    }

    public static int gh(Context context) {
        if (nvB == 0) {
            nvB = b.H(context, d(context.getResources()));
        }
        return nvB;
    }

    public static int gi(Context context) {
        return Math.min(c(context.getResources()), Math.max(d(context.getResources()), gh(context)));
    }

    public static int c(Resources resources) {
        if (nvC == 0) {
            nvC = resources.getDimensionPixelSize(b.c.zues_keyboard_pannel_max_height);
        }
        return nvC;
    }

    public static int d(Resources resources) {
        if (nvD == 0) {
            nvD = resources.getDimensionPixelSize(b.c.zues_keyboard_pannel_min_height);
        }
        return nvD;
    }

    public static c a(Activity activity, tv.chushou.zues.widget.kpswitch.b bVar, a aVar, boolean z) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        c cVar = new c(e.isFullScreen(activity), z, e.aE(activity), viewGroup, bVar, aVar);
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
        tv.chushou.zues.widget.kpswitch.b.a.nvm = null;
    }
}
