package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lu0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ku0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ku0 a() {
        InterceptResult invokeV;
        ku0 ku0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lu0.class) {
                if (a == null) {
                    a = new ku0();
                }
                ku0Var = a;
            }
            return ku0Var;
        }
        return (ku0) invokeV.objValue;
    }
}
