package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class am3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zl3 a() {
        InterceptResult invokeV;
        zl3 zl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (am3.class) {
                if (a == null) {
                    a = new zl3();
                }
                zl3Var = a;
            }
            return zl3Var;
        }
        return (zl3) invokeV.objValue;
    }
}
