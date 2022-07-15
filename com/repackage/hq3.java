package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gq3 a() {
        InterceptResult invokeV;
        gq3 gq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hq3.class) {
                if (a == null) {
                    a = new gq3();
                }
                gq3Var = a;
            }
            return gq3Var;
        }
        return (gq3) invokeV.objValue;
    }
}
