package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pk2 a() {
        InterceptResult invokeV;
        pk2 pk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qk2.class) {
                if (a == null) {
                    a = new pk2();
                }
                pk2Var = a;
            }
            return pk2Var;
        }
        return (pk2) invokeV.objValue;
    }
}
