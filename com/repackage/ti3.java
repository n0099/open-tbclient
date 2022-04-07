package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ti3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile si3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized si3 a() {
        InterceptResult invokeV;
        si3 si3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ti3.class) {
                if (a == null) {
                    a = new si3();
                }
                si3Var = a;
            }
            return si3Var;
        }
        return (si3) invokeV.objValue;
    }
}
