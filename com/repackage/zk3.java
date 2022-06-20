package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zk3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yk3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yk3 a() {
        InterceptResult invokeV;
        yk3 yk3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zk3.class) {
                if (a == null) {
                    a = new yk3();
                }
                yk3Var = a;
            }
            return yk3Var;
        }
        return (yk3) invokeV.objValue;
    }
}
