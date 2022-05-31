package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qk3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pk3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pk3 a() {
        InterceptResult invokeV;
        pk3 pk3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qk3.class) {
                if (a == null) {
                    a = new pk3();
                }
                pk3Var = a;
            }
            return pk3Var;
        }
        return (pk3) invokeV.objValue;
    }
}
