package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rh3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qh3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qh3 a() {
        InterceptResult invokeV;
        qh3 qh3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rh3.class) {
                if (a == null) {
                    a = new qh3();
                }
                qh3Var = a;
            }
            return qh3Var;
        }
        return (qh3) invokeV.objValue;
    }
}
