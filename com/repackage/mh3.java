package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mh3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lh3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lh3 a() {
        InterceptResult invokeV;
        lh3 lh3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mh3.class) {
                if (a == null) {
                    a = new lh3();
                }
                lh3Var = a;
            }
            return lh3Var;
        }
        return (lh3) invokeV.objValue;
    }
}
