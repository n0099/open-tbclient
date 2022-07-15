package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bj3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile aj3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized aj3 a() {
        InterceptResult invokeV;
        aj3 aj3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bj3.class) {
                if (a == null) {
                    a = new aj3();
                }
                aj3Var = a;
            }
            return aj3Var;
        }
        return (aj3) invokeV.objValue;
    }
}
