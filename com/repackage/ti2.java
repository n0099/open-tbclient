package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ti2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile si2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized si2 a() {
        InterceptResult invokeV;
        si2 si2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ti2.class) {
                if (a == null) {
                    a = new si2();
                }
                si2Var = a;
            }
            return si2Var;
        }
        return (si2) invokeV.objValue;
    }
}
