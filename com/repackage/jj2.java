package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ij2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ij2 a() {
        InterceptResult invokeV;
        ij2 ij2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jj2.class) {
                if (a == null) {
                    a = new ij2();
                }
                ij2Var = a;
            }
            return ij2Var;
        }
        return (ij2) invokeV.objValue;
    }
}
