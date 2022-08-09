package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ei3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile di3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized di3 a() {
        InterceptResult invokeV;
        di3 di3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ei3.class) {
                if (a == null) {
                    a = new di3();
                }
                di3Var = a;
            }
            return di3Var;
        }
        return (di3) invokeV.objValue;
    }
}
