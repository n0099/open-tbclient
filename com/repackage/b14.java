package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a14 a() {
        InterceptResult invokeV;
        a14 a14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b14.class) {
                if (a == null) {
                    a = new a14();
                }
                a14Var = a;
            }
            return a14Var;
        }
        return (a14) invokeV.objValue;
    }
}
