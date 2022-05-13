package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rm5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qm5 a() {
        InterceptResult invokeV;
        qm5 qm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rm5.class) {
                if (a == null) {
                    a = new qm5();
                }
                qm5Var = a;
            }
            return qm5Var;
        }
        return (qm5) invokeV.objValue;
    }
}
