package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class l24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k24 a() {
        InterceptResult invokeV;
        k24 k24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l24.class) {
                if (a == null) {
                    a = new k24();
                }
                k24Var = a;
            }
            return k24Var;
        }
        return (k24) invokeV.objValue;
    }
}
