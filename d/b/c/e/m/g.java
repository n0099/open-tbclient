package d.b.c.e.m;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
public class g {
    public static final boolean a(Dialog dialog, Activity activity) {
        if (dialog == null || activity == null || activity.isFinishing() || activity.getWindow() == null || !h(activity.getWindow().getDecorView())) {
            return false;
        }
        dialog.dismiss();
        return true;
    }

    public static final boolean b(Dialog dialog, d.b.c.a.f<?> fVar) {
        if (fVar == null || fVar.getPageActivity() == null) {
            return false;
        }
        return a(dialog, fVar.getPageActivity());
    }

    public static final boolean c(PopupWindow popupWindow) {
        if (popupWindow == null || g(popupWindow.getContentView().getContext()) || !h(popupWindow.getContentView())) {
            return false;
        }
        popupWindow.dismiss();
        return true;
    }

    public static final boolean d(PopupWindow popupWindow, Activity activity) {
        if (popupWindow != null && activity != null) {
            if (!g(activity) && h(activity.getWindow().getDecorView())) {
                popupWindow.dismiss();
                return true;
            }
            return false;
        }
        return c(popupWindow);
    }

    public static final boolean e(Activity activity) {
        if (activity == null || g(activity)) {
            return false;
        }
        return h(activity.getWindow().getDecorView()) || !activity.getWindow().isActive();
    }

    public static final boolean f(d.b.c.a.f<?> fVar) {
        if (fVar == null) {
            return false;
        }
        return e(fVar.getPageActivity());
    }

    public static final boolean g(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isFinishing();
        }
        return true;
    }

    public static final boolean h(View view) {
        IBinder windowToken;
        if (view == null || (windowToken = view.getWindowToken()) == null) {
            return false;
        }
        try {
            if (windowToken.isBinderAlive()) {
                return windowToken.pingBinder();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final boolean i(Dialog dialog, Activity activity) {
        if (dialog == null || activity == null || activity.isFinishing()) {
            return false;
        }
        if (activity.getWindow() != null && !activity.getWindow().isActive()) {
            try {
                dialog.show();
                return true;
            } catch (Exception unused) {
            }
        }
        if (activity.getWindow() != null && h(activity.getWindow().getDecorView())) {
            try {
                dialog.show();
                return true;
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    public static final boolean j(Dialog dialog, d.b.c.a.f<?> fVar) {
        if (fVar == null || fVar.getPageActivity() == null) {
            return false;
        }
        return i(dialog, fVar.getPageActivity());
    }

    public static final boolean k(PopupWindow popupWindow, View view) {
        if (popupWindow != null && view != null && !g(view.getContext()) && h(view)) {
            try {
                popupWindow.showAsDropDown(view);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static final boolean l(PopupWindow popupWindow, View view, int i, int i2) {
        if (popupWindow != null && view != null && !g(view.getContext()) && h(view)) {
            try {
                popupWindow.showAsDropDown(view, i, i2);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static final boolean m(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (popupWindow != null && view != null && !g(view.getContext()) && h(view)) {
            try {
                popupWindow.showAtLocation(view, i, i2, i3);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
