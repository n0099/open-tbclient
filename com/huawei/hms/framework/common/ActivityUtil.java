package com.huawei.hms.framework.common;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class ActivityUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ActivityUtil";
    public transient /* synthetic */ FieldHolder $fh;

    public ActivityUtil() {
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

    public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i), intentArr, Integer.valueOf(i2)})) == null) {
            if (context == null) {
                Logger.w(TAG, "context is null");
                return null;
            }
            try {
                return PendingIntent.getActivities(context, i, intentArr, i2);
            } catch (RuntimeException e) {
                Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
                return null;
            }
        }
        return (PendingIntent) invokeCommon.objValue;
    }

    public static boolean isForeground(Context context) {
        InterceptResult invokeL;
        ActivityManager activityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context != null && (activityManager = (ActivityManager) ContextCompat.getSystemService(context, "activity")) != null) {
                List<ActivityManager.RunningAppProcessInfo> list = null;
                try {
                    list = activityManager.getRunningAppProcesses();
                } catch (RuntimeException e) {
                    Logger.w(TAG, "activityManager getRunningAppProcesses occur exception: ", e);
                }
                if (list != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                        String str = runningAppProcessInfo.processName;
                        if (str != null && str.equals(context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                            Logger.v(TAG, "isForeground true");
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
