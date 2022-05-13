package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class um5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tm5 a() {
        InterceptResult invokeV;
        tm5 tm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (um5.class) {
                if (a == null) {
                    a = new tm5();
                }
                tm5Var = a;
            }
            return tm5Var;
        }
        return (tm5) invokeV.objValue;
    }
}
