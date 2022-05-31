package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ys0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xs0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xs0 a() {
        InterceptResult invokeV;
        xs0 xs0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ys0.class) {
                if (a == null) {
                    a = new xs0();
                }
                xs0Var = a;
            }
            return xs0Var;
        }
        return (xs0) invokeV.objValue;
    }
}
