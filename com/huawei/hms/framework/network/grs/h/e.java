package com.huawei.hms.framework.network.grs.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.common.Logger;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "e";
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, l)) == null) {
            if (l == null) {
                Logger.v(a, "Method isTimeExpire input param expireTime is null.");
                return true;
            }
            try {
            } catch (NumberFormatException unused) {
                Logger.v(a, "isSpExpire spValue NumberFormatException.");
            }
            if (l.longValue() - System.currentTimeMillis() >= 0) {
                Logger.i(a, "isSpExpire false.");
                return false;
            }
            Logger.i(a, "isSpExpire true.");
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Long l, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, l, j)) == null) {
            if (l == null) {
                Logger.v(a, "Method isTimeWillExpire input param expireTime is null.");
                return true;
            }
            try {
                if (l.longValue() - (System.currentTimeMillis() + j) >= 0) {
                    Logger.v(a, "isSpExpire false.");
                    return false;
                }
            } catch (NumberFormatException unused) {
                Logger.v(a, "isSpExpire spValue NumberFormatException.");
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }
}
