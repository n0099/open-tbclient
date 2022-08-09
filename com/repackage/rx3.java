package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qx3 a() {
        InterceptResult invokeV;
        qx3 qx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rx3.class) {
                if (a == null) {
                    a = new qx3();
                }
                qx3Var = a;
            }
            return qx3Var;
        }
        return (qx3) invokeV.objValue;
    }
}
