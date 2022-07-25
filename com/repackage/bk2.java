package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ak2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ak2 a() {
        InterceptResult invokeV;
        ak2 ak2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bk2.class) {
                if (a == null) {
                    a = new ak2();
                }
                ak2Var = a;
            }
            return ak2Var;
        }
        return (ak2) invokeV.objValue;
    }
}
