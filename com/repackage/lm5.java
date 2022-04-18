package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lm5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile km5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized km5 a() {
        InterceptResult invokeV;
        km5 km5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lm5.class) {
                if (a == null) {
                    a = new km5();
                }
                km5Var = a;
            }
            return km5Var;
        }
        return (km5) invokeV.objValue;
    }
}
