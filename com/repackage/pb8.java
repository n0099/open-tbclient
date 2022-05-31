package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class pb8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ob8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ob8 a() {
        InterceptResult invokeV;
        ob8 ob8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pb8.class) {
                if (a == null) {
                    a = new ob8();
                }
                ob8Var = a;
            }
            return ob8Var;
        }
        return (ob8) invokeV.objValue;
    }
}
