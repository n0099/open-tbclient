package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ix3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ix3 a() {
        InterceptResult invokeV;
        ix3 ix3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jx3.class) {
                if (a == null) {
                    a = new ix3();
                }
                ix3Var = a;
            }
            return ix3Var;
        }
        return (ix3) invokeV.objValue;
    }
}
