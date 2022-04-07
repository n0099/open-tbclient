package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l24 a() {
        InterceptResult invokeV;
        l24 l24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m24.class) {
                if (a == null) {
                    a = new l24();
                }
                l24Var = a;
            }
            return l24Var;
        }
        return (l24) invokeV.objValue;
    }
}
