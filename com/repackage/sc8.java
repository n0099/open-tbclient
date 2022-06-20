package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sc8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rc8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rc8 a() {
        InterceptResult invokeV;
        rc8 rc8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sc8.class) {
                if (a == null) {
                    a = new rc8();
                }
                rc8Var = a;
            }
            return rc8Var;
        }
        return (rc8) invokeV.objValue;
    }
}
