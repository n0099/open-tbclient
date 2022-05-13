package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ye8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xe8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xe8 a() {
        InterceptResult invokeV;
        xe8 xe8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ye8.class) {
                if (a == null) {
                    a = new xe8();
                }
                xe8Var = a;
            }
            return xe8Var;
        }
        return (xe8) invokeV.objValue;
    }
}
