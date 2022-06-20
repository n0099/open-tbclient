package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ci3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bi3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bi3 a() {
        InterceptResult invokeV;
        bi3 bi3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ci3.class) {
                if (a == null) {
                    a = new bi3();
                }
                bi3Var = a;
            }
            return bi3Var;
        }
        return (bi3) invokeV.objValue;
    }
}
