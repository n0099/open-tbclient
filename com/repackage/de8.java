package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class de8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ce8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ce8 a() {
        InterceptResult invokeV;
        ce8 ce8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (de8.class) {
                if (a == null) {
                    a = new ce8();
                }
                ce8Var = a;
            }
            return ce8Var;
        }
        return (ce8) invokeV.objValue;
    }
}
