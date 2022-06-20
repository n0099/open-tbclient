package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yl5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xl5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xl5 a() {
        InterceptResult invokeV;
        xl5 xl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yl5.class) {
                if (a == null) {
                    a = new xl5();
                }
                xl5Var = a;
            }
            return xl5Var;
        }
        return (xl5) invokeV.objValue;
    }
}
