package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ag8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ag8 a() {
        InterceptResult invokeV;
        ag8 ag8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bg8.class) {
                if (a == null) {
                    a = new ag8();
                }
                ag8Var = a;
            }
            return ag8Var;
        }
        return (ag8) invokeV.objValue;
    }
}
