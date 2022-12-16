package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class hi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? !com.xiaomi.push.service.ca.f988a.isEmpty() && bj.e(context) && j.m548b(context) : invokeL.booleanValue;
    }

    public static boolean a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i)) == null) {
            if (context != null && i > 0) {
                String m691a = com.xiaomi.push.service.u.m691a(context);
                if (!TextUtils.isEmpty(m691a)) {
                    for (int i2 = 1; i2 <= i; i2++) {
                        if (g.a(10) == w.a(m691a.substring(m691a.length() - 1, m691a.length()), -1)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }
}
