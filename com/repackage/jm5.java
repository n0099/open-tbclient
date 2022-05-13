package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jm5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile im5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized im5 a() {
        InterceptResult invokeV;
        im5 im5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jm5.class) {
                if (a == null) {
                    a = new im5();
                }
                im5Var = a;
            }
            return im5Var;
        }
        return (im5) invokeV.objValue;
    }
}
