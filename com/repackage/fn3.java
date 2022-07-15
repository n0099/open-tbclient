package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class fn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile en3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized en3 a() {
        InterceptResult invokeV;
        en3 en3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fn3.class) {
                if (a == null) {
                    a = new en3();
                }
                en3Var = a;
            }
            return en3Var;
        }
        return (en3) invokeV.objValue;
    }
}
