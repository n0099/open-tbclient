package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Utils";
    public transient /* synthetic */ FieldHolder $fh;

    public Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static long getCurrentTime(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            if (z) {
                return SystemClock.elapsedRealtime();
            }
            return System.currentTimeMillis();
        }
        return invokeZ.longValue;
    }

    public static boolean is64Bit(Context context) {
        InterceptResult invokeL;
        Context applicationContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                Logger.e("Utils", "Null context, please check it.");
                return false;
            }
            if (context.getApplicationContext() == null) {
                applicationContext = context;
            } else {
                applicationContext = context.getApplicationContext();
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                return Process.is64Bit();
            }
            if (i < 21) {
                return false;
            }
            try {
                return applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).nativeLibraryDir.contains("64");
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.e("Utils", "Get application info failed: name not found, try to get baseContext.");
                if (!(context instanceof ContextWrapper)) {
                    return false;
                }
                Context baseContext = ((ContextWrapper) context).getBaseContext();
                if (baseContext == null) {
                    Logger.w("Utils", "Get baseContext failed: null. Return default: is64-bit.");
                    return true;
                }
                try {
                    return baseContext.getPackageManager().getApplicationInfo(baseContext.getPackageName(), 128).nativeLibraryDir.contains("64");
                } catch (PackageManager.NameNotFoundException unused2) {
                    Logger.e("Utils", "Get baseContext application info failed: name not found");
                    return true;
                }
            }
        }
        return invokeL.booleanValue;
    }
}
