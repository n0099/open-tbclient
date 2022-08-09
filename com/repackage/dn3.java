package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class dn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cn3 a() {
        InterceptResult invokeV;
        cn3 cn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dn3.class) {
                if (a == null) {
                    a = new cn3();
                }
                cn3Var = a;
            }
            return cn3Var;
        }
        return (cn3) invokeV.objValue;
    }
}
