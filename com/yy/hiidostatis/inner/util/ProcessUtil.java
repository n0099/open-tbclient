package com.yy.hiidostatis.inner.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.List;
/* loaded from: classes3.dex */
public final class ProcessUtil {
    public static /* synthetic */ Interceptable $ic;
    public static String mCurProcessName;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(512198987, "Lcom/yy/hiidostatis/inner/util/ProcessUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(512198987, "Lcom/yy/hiidostatis/inner/util/ProcessUtil;");
        }
    }

    public ProcessUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getCurProcessName(Context context) {
        InterceptResult invokeL;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String str = mCurProcessName;
            if (str != null) {
                return str;
            }
            if (context == null) {
                return null;
            }
            try {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == myPid) {
                            String str2 = runningAppProcessInfo.processName;
                            mCurProcessName = str2;
                            return str2;
                        }
                    }
                }
            } catch (Throwable th) {
                L.debug("ProcessUtil", "getCurProcessName exceptioon: %s", th);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getFileNameBindProcess(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            try {
                return !isMainProcess(context) ? String.format("%s_%s", str, Integer.valueOf(Coder.encryptMD5(getCurProcessName(context)).hashCode())) : str;
            } catch (Throwable th) {
                L.debug("ProcessUtil", "fileName[%s] instead of it,exception on getFileNameBindProcess: %s ", str, th);
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isBackground(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                String packageName = context.getPackageName();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(packageName)) {
                        return runningAppProcessInfo.importance == 400;
                    }
                }
                return false;
            } catch (Throwable th) {
                L.debug("ProcessUtil", "isBackground exceptioon: %s", th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isMainProcess(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (context == null) {
                return false;
            }
            try {
                return context.getApplicationInfo().processName.equals(getCurProcessName(context));
            } catch (Throwable th) {
                L.debug("ProcessUtil", "isMainProcess exceptioon: %s", th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
