package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i24 a() {
        InterceptResult invokeV;
        i24 i24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j24.class) {
                if (a == null) {
                    a = new i24();
                }
                i24Var = a;
            }
            return i24Var;
        }
        return (i24) invokeV.objValue;
    }
}
