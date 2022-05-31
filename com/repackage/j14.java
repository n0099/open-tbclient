package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i14 a() {
        InterceptResult invokeV;
        i14 i14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j14.class) {
                if (a == null) {
                    a = new i14();
                }
                i14Var = a;
            }
            return i14Var;
        }
        return (i14) invokeV.objValue;
    }
}
