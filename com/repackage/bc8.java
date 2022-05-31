package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bc8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ac8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ac8 a() {
        InterceptResult invokeV;
        ac8 ac8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bc8.class) {
                if (a == null) {
                    a = new ac8();
                }
                ac8Var = a;
            }
            return ac8Var;
        }
        return (ac8) invokeV.objValue;
    }
}
