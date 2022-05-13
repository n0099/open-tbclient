package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bo3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ao3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ao3 a() {
        InterceptResult invokeV;
        ao3 ao3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bo3.class) {
                if (a == null) {
                    a = new ao3();
                }
                ao3Var = a;
            }
            return ao3Var;
        }
        return (ao3) invokeV.objValue;
    }
}
