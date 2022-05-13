package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ue8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile te8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized te8 a() {
        InterceptResult invokeV;
        te8 te8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ue8.class) {
                if (a == null) {
                    a = new te8();
                }
                te8Var = a;
            }
            return te8Var;
        }
        return (te8) invokeV.objValue;
    }
}
