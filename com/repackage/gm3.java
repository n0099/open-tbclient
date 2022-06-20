package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fm3 a() {
        InterceptResult invokeV;
        fm3 fm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gm3.class) {
                if (a == null) {
                    a = new fm3();
                }
                fm3Var = a;
            }
            return fm3Var;
        }
        return (fm3) invokeV.objValue;
    }
}
