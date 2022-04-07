package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class wf8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vf8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vf8 a() {
        InterceptResult invokeV;
        vf8 vf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wf8.class) {
                if (a == null) {
                    a = new vf8();
                }
                vf8Var = a;
            }
            return vf8Var;
        }
        return (vf8) invokeV.objValue;
    }
}
