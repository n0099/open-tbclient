package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
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
        } catch (Exception e2) {
            e2.printStackTrace();
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
            window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window.addFlags(Integer.MIN_VALUE);
            if (ac.a()) {
                a(activity, true);
            } else if (ac.b()) {
                u.a(activity, true);
            }
        }
        window.getDecorView().setSystemUiVisibility(i3);
        window.setStatusBarColor(i);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }
}
