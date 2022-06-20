package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cd8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bd8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bd8 a() {
        InterceptResult invokeV;
        bd8 bd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cd8.class) {
                if (a == null) {
                    a = new bd8();
                }
                bd8Var = a;
            }
            return bd8Var;
        }
        return (bd8) invokeV.objValue;
    }
}
