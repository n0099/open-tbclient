package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nd8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile md8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized md8 a() {
        InterceptResult invokeV;
        md8 md8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nd8.class) {
                if (a == null) {
                    a = new md8();
                }
                md8Var = a;
            }
            return md8Var;
        }
        return (md8) invokeV.objValue;
    }
}
