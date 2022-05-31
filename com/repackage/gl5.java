package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gl5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fl5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fl5 a() {
        InterceptResult invokeV;
        fl5 fl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gl5.class) {
                if (a == null) {
                    a = new fl5();
                }
                fl5Var = a;
            }
            return fl5Var;
        }
        return (fl5) invokeV.objValue;
    }
}
