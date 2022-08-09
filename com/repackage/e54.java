package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class e54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d54 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d54 a() {
        InterceptResult invokeV;
        d54 d54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e54.class) {
                if (a == null) {
                    a = new d54();
                }
                d54Var = a;
            }
            return d54Var;
        }
        return (d54) invokeV.objValue;
    }
}
