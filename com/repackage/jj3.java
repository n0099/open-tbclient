package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jj3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ij3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ij3 a() {
        InterceptResult invokeV;
        ij3 ij3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jj3.class) {
                if (a == null) {
                    a = new ij3();
                }
                ij3Var = a;
            }
            return ij3Var;
        }
        return (ij3) invokeV.objValue;
    }
}
