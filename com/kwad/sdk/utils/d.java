package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class d {
    public static void a(@NonNull Activity activity, int i, boolean z) {
        a(activity, i, z, true);
    }

    public static void a(@NonNull Activity activity, int i, boolean z, boolean z2) {
        if (a()) {
            b(activity, i, z);
            if (z2) {
                return;
            }
            activity.findViewById(16908290).setPadding(0, ao.a((Context) activity), 0, 0);
        }
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean a(@NonNull Activity activity) {
        return a() && (activity.getWindow().getDecorView().getSystemUiVisibility() & 1280) == 1280 && !ao.a(activity);
    }

    public static boolean a(@NonNull Activity activity, boolean z) {
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void b(@NonNull Activity activity, int i, boolean z) {
        int i2 = 1280;
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT < 21) {
            if (Build.VERSION.SDK_INT >= 19) {
                window.getDecorView().setSystemUiVisibility(1280);
                return;
            }
            return;
        }
        if (z && Build.VERSION.SDK_INT >= 23) {
            i2 = 9472;
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            if (ac.a()) {
                a(activity, true);
            } else if (ac.b()) {
                u.a(activity, true);
            }
        }
        window.getDecorView().setSystemUiVisibility(i2);
        window.setStatusBarColor(i);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }
}
