package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class j1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            String i2 = s1.i(context);
            if (TextUtils.isEmpty(i2)) {
                try {
                    h1 a2 = i1.a(context);
                    String str = a2 == null ? null : a2.f39592a;
                    if (TextUtils.isEmpty(str)) {
                        s1.f(context, str);
                    }
                    return str;
                } catch (Exception unused) {
                    return null;
                }
            }
            return i2;
        }
        return (String) invokeL.objValue;
    }
}
