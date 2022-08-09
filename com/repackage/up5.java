package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class up5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tp5 a() {
        InterceptResult invokeV;
        tp5 tp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (up5.class) {
                if (a == null) {
                    a = new tp5();
                }
                tp5Var = a;
            }
            return tp5Var;
        }
        return (tp5) invokeV.objValue;
    }
}
