package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ke8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile je8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized je8 a() {
        InterceptResult invokeV;
        je8 je8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ke8.class) {
                if (a == null) {
                    a = new je8();
                }
                je8Var = a;
            }
            return je8Var;
        }
        return (je8) invokeV.objValue;
    }
}
