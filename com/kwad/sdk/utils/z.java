package com.kwad.sdk.utils;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> T a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, t)) == null) {
            if (t == null) {
                com.kwad.sdk.core.d.a.a(new NullPointerException());
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public static <T> T a(T t, @Nullable Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, obj)) == null) {
            if (t == null) {
                com.kwad.sdk.core.d.a.a(new NullPointerException(String.valueOf(obj)));
            }
            return t;
        }
        return (T) invokeLL.objValue;
    }
}
