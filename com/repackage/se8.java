package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class se8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile re8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized re8 a() {
        InterceptResult invokeV;
        re8 re8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (se8.class) {
                if (a == null) {
                    a = new re8();
                }
                re8Var = a;
            }
            return re8Var;
        }
        return (re8) invokeV.objValue;
    }
}
