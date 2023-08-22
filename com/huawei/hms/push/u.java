package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.aaid.utils.PushPreferences;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes10.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (new PushPreferences(context, "push_notify_flag").getBoolean("notify_msg_enable")) {
                return false;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return b(context);
            }
            if (i >= 19) {
                return b(context);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"NewApi", "InlinedApi"})
    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                if (((Integer) cls.getMethod(NotificationManagerCompat.CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(NotificationManagerCompat.OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0) {
                    return true;
                }
                return false;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
