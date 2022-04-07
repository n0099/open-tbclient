package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sf8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rf8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rf8 a() {
        InterceptResult invokeV;
        rf8 rf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sf8.class) {
                if (a == null) {
                    a = new rf8();
                }
                rf8Var = a;
            }
            return rf8Var;
        }
        return (rf8) invokeV.objValue;
    }
}
