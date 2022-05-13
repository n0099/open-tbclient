package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zh3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yh3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yh3 a() {
        InterceptResult invokeV;
        yh3 yh3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zh3.class) {
                if (a == null) {
                    a = new yh3();
                }
                yh3Var = a;
            }
            return yh3Var;
        }
        return (yh3) invokeV.objValue;
    }
}
