package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class s24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r24 a() {
        InterceptResult invokeV;
        r24 r24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s24.class) {
                if (a == null) {
                    a = new r24();
                }
                r24Var = a;
            }
            return r24Var;
        }
        return (r24) invokeV.objValue;
    }
}
