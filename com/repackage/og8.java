package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class og8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ng8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ng8 a() {
        InterceptResult invokeV;
        ng8 ng8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (og8.class) {
                if (a == null) {
                    a = new ng8();
                }
                ng8Var = a;
            }
            return ng8Var;
        }
        return (ng8) invokeV.objValue;
    }
}
