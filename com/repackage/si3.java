package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class si3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ri3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ri3 a() {
        InterceptResult invokeV;
        ri3 ri3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (si3.class) {
                if (a == null) {
                    a = new ri3();
                }
                ri3Var = a;
            }
            return ri3Var;
        }
        return (ri3) invokeV.objValue;
    }
}
