package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ox3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nx3 a() {
        InterceptResult invokeV;
        nx3 nx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ox3.class) {
                if (a == null) {
                    a = new nx3();
                }
                nx3Var = a;
            }
            return nx3Var;
        }
        return (nx3) invokeV.objValue;
    }
}
