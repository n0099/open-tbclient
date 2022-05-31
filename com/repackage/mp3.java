package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lp3 a() {
        InterceptResult invokeV;
        lp3 lp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mp3.class) {
                if (a == null) {
                    a = new lp3();
                }
                lp3Var = a;
            }
            return lp3Var;
        }
        return (lp3) invokeV.objValue;
    }
}
