package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gg8 a() {
        InterceptResult invokeV;
        gg8 gg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hg8.class) {
                if (a == null) {
                    a = new gg8();
                }
                gg8Var = a;
            }
            return gg8Var;
        }
        return (gg8) invokeV.objValue;
    }
}
