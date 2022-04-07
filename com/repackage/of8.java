package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class of8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nf8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nf8 a() {
        InterceptResult invokeV;
        nf8 nf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (of8.class) {
                if (a == null) {
                    a = new nf8();
                }
                nf8Var = a;
            }
            return nf8Var;
        }
        return (nf8) invokeV.objValue;
    }
}
