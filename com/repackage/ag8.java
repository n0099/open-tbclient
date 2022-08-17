package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ag8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zf8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zf8 a() {
        InterceptResult invokeV;
        zf8 zf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ag8.class) {
                if (a == null) {
                    a = new zf8();
                }
                zf8Var = a;
            }
            return zf8Var;
        }
        return (zf8) invokeV.objValue;
    }
}
