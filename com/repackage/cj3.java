package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cj3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bj3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bj3 a() {
        InterceptResult invokeV;
        bj3 bj3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cj3.class) {
                if (a == null) {
                    a = new bj3();
                }
                bj3Var = a;
            }
            return bj3Var;
        }
        return (bj3) invokeV.objValue;
    }
}
