package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tb8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sb8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sb8 a() {
        InterceptResult invokeV;
        sb8 sb8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tb8.class) {
                if (a == null) {
                    a = new sb8();
                }
                sb8Var = a;
            }
            return sb8Var;
        }
        return (sb8) invokeV.objValue;
    }
}
