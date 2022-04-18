package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ig8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ig8 a() {
        InterceptResult invokeV;
        ig8 ig8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jg8.class) {
                if (a == null) {
                    a = new ig8();
                }
                ig8Var = a;
            }
            return ig8Var;
        }
        return (ig8) invokeV.objValue;
    }
}
