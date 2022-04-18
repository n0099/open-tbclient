package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class im5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hm5 a() {
        InterceptResult invokeV;
        hm5 hm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (im5.class) {
                if (a == null) {
                    a = new hm5();
                }
                hm5Var = a;
            }
            return hm5Var;
        }
        return (hm5) invokeV.objValue;
    }
}
