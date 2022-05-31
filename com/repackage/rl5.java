package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rl5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ql5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ql5 a() {
        InterceptResult invokeV;
        ql5 ql5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rl5.class) {
                if (a == null) {
                    a = new ql5();
                }
                ql5Var = a;
            }
            return ql5Var;
        }
        return (ql5) invokeV.objValue;
    }
}
