package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ik3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hk3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hk3 a() {
        InterceptResult invokeV;
        hk3 hk3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ik3.class) {
                if (a == null) {
                    a = new hk3();
                }
                hk3Var = a;
            }
            return hk3Var;
        }
        return (hk3) invokeV.objValue;
    }
}
