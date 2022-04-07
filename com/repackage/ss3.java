package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ss3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rs3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rs3 a() {
        InterceptResult invokeV;
        rs3 rs3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ss3.class) {
                if (a == null) {
                    a = new rs3();
                }
                rs3Var = a;
            }
            return rs3Var;
        }
        return (rs3) invokeV.objValue;
    }
}
