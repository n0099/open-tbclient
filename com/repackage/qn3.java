package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pn3 a() {
        InterceptResult invokeV;
        pn3 pn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qn3.class) {
                if (a == null) {
                    a = new pn3();
                }
                pn3Var = a;
            }
            return pn3Var;
        }
        return (pn3) invokeV.objValue;
    }
}
