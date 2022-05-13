package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class on5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nn5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nn5 a() {
        InterceptResult invokeV;
        nn5 nn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (on5.class) {
                if (a == null) {
                    a = new nn5();
                }
                nn5Var = a;
            }
            return nn5Var;
        }
        return (nn5) invokeV.objValue;
    }
}
