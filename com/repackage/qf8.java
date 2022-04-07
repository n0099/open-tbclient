package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qf8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pf8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pf8 a() {
        InterceptResult invokeV;
        pf8 pf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qf8.class) {
                if (a == null) {
                    a = new pf8();
                }
                pf8Var = a;
            }
            return pf8Var;
        }
        return (pf8) invokeV.objValue;
    }
}
