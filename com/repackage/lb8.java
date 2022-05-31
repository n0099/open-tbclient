package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lb8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kb8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kb8 a() {
        InterceptResult invokeV;
        kb8 kb8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lb8.class) {
                if (a == null) {
                    a = new kb8();
                }
                kb8Var = a;
            }
            return kb8Var;
        }
        return (kb8) invokeV.objValue;
    }
}
