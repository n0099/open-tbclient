package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gh3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fh3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fh3 a() {
        InterceptResult invokeV;
        fh3 fh3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gh3.class) {
                if (a == null) {
                    a = new fh3();
                }
                fh3Var = a;
            }
            return fh3Var;
        }
        return (fh3) invokeV.objValue;
    }
}
