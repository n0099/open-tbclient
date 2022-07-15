package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ri3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qi3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qi3 a() {
        InterceptResult invokeV;
        qi3 qi3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ri3.class) {
                if (a == null) {
                    a = new qi3();
                }
                qi3Var = a;
            }
            return qi3Var;
        }
        return (qi3) invokeV.objValue;
    }
}
