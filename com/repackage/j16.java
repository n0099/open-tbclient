package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j16 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i16 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i16 a() {
        InterceptResult invokeV;
        i16 i16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j16.class) {
                if (a == null) {
                    a = new i16();
                }
                i16Var = a;
            }
            return i16Var;
        }
        return (i16) invokeV.objValue;
    }
}
