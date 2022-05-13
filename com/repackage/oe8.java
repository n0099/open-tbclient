package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class oe8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ne8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ne8 a() {
        InterceptResult invokeV;
        ne8 ne8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oe8.class) {
                if (a == null) {
                    a = new ne8();
                }
                ne8Var = a;
            }
            return ne8Var;
        }
        return (ne8) invokeV.objValue;
    }
}
