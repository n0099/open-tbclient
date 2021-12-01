package com.kwad.sdk.core.videocache.b;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.videocache.f;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static f a;
    public transient /* synthetic */ FieldHolder $fh;

    public static f a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            f fVar = a;
            if (fVar == null) {
                f b2 = b(context);
                a = b2;
                return b2;
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    public static f b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? new f.a(context).a(104857600L).a() : (f) invokeL.objValue;
    }
}
