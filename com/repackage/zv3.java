package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zv3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yv3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yv3 a() {
        InterceptResult invokeV;
        yv3 yv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zv3.class) {
                if (a == null) {
                    a = new yv3();
                }
                yv3Var = a;
            }
            return yv3Var;
        }
        return (yv3) invokeV.objValue;
    }
}
