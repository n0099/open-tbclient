package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mm5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lm5 a() {
        InterceptResult invokeV;
        lm5 lm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mm5.class) {
                if (a == null) {
                    a = new lm5();
                }
                lm5Var = a;
            }
            return lm5Var;
        }
        return (lm5) invokeV.objValue;
    }
}
