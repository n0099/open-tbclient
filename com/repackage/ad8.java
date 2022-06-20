package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ad8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zc8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zc8 a() {
        InterceptResult invokeV;
        zc8 zc8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ad8.class) {
                if (a == null) {
                    a = new zc8();
                }
                zc8Var = a;
            }
            return zc8Var;
        }
        return (zc8) invokeV.objValue;
    }
}
