package com.kuaishou.weapon.p0;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʼˈ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0325 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0325() {
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
    public static String m234(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return C0453.f695;
                }
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                return TextUtils.isEmpty(networkCountryIso) ? C0453.f697 : networkCountryIso;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m235(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return C0453.f695;
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                return TextUtils.isEmpty(networkOperator) ? C0453.f697 : networkOperator;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m236(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return C0453.f695;
                }
                String simOperator = telephonyManager.getSimOperator();
                return TextUtils.isEmpty(simOperator) ? C0453.f697 : simOperator;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeL.objValue;
    }
}
