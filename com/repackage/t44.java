package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class t44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s44 a() {
        InterceptResult invokeV;
        s44 s44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t44.class) {
                if (a == null) {
                    a = new s44();
                }
                s44Var = a;
            }
            return s44Var;
        }
        return (s44) invokeV.objValue;
    }
}
