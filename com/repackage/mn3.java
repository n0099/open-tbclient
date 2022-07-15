package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ln3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ln3 a() {
        InterceptResult invokeV;
        ln3 ln3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mn3.class) {
                if (a == null) {
                    a = new ln3();
                }
                ln3Var = a;
            }
            return ln3Var;
        }
        return (ln3) invokeV.objValue;
    }
}
