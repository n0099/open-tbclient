package d.a.l0.a.v2;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.util.android.ActivityUtils;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49079a = d.a.l0.a.k.f46875a;

    public static void a(Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(1024);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility() & (~c());
        if (d.a.l0.a.z1.b.a.f49714b) {
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

    public static boolean d(Activity activity) {
        return (activity == null || activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }

    public static void e(Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return;
        }
        Window window = activity.getWindow();
        window.setFlags(1024, 1024);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | c());
    }

    public static void f(Activity activity, Intent intent) {
        h(activity, intent, true);
    }

    public static boolean g(Context context, Intent intent) {
        return h(context, intent, false);
    }

    public static boolean h(Context context, Intent intent, boolean z) {
        return i(context, intent, z, true);
    }

    public static boolean i(Context context, Intent intent, boolean z, boolean z2) {
        if (z || !(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            if (z2) {
                Toast.makeText(context, d.a.l0.a.h.swan_app_activity_not_found, 0).show();
                return false;
            }
            return false;
        } catch (SecurityException e2) {
            if (z2) {
                Toast.makeText(context, d.a.l0.a.h.swan_app_activity_not_found, 0).show();
            }
            if (f49079a) {
                Log.e(ActivityUtils.TAG, "Launcher does not have the permission to launch " + intent + ". Make sure to create a MAIN intent-filter for the corresponding activity or use the exported attribute for this activity.", e2);
                return false;
            }
            return false;
        }
    }

    public static void j(Activity activity) {
        if (f49079a) {
            Log.i(ActivityUtils.TAG, "tryFinishAndRemoveTask: " + activity);
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
