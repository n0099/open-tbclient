package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile in3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized in3 a() {
        InterceptResult invokeV;
        in3 in3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jn3.class) {
                if (a == null) {
                    a = new in3();
                }
                in3Var = a;
            }
            return in3Var;
        }
        return (in3) invokeV.objValue;
    }
}
