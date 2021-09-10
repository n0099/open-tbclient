package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final class L1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            String j2 = U1.j(context);
            if (TextUtils.isEmpty(j2)) {
                try {
                    J1 a2 = K1.a(context);
                    String str = a2 == null ? null : a2.f76806a;
                    if (TextUtils.isEmpty(str)) {
                        U1.f(context, str);
                    }
                    return str;
                } catch (Exception unused) {
                    return null;
                }
            }
            return j2;
        }
        return (String) invokeL.objValue;
    }
}
