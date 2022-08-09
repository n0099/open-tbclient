package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ht0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gt0 a() {
        InterceptResult invokeV;
        gt0 gt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ht0.class) {
                if (a == null) {
                    a = new gt0();
                }
                gt0Var = a;
            }
            return gt0Var;
        }
        return (gt0) invokeV.objValue;
    }
}
