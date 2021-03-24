package d.b.g0.a.i2;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44681a = d.b.g0.a.k.f45050a;

    public static void a(Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(1024);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility() & (c() ^ (-1));
        if (d.b.g0.a.q1.b.a.f45538b) {
            systemUiVisibility |= 5120;
        }
        window.getDecorView().setSystemUiVisibility(systemUiVisibility);
    }

    public static void b(Activity activity, Dialog dialog) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null || dialog == null || dialog.getWindow() == null || dialog.getWindow().getDecorView() == null) {
            return;
        }
        dialog.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
    }

    public static int c() {
        return 5894;
    }

    public static void d(Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return;
        }
        Window window = activity.getWindow();
        window.setFlags(1024, 1024);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | c());
    }

    public static void e(Activity activity, Intent intent) {
        g(activity, intent, true);
    }

    public static boolean f(Context context, Intent intent) {
        return g(context, intent, false);
    }

    public static boolean g(Context context, Intent intent, boolean z) {
        return h(context, intent, z, true);
    }

    public static boolean h(Context context, Intent intent, boolean z, boolean z2) {
        if (z || !(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            if (z2) {
                Toast.makeText(context, d.b.g0.a.h.activity_not_found, 0).show();
                return false;
            }
            return false;
        } catch (SecurityException e2) {
            if (z2) {
                Toast.makeText(context, d.b.g0.a.h.activity_not_found, 0).show();
            }
            if (f44681a) {
                Log.e("ActivityUtils", "Launcher does not have the permission to launch " + intent + ". Make sure to create a MAIN intent-filter for the corresponding activity or use the exported attribute for this activity.", e2);
                return false;
            }
            return false;
        }
    }

    public static void i(Activity activity) {
        if (f44681a) {
            Log.i("ActivityUtils", "tryFinishAndRemoveTask: " + activity);
        }
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAndRemoveTask();
        } else {
            activity.finish();
        }
    }
}
