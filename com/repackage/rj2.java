package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qj2 a() {
        InterceptResult invokeV;
        qj2 qj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rj2.class) {
                if (a == null) {
                    a = new qj2();
                }
                qj2Var = a;
            }
            return qj2Var;
        }
        return (qj2) invokeV.objValue;
    }
}
