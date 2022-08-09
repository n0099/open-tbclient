package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ik2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ik2 a() {
        InterceptResult invokeV;
        ik2 ik2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jk2.class) {
                if (a == null) {
                    a = new ik2();
                }
                ik2Var = a;
            }
            return ik2Var;
        }
        return (ik2) invokeV.objValue;
    }
}
