package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ux3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tx3 a() {
        InterceptResult invokeV;
        tx3 tx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ux3.class) {
                if (a == null) {
                    a = new tx3();
                }
                tx3Var = a;
            }
            return tx3Var;
        }
        return (tx3) invokeV.objValue;
    }
}
