package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class wj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vj2 a() {
        InterceptResult invokeV;
        vj2 vj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wj2.class) {
                if (a == null) {
                    a = new vj2();
                }
                vj2Var = a;
            }
            return vj2Var;
        }
        return (vj2) invokeV.objValue;
    }
}
