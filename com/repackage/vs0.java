package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vs0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile us0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized us0 a() {
        InterceptResult invokeV;
        us0 us0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vs0.class) {
                if (a == null) {
                    a = new us0();
                }
                us0Var = a;
            }
            return us0Var;
        }
        return (us0) invokeV.objValue;
    }
}
