package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile um3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized um3 a() {
        InterceptResult invokeV;
        um3 um3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vm3.class) {
                if (a == null) {
                    a = new um3();
                }
                um3Var = a;
            }
            return um3Var;
        }
        return (um3) invokeV.objValue;
    }
}
