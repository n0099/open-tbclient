package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yq3 a() {
        InterceptResult invokeV;
        yq3 yq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zq3.class) {
                if (a == null) {
                    a = new yq3();
                }
                yq3Var = a;
            }
            return yq3Var;
        }
        return (yq3) invokeV.objValue;
    }
}
