package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z04 a() {
        InterceptResult invokeV;
        z04 z04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a14.class) {
                if (a == null) {
                    a = new z04();
                }
                z04Var = a;
            }
            return z04Var;
        }
        return (z04) invokeV.objValue;
    }
}
