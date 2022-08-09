package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class po5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oo5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized oo5 a() {
        InterceptResult invokeV;
        oo5 oo5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (po5.class) {
                if (a == null) {
                    a = new oo5();
                }
                oo5Var = a;
            }
            return oo5Var;
        }
        return (oo5) invokeV.objValue;
    }
}
