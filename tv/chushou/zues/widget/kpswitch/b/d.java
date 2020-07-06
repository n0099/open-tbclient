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
    private static int onz = 0;
    private static int onA = 0;
    private static int onB = 0;

    /* loaded from: classes5.dex */
    public interface a {
        void wY(boolean z);
    }

    public static void dE(View view) {
        if (view != null) {
            view.requestFocus();
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }
    }

    public static void dF(View view) {
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
        onz = i;
        tv.chushou.zues.utils.e.m("KeyBordUtil", "%s%s", "save keyboard:", Integer.valueOf(i));
        return b.G(context, i);
    }

    public static int gJ(Context context) {
        if (onz == 0) {
            onz = b.H(context, d(context.getResources()));
        }
        return onz;
    }

    public static int gK(Context context) {
        return Math.min(c(context.getResources()), Math.max(d(context.getResources()), gJ(context)));
    }

    public static int c(Resources resources) {
        if (onA == 0) {
            onA = resources.getDimensionPixelSize(b.c.zues_keyboard_pannel_max_height);
        }
        return onA;
    }

    public static int d(Resources resources) {
        if (onB == 0) {
            onB = resources.getDimensionPixelSize(b.c.zues_keyboard_pannel_min_height);
        }
        return onB;
    }

    public static c a(Activity activity, tv.chushou.zues.widget.kpswitch.b bVar, a aVar, boolean z) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        c cVar = new c(e.isFullScreen(activity), z, e.aD(activity), viewGroup, bVar, aVar);
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
        tv.chushou.zues.widget.kpswitch.b.a.onk = null;
    }
}
