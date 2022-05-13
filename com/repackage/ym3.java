package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ym3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xm3 a() {
        InterceptResult invokeV;
        xm3 xm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ym3.class) {
                if (a == null) {
                    a = new xm3();
                }
                xm3Var = a;
            }
            return xm3Var;
        }
        return (xm3) invokeV.objValue;
    }
}
