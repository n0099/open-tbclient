package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zb8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yb8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yb8 a() {
        InterceptResult invokeV;
        yb8 yb8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zb8.class) {
                if (a == null) {
                    a = new yb8();
                }
                yb8Var = a;
            }
            return yb8Var;
        }
        return (yb8) invokeV.objValue;
    }
}
