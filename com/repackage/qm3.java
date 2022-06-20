package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pm3 a() {
        InterceptResult invokeV;
        pm3 pm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qm3.class) {
                if (a == null) {
                    a = new pm3();
                }
                pm3Var = a;
            }
            return pm3Var;
        }
        return (pm3) invokeV.objValue;
    }
}
