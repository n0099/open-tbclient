package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qm5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pm5 a() {
        InterceptResult invokeV;
        pm5 pm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qm5.class) {
                if (a == null) {
                    a = new pm5();
                }
                pm5Var = a;
            }
            return pm5Var;
        }
        return (pm5) invokeV.objValue;
    }
}
