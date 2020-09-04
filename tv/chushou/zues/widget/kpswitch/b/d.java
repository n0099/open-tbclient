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
    private static int oQp = 0;
    private static int oQq = 0;
    private static int oQr = 0;

    /* loaded from: classes6.dex */
    public interface a {
        void yw(boolean z);
    }

    public static void dM(View view) {
        if (view != null) {
            view.requestFocus();
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }
    }

    public static void dN(View view) {
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

    public static boolean K(Context context, int i) {
        if (i < 0) {
            return false;
        }
        oQp = i;
        tv.chushou.zues.utils.e.l("KeyBordUtil", "%s%s", "save keyboard:", Integer.valueOf(i));
        return b.I(context, i);
    }

    public static int hi(Context context) {
        if (oQp == 0) {
            oQp = b.J(context, d(context.getResources()));
        }
        return oQp;
    }

    public static int hj(Context context) {
        return Math.min(c(context.getResources()), Math.max(d(context.getResources()), hi(context)));
    }

    public static int c(Resources resources) {
        if (oQq == 0) {
            oQq = resources.getDimensionPixelSize(b.c.zues_keyboard_pannel_max_height);
        }
        return oQq;
    }

    public static int d(Resources resources) {
        if (oQr == 0) {
            oQr = resources.getDimensionPixelSize(b.c.zues_keyboard_pannel_min_height);
        }
        return oQr;
    }

    public static c a(Activity activity, tv.chushou.zues.widget.kpswitch.b bVar, a aVar, boolean z) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        c cVar = new c(e.isFullScreen(activity), z, e.aF(activity), viewGroup, bVar, aVar);
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
        tv.chushou.zues.widget.kpswitch.b.a.oQa = null;
    }
}
