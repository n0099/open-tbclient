package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class al3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zk3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zk3 a() {
        InterceptResult invokeV;
        zk3 zk3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (al3.class) {
                if (a == null) {
                    a = new zk3();
                }
                zk3Var = a;
            }
            return zk3Var;
        }
        return (zk3) invokeV.objValue;
    }
}
