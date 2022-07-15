package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class co5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bo5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bo5 a() {
        InterceptResult invokeV;
        bo5 bo5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (co5.class) {
                if (a == null) {
                    a = new bo5();
                }
                bo5Var = a;
            }
            return bo5Var;
        }
        return (bo5) invokeV.objValue;
    }
}
