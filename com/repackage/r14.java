package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class r14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q14 a() {
        InterceptResult invokeV;
        q14 q14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r14.class) {
                if (a == null) {
                    a = new q14();
                }
                q14Var = a;
            }
            return q14Var;
        }
        return (q14) invokeV.objValue;
    }
}
