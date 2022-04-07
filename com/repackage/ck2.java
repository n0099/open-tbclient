package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ck2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bk2 a() {
        InterceptResult invokeV;
        bk2 bk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ck2.class) {
                if (a == null) {
                    a = new bk2();
                }
                bk2Var = a;
            }
            return bk2Var;
        }
        return (bk2) invokeV.objValue;
    }
}
