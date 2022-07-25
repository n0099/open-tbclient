package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class fh3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eh3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eh3 a() {
        InterceptResult invokeV;
        eh3 eh3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fh3.class) {
                if (a == null) {
                    a = new eh3();
                }
                eh3Var = a;
            }
            return eh3Var;
        }
        return (eh3) invokeV.objValue;
    }
}
