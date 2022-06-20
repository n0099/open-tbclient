package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class uc8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tc8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tc8 a() {
        InterceptResult invokeV;
        tc8 tc8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uc8.class) {
                if (a == null) {
                    a = new tc8();
                }
                tc8Var = a;
            }
            return tc8Var;
        }
        return (tc8) invokeV.objValue;
    }
}
