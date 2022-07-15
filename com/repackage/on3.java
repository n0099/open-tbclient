package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class on3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nn3 a() {
        InterceptResult invokeV;
        nn3 nn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (on3.class) {
                if (a == null) {
                    a = new nn3();
                }
                nn3Var = a;
            }
            return nn3Var;
        }
        return (nn3) invokeV.objValue;
    }
}
