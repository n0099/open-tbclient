package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class x71 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w71 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w71 a() {
        InterceptResult invokeV;
        w71 w71Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x71.class) {
                if (a == null) {
                    a = new w71();
                }
                w71Var = a;
            }
            return w71Var;
        }
        return (w71) invokeV.objValue;
    }
}
