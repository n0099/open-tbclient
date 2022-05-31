package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lm3 a() {
        InterceptResult invokeV;
        lm3 lm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mm3.class) {
                if (a == null) {
                    a = new lm3();
                }
                lm3Var = a;
            }
            return lm3Var;
        }
        return (lm3) invokeV.objValue;
    }
}
