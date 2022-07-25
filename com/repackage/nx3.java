package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mx3 a() {
        InterceptResult invokeV;
        mx3 mx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nx3.class) {
                if (a == null) {
                    a = new mx3();
                }
                mx3Var = a;
            }
            return mx3Var;
        }
        return (mx3) invokeV.objValue;
    }
}
