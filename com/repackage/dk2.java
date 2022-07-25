package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ck2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ck2 a() {
        InterceptResult invokeV;
        ck2 ck2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dk2.class) {
                if (a == null) {
                    a = new ck2();
                }
                ck2Var = a;
            }
            return ck2Var;
        }
        return (ck2) invokeV.objValue;
    }
}
