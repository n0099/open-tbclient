package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class dg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cg8 a() {
        InterceptResult invokeV;
        cg8 cg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dg8.class) {
                if (a == null) {
                    a = new cg8();
                }
                cg8Var = a;
            }
            return cg8Var;
        }
        return (cg8) invokeV.objValue;
    }
}
