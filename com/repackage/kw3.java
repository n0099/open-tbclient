package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jw3 a() {
        InterceptResult invokeV;
        jw3 jw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kw3.class) {
                if (a == null) {
                    a = new jw3();
                }
                jw3Var = a;
            }
            return jw3Var;
        }
        return (jw3) invokeV.objValue;
    }
}
