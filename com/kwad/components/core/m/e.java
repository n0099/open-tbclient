package com.kwad.components.core.m;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.q;
/* loaded from: classes10.dex */
public final class e {
    public static void a(@NonNull Activity activity, int i, boolean z) {
        a(activity, 0, true, true);
    }

    public static void a(@NonNull Activity activity, int i, boolean z, boolean z2) {
        if (oB()) {
            b(activity, i, z);
        }
    }

    public static boolean a(@NonNull Activity activity, boolean z) {
        try {
            int intValue = ((Integer) q.N("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE")).intValue();
            q.a((Object) activity.getWindow(), "setExtraFlags", Integer.valueOf(intValue), Integer.valueOf(intValue));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void b(@NonNull Activity activity, int i, boolean z) {
        Window window = activity.getWindow();
        int i2 = Build.VERSION.SDK_INT;
        int i3 = 1280;
        if (i2 < 21) {
            if (i2 >= 19) {
                window.getDecorView().setSystemUiVisibility(1280);
                return;
            }
            return;
        }
        if (z && i2 >= 23) {
            i3 = 9472;
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            if (ap.zQ()) {
                a(activity, true);
            } else if (ap.zR()) {
                k.b(activity, true);
            }
        }
        window.getDecorView().setSystemUiVisibility(i3);
        window.setStatusBarColor(i);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    public static boolean oB() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
