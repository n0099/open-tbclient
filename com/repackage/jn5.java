package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jn5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile in5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized in5 a() {
        InterceptResult invokeV;
        in5 in5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jn5.class) {
                if (a == null) {
                    a = new in5();
                }
                in5Var = a;
            }
            return in5Var;
        }
        return (in5) invokeV.objValue;
    }
}
