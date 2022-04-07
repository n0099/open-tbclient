package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ek2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dk2 a() {
        InterceptResult invokeV;
        dk2 dk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ek2.class) {
                if (a == null) {
                    a = new dk2();
                }
                dk2Var = a;
            }
            return dk2Var;
        }
        return (dk2) invokeV.objValue;
    }
}
