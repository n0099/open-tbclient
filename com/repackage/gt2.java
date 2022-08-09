package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gt2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ft2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ft2 a() {
        InterceptResult invokeV;
        ft2 ft2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gt2.class) {
                if (a == null) {
                    a = new ft2();
                }
                ft2Var = a;
            }
            return ft2Var;
        }
        return (ft2) invokeV.objValue;
    }
}
