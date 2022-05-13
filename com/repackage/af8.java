package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class af8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ze8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ze8 a() {
        InterceptResult invokeV;
        ze8 ze8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (af8.class) {
                if (a == null) {
                    a = new ze8();
                }
                ze8Var = a;
            }
            return ze8Var;
        }
        return (ze8) invokeV.objValue;
    }
}
