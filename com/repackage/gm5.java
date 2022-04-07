package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gm5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fm5 a() {
        InterceptResult invokeV;
        fm5 fm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gm5.class) {
                if (a == null) {
                    a = new fm5();
                }
                fm5Var = a;
            }
            return fm5Var;
        }
        return (fm5) invokeV.objValue;
    }
}
