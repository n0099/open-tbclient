package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j04 a() {
        InterceptResult invokeV;
        j04 j04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k04.class) {
                if (a == null) {
                    a = new j04();
                }
                j04Var = a;
            }
            return j04Var;
        }
        return (j04) invokeV.objValue;
    }
}
