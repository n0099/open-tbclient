package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ul3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ul3 a() {
        InterceptResult invokeV;
        ul3 ul3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vl3.class) {
                if (a == null) {
                    a = new ul3();
                }
                ul3Var = a;
            }
            return ul3Var;
        }
        return (ul3) invokeV.objValue;
    }
}
