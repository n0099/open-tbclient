package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yn3 a() {
        InterceptResult invokeV;
        yn3 yn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zn3.class) {
                if (a == null) {
                    a = new yn3();
                }
                yn3Var = a;
            }
            return yn3Var;
        }
        return (yn3) invokeV.objValue;
    }
}
