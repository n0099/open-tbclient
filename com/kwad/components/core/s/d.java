package com.kwad.components.core.s;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.s;
/* loaded from: classes10.dex */
public final class d {
    public static void a(@NonNull Activity activity, int i, boolean z) {
        a(activity, 0, true, true);
    }

    public static void a(@NonNull Activity activity, int i, boolean z, boolean z2) {
        if (!qP()) {
            return;
        }
        b(activity, i, z);
        if (!z2) {
            activity.findViewById(16908290).setPadding(0, com.kwad.sdk.d.a.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    public static boolean a(@NonNull Activity activity, boolean z) {
        try {
            int intValue = ((Integer) s.ao("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE")).intValue();
            s.callMethod(activity.getWindow(), "setExtraFlags", Integer.valueOf(intValue), Integer.valueOf(intValue));
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
        if (i2 >= 21) {
            if (z && i2 >= 23) {
                i3 = 9472;
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                if (at.KC()) {
                    a(activity, true);
                } else if (at.KD()) {
                    k.b(activity, true);
                }
            }
            window.getDecorView().setSystemUiVisibility(i3);
            window.setStatusBarColor(i);
            window.setNavigationBarColor(window.getNavigationBarColor());
        } else if (i2 >= 19) {
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    public static boolean qP() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }
}
