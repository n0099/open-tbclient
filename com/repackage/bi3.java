package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bi3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ai3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ai3 a() {
        InterceptResult invokeV;
        ai3 ai3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bi3.class) {
                if (a == null) {
                    a = new ai3();
                }
                ai3Var = a;
            }
            return ai3Var;
        }
        return (ai3) invokeV.objValue;
    }
}
