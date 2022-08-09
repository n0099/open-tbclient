package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i34 a() {
        InterceptResult invokeV;
        i34 i34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j34.class) {
                if (a == null) {
                    a = new i34();
                }
                i34Var = a;
            }
            return i34Var;
        }
        return (i34) invokeV.objValue;
    }
}
