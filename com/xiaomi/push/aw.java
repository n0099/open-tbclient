package com.xiaomi.push;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class aw {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    public static ar a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (av.m194a(context)) {
                a = 1;
                return new av(context);
            } else if (ap.m190a(context)) {
                a = 2;
                return new ap(context);
            } else if (ay.a(context)) {
                a = 4;
                return new ay(context);
            } else if (bc.a(context)) {
                a = 5;
                return new bc(context);
            } else if (au.a(context)) {
                a = 3;
                return new as(context);
            } else {
                a = 0;
                return new bb();
            }
        }
        return (ar) invokeL.objValue;
    }
}
