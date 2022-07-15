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
/* renamed from: com.kuaishou.weapon.p0.ʻᵔ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0312 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0312() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m209(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                int intExtra = m212(context).getIntExtra("plugged", -1);
                return intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "" : "Wireless charger" : "USB charger" : "AC charger";
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static int m210(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            int i = -1;
            try {
                int intExtra = m212(context).getIntExtra("health", -1);
                i = 3;
                if (intExtra != 2) {
                    if (intExtra != 3) {
                        if (intExtra != 4) {
                            if (intExtra != 5) {
                                return intExtra != 7 ? 6 : 1;
                            }
                            return 5;
                        }
                        return 2;
                    }
                    return 4;
                }
            } catch (Throwable unused) {
            }
            return i;
        }
        return invokeL.intValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m211(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                Intent m212 = m212(context);
                int intExtra = m212 != null ? (int) ((m212.getIntExtra("level", -1) / m212.getIntExtra("scale", -1)) * 100.0f) : 0;
                return intExtra + "%";
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public static Intent m212(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) : (Intent) invokeL.objValue;
    }
}
