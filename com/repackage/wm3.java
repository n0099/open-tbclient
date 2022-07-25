package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class wm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vm3 a() {
        InterceptResult invokeV;
        vm3 vm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wm3.class) {
                if (a == null) {
                    a = new vm3();
                }
                vm3Var = a;
            }
            return vm3Var;
        }
        return (vm3) invokeV.objValue;
    }
}
