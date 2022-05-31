package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l34 a() {
        InterceptResult invokeV;
        l34 l34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m34.class) {
                if (a == null) {
                    a = new l34();
                }
                l34Var = a;
            }
            return l34Var;
        }
        return (l34) invokeV.objValue;
    }
}
