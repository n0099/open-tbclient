package com.repackage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.multidex.MultiDex;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.turbonet.base.BuildConfig;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes6.dex */
public class k39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, context) == null) && BuildConfig.isMultidexEnabled()) {
            if (Build.VERSION.SDK_INT < 21 && !c(context)) {
                i39.h("base_multidex", "Skipping multidex installation: not needed for process.", new Object[0]);
                return;
            }
            MultiDex.install(context);
            i39.h("base_multidex", "Completed multidex installation.", new Object[0]);
        }
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                Object invoke = Process.class.getMethod("isIsolated", new Class[0]).invoke(null, new Object[0]);
                if (invoke != null && (invoke instanceof Boolean)) {
                    if (((Boolean) invoke).booleanValue()) {
                        return false;
                    }
                }
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            }
            String a = a(context);
            if (a == null) {
                return true;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    Bundle bundle = applicationInfo.metaData;
                    return !bundle.getBoolean(a + ".ignore_multidex", false);
                }
            } catch (PackageManager.NameNotFoundException unused2) {
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
