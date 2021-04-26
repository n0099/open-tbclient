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
    public static void a(@NonNull Activity activity, int i2, boolean z) {
        a(activity, i2, z, true);
    }

    public static void a(@NonNull Activity activity, int i2, boolean z, boolean z2) {
        if (a()) {
            b(activity, i2, z);
            if (z2) {
                return;
            }
            activity.findViewById(16908290).setPadding(0, an.a((Context) activity), 0, 0);
        }
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean a(@NonNull Activity activity, boolean z) {
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i2 : 0);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window, objArr);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void b(@NonNull Activity activity, int i2, boolean z) {
        Window window = activity.getWindow();
        int i3 = Build.VERSION.SDK_INT;
        int i4 = 1280;
        if (i3 < 21) {
            if (i3 >= 19) {
                window.getDecorView().setSystemUiVisibility(1280);
                return;
            }
            return;
        }
        if (z && i3 >= 23) {
            i4 = 9472;
            window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window.addFlags(Integer.MIN_VALUE);
            if (ac.a()) {
                a(activity, true);
            } else if (ac.b()) {
                s.a(activity, true);
            }
        }
        window.getDecorView().setSystemUiVisibility(i4);
        window.setStatusBarColor(i2);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }
}
