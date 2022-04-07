package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ju0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iu0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized iu0 a() {
        InterceptResult invokeV;
        iu0 iu0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ju0.class) {
                if (a == null) {
                    a = new iu0();
                }
                iu0Var = a;
            }
            return iu0Var;
        }
        return (iu0) invokeV.objValue;
    }
}
