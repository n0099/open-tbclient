package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ss0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rs0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rs0 a() {
        InterceptResult invokeV;
        rs0 rs0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ss0.class) {
                if (a == null) {
                    a = new rs0();
                }
                rs0Var = a;
            }
            return rs0Var;
        }
        return (rs0) invokeV.objValue;
    }
}
