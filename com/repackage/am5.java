package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class am5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zl5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zl5 a() {
        InterceptResult invokeV;
        zl5 zl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (am5.class) {
                if (a == null) {
                    a = new zl5();
                }
                zl5Var = a;
            }
            return zl5Var;
        }
        return (zl5) invokeV.objValue;
    }
}
