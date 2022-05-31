package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rb8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qb8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qb8 a() {
        InterceptResult invokeV;
        qb8 qb8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rb8.class) {
                if (a == null) {
                    a = new qb8();
                }
                qb8Var = a;
            }
            return qb8Var;
        }
        return (qb8) invokeV.objValue;
    }
}
