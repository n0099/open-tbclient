package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class me8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile le8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized le8 a() {
        InterceptResult invokeV;
        le8 le8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (me8.class) {
                if (a == null) {
                    a = new le8();
                }
                le8Var = a;
            }
            return le8Var;
        }
        return (le8) invokeV.objValue;
    }
}
