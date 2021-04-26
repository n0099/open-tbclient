package d.a.k0.a.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.multidex.MultiDex;
import com.baidu.turbonet.base.BuildConfig;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes5.dex */
public class a {
    public static String a(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static void b(Context context) {
        if (BuildConfig.isMultidexEnabled()) {
            if (Build.VERSION.SDK_INT < 21 && !c(context)) {
                d.a.k0.a.a.h("base_multidex", "Skipping multidex installation: not needed for process.", new Object[0]);
                return;
            }
            MultiDex.install(context);
            d.a.k0.a.a.h("base_multidex", "Completed multidex installation.", new Object[0]);
        }
    }

    public static boolean c(Context context) {
        try {
            Object invoke = Process.class.getMethod("isIsolated", new Class[0]).invoke(null, new Object[0]);
            if (invoke != null && (invoke instanceof Boolean)) {
                if (((Boolean) invoke).booleanValue()) {
                    return false;
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
        }
        String a2 = a(context);
        if (a2 == null) {
            return true;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                Bundle bundle = applicationInfo.metaData;
                return !bundle.getBoolean(a2 + ".ignore_multidex", false);
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return true;
    }
}
