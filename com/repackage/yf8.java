package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yf8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xf8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xf8 a() {
        InterceptResult invokeV;
        xf8 xf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yf8.class) {
                if (a == null) {
                    a = new xf8();
                }
                xf8Var = a;
            }
            return xf8Var;
        }
        return (xf8) invokeV.objValue;
    }
}
