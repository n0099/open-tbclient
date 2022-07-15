package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class eh3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dh3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dh3 a() {
        InterceptResult invokeV;
        dh3 dh3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eh3.class) {
                if (a == null) {
                    a = new dh3();
                }
                dh3Var = a;
            }
            return dh3Var;
        }
        return (dh3) invokeV.objValue;
    }
}
