package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zk5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yk5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yk5 a() {
        InterceptResult invokeV;
        yk5 yk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zk5.class) {
                if (a == null) {
                    a = new yk5();
                }
                yk5Var = a;
            }
            return yk5Var;
        }
        return (yk5) invokeV.objValue;
    }
}
