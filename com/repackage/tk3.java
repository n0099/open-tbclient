package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tk3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sk3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sk3 a() {
        InterceptResult invokeV;
        sk3 sk3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tk3.class) {
                if (a == null) {
                    a = new sk3();
                }
                sk3Var = a;
            }
            return sk3Var;
        }
        return (sk3) invokeV.objValue;
    }
}
