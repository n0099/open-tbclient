package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vo5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uo5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uo5 a() {
        InterceptResult invokeV;
        uo5 uo5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vo5.class) {
                if (a == null) {
                    a = new uo5();
                }
                uo5Var = a;
            }
            return uo5Var;
        }
        return (uo5) invokeV.objValue;
    }
}
