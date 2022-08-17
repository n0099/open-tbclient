package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yp5 a() {
        InterceptResult invokeV;
        yp5 yp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zp5.class) {
                if (a == null) {
                    a = new yp5();
                }
                yp5Var = a;
            }
            return yp5Var;
        }
        return (yp5) invokeV.objValue;
    }
}
