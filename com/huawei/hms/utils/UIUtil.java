package com.huawei.hms.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import java.util.List;
/* loaded from: classes10.dex */
public class UIUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UIUtil() {
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

    public static Activity getActiveActivity(Activity activity, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, activity, context)) == null) {
            if (isBackground(context)) {
                HMSLog.i("UIUtil", "isBackground" + isBackground(context));
                return null;
            } else if (activity == null) {
                HMSLog.i("UIUtil", "activity is null");
                return ActivityMgr.INST.getCurrentActivity();
            } else if (activity.isFinishing()) {
                HMSLog.i("UIUtil", "activity isFinishing is " + activity.isFinishing());
                return ActivityMgr.INST.getCurrentActivity();
            } else {
                return activity;
            }
        }
        return (Activity) invokeLL.objValue;
    }

    public static String getProcessName(Context context, int i) {
        InterceptResult invokeLI;
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i)) == null) {
            if (context != null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static boolean isActivityFullscreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
            if ((activity.getWindow().getAttributes().flags & 1024) == 1024) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isBackground(Context context) {
        InterceptResult invokeL;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null) {
                return true;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return true;
            }
            String processName = getProcessName(context, Process.myPid());
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (TextUtils.equals(runningAppProcessInfo.processName, processName)) {
                    HMSLog.i("UIUtil", "appProcess.importance is " + runningAppProcessInfo.importance);
                    if (runningAppProcessInfo.importance == 100) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean isKeyguardLocked = keyguardManager.isKeyguardLocked();
                    HMSLog.i("UIUtil", "isForground is " + z + "***  isLockedState is " + isKeyguardLocked);
                    if (!z || isKeyguardLocked) {
                        return true;
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
