package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rp5 a() {
        InterceptResult invokeV;
        rp5 rp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sp5.class) {
                if (a == null) {
                    a = new rp5();
                }
                rp5Var = a;
            }
            return rp5Var;
        }
        return (rp5) invokeV.objValue;
    }
}
