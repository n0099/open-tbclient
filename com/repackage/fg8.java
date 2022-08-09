package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class fg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eg8 a() {
        InterceptResult invokeV;
        eg8 eg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fg8.class) {
                if (a == null) {
                    a = new eg8();
                }
                eg8Var = a;
            }
            return eg8Var;
        }
        return (eg8) invokeV.objValue;
    }
}
