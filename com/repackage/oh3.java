package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class oh3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nh3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nh3 a() {
        InterceptResult invokeV;
        nh3 nh3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oh3.class) {
                if (a == null) {
                    a = new nh3();
                }
                nh3Var = a;
            }
            return nh3Var;
        }
        return (nh3) invokeV.objValue;
    }
}
