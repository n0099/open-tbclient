package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yj2 a() {
        InterceptResult invokeV;
        yj2 yj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zj2.class) {
                if (a == null) {
                    a = new yj2();
                }
                yj2Var = a;
            }
            return yj2Var;
        }
        return (yj2) invokeV.objValue;
    }
}
