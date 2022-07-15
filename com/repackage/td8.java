package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class td8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sd8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sd8 a() {
        InterceptResult invokeV;
        sd8 sd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (td8.class) {
                if (a == null) {
                    a = new sd8();
                }
                sd8Var = a;
            }
            return sd8Var;
        }
        return (sd8) invokeV.objValue;
    }
}
