package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class up3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tp3 a() {
        InterceptResult invokeV;
        tp3 tp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (up3.class) {
                if (a == null) {
                    a = new tp3();
                }
                tp3Var = a;
            }
            return tp3Var;
        }
        return (tp3) invokeV.objValue;
    }
}
