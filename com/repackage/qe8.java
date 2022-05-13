package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qe8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pe8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pe8 a() {
        InterceptResult invokeV;
        pe8 pe8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qe8.class) {
                if (a == null) {
                    a = new pe8();
                }
                pe8Var = a;
            }
            return pe8Var;
        }
        return (pe8) invokeV.objValue;
    }
}
