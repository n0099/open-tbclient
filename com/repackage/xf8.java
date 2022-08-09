package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xf8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wf8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wf8 a() {
        InterceptResult invokeV;
        wf8 wf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xf8.class) {
                if (a == null) {
                    a = new wf8();
                }
                wf8Var = a;
            }
            return wf8Var;
        }
        return (wf8) invokeV.objValue;
    }
}
