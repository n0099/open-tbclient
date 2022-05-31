package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yi2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xi2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xi2 a() {
        InterceptResult invokeV;
        xi2 xi2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yi2.class) {
                if (a == null) {
                    a = new xi2();
                }
                xi2Var = a;
            }
            return xi2Var;
        }
        return (xi2) invokeV.objValue;
    }
}
