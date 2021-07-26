package com.bytedance.sdk.openadsdk.q;

import android.content.Context;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class j implements com.bytedance.sdk.component.utils.o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean b(Context context, TelephonyManager telephonyManager) {
        InterceptResult invokeLL;
        ServiceState serviceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, telephonyManager)) == null) {
            if (context != null && Build.VERSION.SDK_INT >= 29 && context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                try {
                    int a2 = a();
                    if (a2 == -1) {
                        serviceState = telephonyManager.getServiceState();
                    } else {
                        Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                        declaredMethod.setAccessible(true);
                        serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(a2));
                    }
                    return a(serviceState);
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.bytedance.sdk.component.utils.o
    public boolean a(Context context, TelephonyManager telephonyManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, telephonyManager)) == null) ? b(context, telephonyManager) : invokeLL.booleanValue;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return SubscriptionManager.getDefaultDataSubscriptionId();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public static boolean a(ServiceState serviceState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, serviceState)) == null) {
            try {
                Method method = serviceState.getClass().getMethod("getNrState", new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    int intValue = ((Integer) method.invoke(serviceState, new Object[0])).intValue();
                    return intValue == 3 || intValue == 2;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
