package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vf8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uf8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uf8 a() {
        InterceptResult invokeV;
        uf8 uf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vf8.class) {
                if (a == null) {
                    a = new uf8();
                }
                uf8Var = a;
            }
            return uf8Var;
        }
        return (uf8) invokeV.objValue;
    }
}
