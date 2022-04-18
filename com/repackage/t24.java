package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class t24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s24 a() {
        InterceptResult invokeV;
        s24 s24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t24.class) {
                if (a == null) {
                    a = new s24();
                }
                s24Var = a;
            }
            return s24Var;
        }
        return (s24) invokeV.objValue;
    }
}
