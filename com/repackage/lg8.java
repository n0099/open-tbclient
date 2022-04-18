package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kg8 a() {
        InterceptResult invokeV;
        kg8 kg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lg8.class) {
                if (a == null) {
                    a = new kg8();
                }
                kg8Var = a;
            }
            return kg8Var;
        }
        return (kg8) invokeV.objValue;
    }
}
