package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ax3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zw3 a() {
        InterceptResult invokeV;
        zw3 zw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ax3.class) {
                if (a == null) {
                    a = new zw3();
                }
                zw3Var = a;
            }
            return zw3Var;
        }
        return (zw3) invokeV.objValue;
    }
}
