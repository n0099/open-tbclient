package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ql3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ql3 a() {
        InterceptResult invokeV;
        ql3 ql3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rl3.class) {
                if (a == null) {
                    a = new ql3();
                }
                ql3Var = a;
            }
            return ql3Var;
        }
        return (ql3) invokeV.objValue;
    }
}
