package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pg8 a() {
        InterceptResult invokeV;
        pg8 pg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qg8.class) {
                if (a == null) {
                    a = new pg8();
                }
                pg8Var = a;
            }
            return pg8Var;
        }
        return (pg8) invokeV.objValue;
    }
}
