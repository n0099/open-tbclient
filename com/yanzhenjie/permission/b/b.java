package com.yanzhenjie.permission.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public abstract class b {
    public abstract Context getContext();

    public final boolean Ri(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        PackageManager packageManager = getContext().getPackageManager();
        try {
            Method method = packageManager.getClass().getMethod("shouldShowRequestPermissionRationale", String.class);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return ((Boolean) method.invoke(packageManager, str)).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }
}
