package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class id8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hd8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hd8 a() {
        InterceptResult invokeV;
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (id8.class) {
                if (a == null) {
                    a = new hd8();
                }
                hd8Var = a;
            }
            return hd8Var;
        }
        return (hd8) invokeV.objValue;
    }
}
