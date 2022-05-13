package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fk2 a() {
        InterceptResult invokeV;
        fk2 fk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gk2.class) {
                if (a == null) {
                    a = new fk2();
                }
                fk2Var = a;
            }
            return fk2Var;
        }
        return (fk2) invokeV.objValue;
    }
}
