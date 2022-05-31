package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rs0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qs0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qs0 a() {
        InterceptResult invokeV;
        qs0 qs0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rs0.class) {
                if (a == null) {
                    a = new qs0();
                }
                qs0Var = a;
            }
            return qs0Var;
        }
        return (qs0) invokeV.objValue;
    }
}
