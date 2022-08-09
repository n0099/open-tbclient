package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile op5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized op5 a() {
        InterceptResult invokeV;
        op5 op5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pp5.class) {
                if (a == null) {
                    a = new op5();
                }
                op5Var = a;
            }
            return op5Var;
        }
        return (op5) invokeV.objValue;
    }
}
