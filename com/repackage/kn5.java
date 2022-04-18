package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kn5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jn5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jn5 a() {
        InterceptResult invokeV;
        jn5 jn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kn5.class) {
                if (a == null) {
                    a = new jn5();
                }
                jn5Var = a;
            }
            return jn5Var;
        }
        return (jn5) invokeV.objValue;
    }
}
