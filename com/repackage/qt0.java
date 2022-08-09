package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qt0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pt0 a() {
        InterceptResult invokeV;
        pt0 pt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qt0.class) {
                if (a == null) {
                    a = new pt0();
                }
                pt0Var = a;
            }
            return pt0Var;
        }
        return (pt0) invokeV.objValue;
    }
}
