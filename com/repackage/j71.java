package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j71 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i71 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i71 a() {
        InterceptResult invokeV;
        i71 i71Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j71.class) {
                if (a == null) {
                    a = new i71();
                }
                i71Var = a;
            }
            return i71Var;
        }
        return (i71) invokeV.objValue;
    }
}
