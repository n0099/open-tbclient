package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class ip9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            String D = hq9.D(context);
            if (TextUtils.isEmpty(D)) {
                try {
                    wo9 a = zo9.a(context);
                    String str = a == null ? null : a.a;
                    if (TextUtils.isEmpty(str)) {
                        hq9.x(context, str);
                    }
                    return str;
                } catch (Exception unused) {
                    return null;
                }
            }
            return D;
        }
        return (String) invokeL.objValue;
    }
}
