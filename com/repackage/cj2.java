package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bj2 a() {
        InterceptResult invokeV;
        bj2 bj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cj2.class) {
                if (a == null) {
                    a = new bj2();
                }
                bj2Var = a;
            }
            return bj2Var;
        }
        return (bj2) invokeV.objValue;
    }
}
