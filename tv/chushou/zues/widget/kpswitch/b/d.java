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
    private static int obA = 0;
    private static int obB = 0;
    private static int obC = 0;

    /* loaded from: classes5.dex */
    public interface a {
        void wr(boolean z);
    }

    public static void dL(View view) {
        if (view != null) {
            view.requestFocus();
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }
    }

    public static void dM(View view) {
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

    public static boolean N(Context context, int i) {
        if (i < 0) {
            return false;
        }
        obA = i;
        tv.chushou.zues.utils.e.k("KeyBordUtil", "%s%s", "save keyboard:", Integer.valueOf(i));
        return b.j(context, i);
    }

    public static int hn(Context context) {
        if (obA == 0) {
            obA = b.k(context, a(context.getResources()));
        }
        return obA;
    }

    public static int bk(Context context) {
        return Math.min(b(context.getResources()), Math.max(a(context.getResources()), hn(context)));
    }

    public static int b(Resources resources) {
        if (obB == 0) {
            obB = resources.getDimensionPixelSize(b.c.zues_keyboard_pannel_max_height);
        }
        return obB;
    }

    public static int a(Resources resources) {
        if (obC == 0) {
            obC = resources.getDimensionPixelSize(b.c.zues_keyboard_pannel_min_height);
        }
        return obC;
    }

    public static c a(Activity activity, tv.chushou.zues.widget.kpswitch.b bVar, a aVar, boolean z) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        c cVar = new c(e.isFullScreen(activity), z, e.F(activity), viewGroup, bVar, aVar);
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
        tv.chushou.zues.widget.kpswitch.b.a.obo = null;
    }
}
