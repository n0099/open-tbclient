package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class uk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tk2 a() {
        InterceptResult invokeV;
        tk2 tk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uk2.class) {
                if (a == null) {
                    a = new tk2();
                }
                tk2Var = a;
            }
            return tk2Var;
        }
        return (tk2) invokeV.objValue;
    }
}
