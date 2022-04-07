package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sj2 a() {
        InterceptResult invokeV;
        sj2 sj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tj2.class) {
                if (a == null) {
                    a = new sj2();
                }
                sj2Var = a;
            }
            return sj2Var;
        }
        return (sj2) invokeV.objValue;
    }
}
