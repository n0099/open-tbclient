package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ri2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qi2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qi2 a() {
        InterceptResult invokeV;
        qi2 qi2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ri2.class) {
                if (a == null) {
                    a = new qi2();
                }
                qi2Var = a;
            }
            return qi2Var;
        }
        return (qi2) invokeV.objValue;
    }
}
