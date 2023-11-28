package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static d b(Context context, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String str;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            try {
                if (!b.isWifiConnected(context)) {
                    return new d("", false, "");
                }
                String dT = b.dT(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway);
                if (z) {
                    str = "";
                } else {
                    str = a.gH("timeout 5 ip neigh show " + dT);
                }
                if (z || TextUtils.isEmpty(str)) {
                    str = KwaiIpNeigh.i(dT, false);
                }
                String gJ = b.gJ(str);
                if (!TextUtils.isEmpty(gJ)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                return new d(gJ, z3, str);
            } catch (Throwable th) {
                return new d("", false, th.getMessage());
            }
        }
        return (d) invokeCommon.objValue;
    }

    public static d dx(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return y(context, false);
        }
        return (d) invokeL.objValue;
    }

    public static d y(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, context, z)) == null) {
            return b(context, false, false);
        }
        return (d) invokeLZ.objValue;
    }
}
