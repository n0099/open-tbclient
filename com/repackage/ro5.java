package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ro5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qo5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qo5 a() {
        InterceptResult invokeV;
        qo5 qo5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ro5.class) {
                if (a == null) {
                    a = new qo5();
                }
                qo5Var = a;
            }
            return qo5Var;
        }
        return (qo5) invokeV.objValue;
    }
}
