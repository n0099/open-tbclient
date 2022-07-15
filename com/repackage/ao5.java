package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ao5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zn5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zn5 a() {
        InterceptResult invokeV;
        zn5 zn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ao5.class) {
                if (a == null) {
                    a = new zn5();
                }
                zn5Var = a;
            }
            return zn5Var;
        }
        return (zn5) invokeV.objValue;
    }
}
