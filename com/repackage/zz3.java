package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yz3 a() {
        InterceptResult invokeV;
        yz3 yz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zz3.class) {
                if (a == null) {
                    a = new yz3();
                }
                yz3Var = a;
            }
            return yz3Var;
        }
        return (yz3) invokeV.objValue;
    }
}
