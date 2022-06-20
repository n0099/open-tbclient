package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zm5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ym5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ym5 a() {
        InterceptResult invokeV;
        ym5 ym5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zm5.class) {
                if (a == null) {
                    a = new ym5();
                }
                ym5Var = a;
            }
            return ym5Var;
        }
        return (ym5) invokeV.objValue;
    }
}
