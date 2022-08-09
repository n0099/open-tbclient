package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class eo3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile do3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized do3 a() {
        InterceptResult invokeV;
        do3 do3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eo3.class) {
                if (a == null) {
                    a = new do3();
                }
                do3Var = a;
            }
            return do3Var;
        }
        return (do3) invokeV.objValue;
    }
}
