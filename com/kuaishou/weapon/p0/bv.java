package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class bv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bv() {
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

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            int i = 0;
            try {
                Intent d = d(context);
                if (d != null) {
                    i = (int) ((d.getIntExtra("level", -1) / d.getIntExtra("scale", -1)) * 100.0f);
                }
                return i + "%";
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                int intExtra = d(context).getIntExtra("plugged", -1);
                if (intExtra != 1) {
                    if (intExtra != 2) {
                        if (intExtra != 4) {
                            return "";
                        }
                        return "Wireless charger";
                    }
                    return "USB charger";
                }
                return "AC charger";
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            int i = -1;
            try {
                int intExtra = d(context).getIntExtra("health", -1);
                i = 3;
                if (intExtra != 2) {
                    if (intExtra == 3) {
                        return 4;
                    }
                    if (intExtra == 4) {
                        return 2;
                    }
                    if (intExtra == 5) {
                        return 5;
                    }
                    if (intExtra != 7) {
                        return 6;
                    }
                    return 1;
                }
            } catch (Throwable unused) {
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static Intent d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
        return (Intent) invokeL.objValue;
    }
}
