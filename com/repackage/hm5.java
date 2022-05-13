package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hm5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gm5 a() {
        InterceptResult invokeV;
        gm5 gm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hm5.class) {
                if (a == null) {
                    a = new gm5();
                }
                gm5Var = a;
            }
            return gm5Var;
        }
        return (gm5) invokeV.objValue;
    }
}
