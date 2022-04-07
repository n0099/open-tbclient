package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class om5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nm5 a() {
        InterceptResult invokeV;
        nm5 nm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (om5.class) {
                if (a == null) {
                    a = new nm5();
                }
                nm5Var = a;
            }
            return nm5Var;
        }
        return (nm5) invokeV.objValue;
    }
}
