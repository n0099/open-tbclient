package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dl5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cl5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cl5 a() {
        InterceptResult invokeV;
        cl5 cl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dl5.class) {
                if (a == null) {
                    a = new cl5();
                }
                cl5Var = a;
            }
            return cl5Var;
        }
        return (cl5) invokeV.objValue;
    }
}
