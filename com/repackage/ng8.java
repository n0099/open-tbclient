package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ng8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mg8 a() {
        InterceptResult invokeV;
        mg8 mg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ng8.class) {
                if (a == null) {
                    a = new mg8();
                }
                mg8Var = a;
            }
            return mg8Var;
        }
        return (mg8) invokeV.objValue;
    }
}
