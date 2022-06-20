package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yc8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xc8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xc8 a() {
        InterceptResult invokeV;
        xc8 xc8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yc8.class) {
                if (a == null) {
                    a = new xc8();
                }
                xc8Var = a;
            }
            return xc8Var;
        }
        return (xc8) invokeV.objValue;
    }
}
