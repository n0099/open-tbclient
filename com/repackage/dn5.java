package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dn5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cn5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cn5 a() {
        InterceptResult invokeV;
        cn5 cn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dn5.class) {
                if (a == null) {
                    a = new cn5();
                }
                cn5Var = a;
            }
            return cn5Var;
        }
        return (cn5) invokeV.objValue;
    }
}
