package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ol3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nl3 a() {
        InterceptResult invokeV;
        nl3 nl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ol3.class) {
                if (a == null) {
                    a = new nl3();
                }
                nl3Var = a;
            }
            return nl3Var;
        }
        return (nl3) invokeV.objValue;
    }
}
