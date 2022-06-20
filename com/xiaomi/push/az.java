package com.xiaomi.push;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class az {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    public static au a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (m.m555a()) {
                a = 1;
                return new ay(context);
            } else if (as.a(context)) {
                a = 2;
                return new as(context);
            } else if (bb.a(context)) {
                a = 4;
                return new bb(context);
            } else if (bf.a(context)) {
                a = 5;
                return new bf(context);
            } else if (ax.a(context)) {
                a = 3;
                return new av(context);
            } else {
                a = 0;
                return new be();
            }
        }
        return (au) invokeL.objValue;
    }
}
