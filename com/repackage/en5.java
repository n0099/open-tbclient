package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class en5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dn5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dn5 a() {
        InterceptResult invokeV;
        dn5 dn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (en5.class) {
                if (a == null) {
                    a = new dn5();
                }
                dn5Var = a;
            }
            return dn5Var;
        }
        return (dn5) invokeV.objValue;
    }
}
