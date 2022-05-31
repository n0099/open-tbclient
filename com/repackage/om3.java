package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class om3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nm3 a() {
        InterceptResult invokeV;
        nm3 nm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (om3.class) {
                if (a == null) {
                    a = new nm3();
                }
                nm3Var = a;
            }
            return nm3Var;
        }
        return (nm3) invokeV.objValue;
    }
}
