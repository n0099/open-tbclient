package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ak2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zj2 a() {
        InterceptResult invokeV;
        zj2 zj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ak2.class) {
                if (a == null) {
                    a = new zj2();
                }
                zj2Var = a;
            }
            return zj2Var;
        }
        return (zj2) invokeV.objValue;
    }
}
