package com.huawei.hms.framework.common;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ContextCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ContextCompat";
    public transient /* synthetic */ FieldHolder $fh;

    public ContextCompat() {
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

    public static boolean checkSelfPermission(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (context != null && str != null) {
                try {
                    if (context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                        return false;
                    }
                    return true;
                } catch (RuntimeException e) {
                    Logger.e("ContextCompat", "dealType rethrowFromSystemServer:", e);
                    return false;
                }
            }
            Logger.w("ContextCompat", "param is null");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Context getProtectedStorageContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                Logger.w("ContextCompat", "context is null");
                return null;
            } else if (Build.VERSION.SDK_INT < 24) {
                return context;
            } else {
                return context.createDeviceProtectedStorageContext();
            }
        }
        return (Context) invokeL.objValue;
    }

    public static Object getSystemService(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (context == null) {
                Logger.w("ContextCompat", "context is null");
                return null;
            }
            try {
                return context.getSystemService(str);
            } catch (RuntimeException e) {
                Logger.e("ContextCompat", "SystemServer error:", e);
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public static ComponentName startService(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, intent)) == null) {
            if (context == null) {
                Logger.w("ContextCompat", "context is null");
                return null;
            }
            try {
                return context.startService(intent);
            } catch (RuntimeException e) {
                Logger.e("ContextCompat", "SystemServer error:", e);
                return null;
            }
        }
        return (ComponentName) invokeLL.objValue;
    }

    public static void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, broadcastReceiver) == null) {
            if (context == null) {
                Logger.w("ContextCompat", "context is null");
                return;
            }
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (RuntimeException e) {
                Logger.e("ContextCompat", "SystemServer error:", e);
            }
        }
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, broadcastReceiver, intentFilter)) == null) {
            if (context == null) {
                Logger.w("ContextCompat", "context is null");
                return null;
            }
            try {
                return context.registerReceiver(broadcastReceiver, intentFilter);
            } catch (RuntimeException e) {
                Logger.e("ContextCompat", "dealType rethrowFromSystemServer:", e);
                return null;
            }
        }
        return (Intent) invokeLLL.objValue;
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65541, null, context, broadcastReceiver, intentFilter, str, handler)) == null) {
            if (context == null) {
                Logger.w("ContextCompat", "context is null");
                return null;
            }
            try {
                return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
            } catch (RuntimeException e) {
                Logger.e("ContextCompat", "dealType rethrowFromSystemServer:", e);
                return null;
            }
        }
        return (Intent) invokeLLLLL.objValue;
    }
}
