package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ym5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xm5 a() {
        InterceptResult invokeV;
        xm5 xm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ym5.class) {
                if (a == null) {
                    a = new xm5();
                }
                xm5Var = a;
            }
            return xm5Var;
        }
        return (xm5) invokeV.objValue;
    }
}
