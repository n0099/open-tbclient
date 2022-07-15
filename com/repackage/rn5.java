package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rn5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qn5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qn5 a() {
        InterceptResult invokeV;
        qn5 qn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rn5.class) {
                if (a == null) {
                    a = new qn5();
                }
                qn5Var = a;
            }
            return qn5Var;
        }
        return (qn5) invokeV.objValue;
    }
}
