package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class to5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile so5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized so5 a() {
        InterceptResult invokeV;
        so5 so5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (to5.class) {
                if (a == null) {
                    a = new so5();
                }
                so5Var = a;
            }
            return so5Var;
        }
        return (so5) invokeV.objValue;
    }
}
