package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class r24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q24 a() {
        InterceptResult invokeV;
        q24 q24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r24.class) {
                if (a == null) {
                    a = new q24();
                }
                q24Var = a;
            }
            return q24Var;
        }
        return (q24) invokeV.objValue;
    }
}
