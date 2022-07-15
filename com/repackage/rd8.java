package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rd8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qd8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qd8 a() {
        InterceptResult invokeV;
        qd8 qd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rd8.class) {
                if (a == null) {
                    a = new qd8();
                }
                qd8Var = a;
            }
            return qd8Var;
        }
        return (qd8) invokeV.objValue;
    }
}
