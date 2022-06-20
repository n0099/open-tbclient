package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class x34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w34 a() {
        InterceptResult invokeV;
        w34 w34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x34.class) {
                if (a == null) {
                    a = new w34();
                }
                w34Var = a;
            }
            return w34Var;
        }
        return (w34) invokeV.objValue;
    }
}
