package com.xiaomi.mipush.sdk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.de;
import com.xiaomi.push.df;
import java.io.File;
/* loaded from: classes7.dex */
public class Logger {
    public static /* synthetic */ Interceptable $ic;
    public static boolean sDisablePushLog;
    public static LoggerInterface sUserLogger;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1533410263, "Lcom/xiaomi/mipush/sdk/Logger;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1533410263, "Lcom/xiaomi/mipush/sdk/Logger;");
        }
    }

    public Logger() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void disablePushFileLog(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            sDisablePushLog = true;
            setPushLog(context);
        }
    }

    public static void enablePushFileLog(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            sDisablePushLog = false;
            setPushLog(context);
        }
    }

    @Deprecated
    public static File getLogFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static LoggerInterface getUserLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? sUserLogger : (LoggerInterface) invokeV.objValue;
    }

    public static boolean hasWritePermission(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    for (String str : strArr) {
                        if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, loggerInterface) == null) {
            sUserLogger = loggerInterface;
            setPushLog(context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (hasWritePermission(r4) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setPushLog(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            boolean z = true;
            boolean z2 = false;
            boolean z3 = sUserLogger != null;
            if (!sDisablePushLog) {
                z2 = z3;
            }
            z = false;
            com.xiaomi.channel.commonutils.logger.b.a(new de(z2 ? sUserLogger : null, z ? new df(context) : null));
        }
    }

    @Deprecated
    public static void uploadLogFile(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, context, z) == null) {
        }
    }
}
