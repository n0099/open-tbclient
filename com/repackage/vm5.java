package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vm5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile um5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized um5 a() {
        InterceptResult invokeV;
        um5 um5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vm5.class) {
                if (a == null) {
                    a = new um5();
                }
                um5Var = a;
            }
            return um5Var;
        }
        return (um5) invokeV.objValue;
    }
}
