package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k61 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j61 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j61 a() {
        InterceptResult invokeV;
        j61 j61Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k61.class) {
                if (a == null) {
                    a = new j61();
                }
                j61Var = a;
            }
            return j61Var;
        }
        return (j61) invokeV.objValue;
    }
}
