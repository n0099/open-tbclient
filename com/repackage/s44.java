package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class s44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r44 a() {
        InterceptResult invokeV;
        r44 r44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s44.class) {
                if (a == null) {
                    a = new r44();
                }
                r44Var = a;
            }
            return r44Var;
        }
        return (r44) invokeV.objValue;
    }
}
