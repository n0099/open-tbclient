package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rm3 a() {
        InterceptResult invokeV;
        rm3 rm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sm3.class) {
                if (a == null) {
                    a = new rm3();
                }
                rm3Var = a;
            }
            return rm3Var;
        }
        return (rm3) invokeV.objValue;
    }
}
