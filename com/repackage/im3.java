package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class im3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hm3 a() {
        InterceptResult invokeV;
        hm3 hm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (im3.class) {
                if (a == null) {
                    a = new hm3();
                }
                hm3Var = a;
            }
            return hm3Var;
        }
        return (hm3) invokeV.objValue;
    }
}
