package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class eo5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile do5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized do5 a() {
        InterceptResult invokeV;
        do5 do5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eo5.class) {
                if (a == null) {
                    a = new do5();
                }
                do5Var = a;
            }
            return do5Var;
        }
        return (do5) invokeV.objValue;
    }
}
