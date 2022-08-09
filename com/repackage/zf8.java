package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zf8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yf8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yf8 a() {
        InterceptResult invokeV;
        yf8 yf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zf8.class) {
                if (a == null) {
                    a = new yf8();
                }
                yf8Var = a;
            }
            return yf8Var;
        }
        return (yf8) invokeV.objValue;
    }
}
