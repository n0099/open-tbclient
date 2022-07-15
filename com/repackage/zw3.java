package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yw3 a() {
        InterceptResult invokeV;
        yw3 yw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zw3.class) {
                if (a == null) {
                    a = new yw3();
                }
                yw3Var = a;
            }
            return yw3Var;
        }
        return (yw3) invokeV.objValue;
    }
}
