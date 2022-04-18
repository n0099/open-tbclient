package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tm5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sm5 a() {
        InterceptResult invokeV;
        sm5 sm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tm5.class) {
                if (a == null) {
                    a = new sm5();
                }
                sm5Var = a;
            }
            return sm5Var;
        }
        return (sm5) invokeV.objValue;
    }
}
