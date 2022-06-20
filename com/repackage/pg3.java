package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class pg3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile og3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized og3 a() {
        InterceptResult invokeV;
        og3 og3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pg3.class) {
                if (a == null) {
                    a = new og3();
                }
                og3Var = a;
            }
            return og3Var;
        }
        return (og3) invokeV.objValue;
    }
}
