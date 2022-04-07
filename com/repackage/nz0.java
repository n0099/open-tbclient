package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> int a(T[] tArr, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tArr, t)) == null) {
            if (tArr == null) {
                return -1;
            }
            int length = tArr.length;
            for (int i = 0; i < length; i++) {
                if (tArr[i] == t) {
                    return i;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }
}
