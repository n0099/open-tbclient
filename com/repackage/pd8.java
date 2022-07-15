package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class pd8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile od8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized od8 a() {
        InterceptResult invokeV;
        od8 od8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pd8.class) {
                if (a == null) {
                    a = new od8();
                }
                od8Var = a;
            }
            return od8Var;
        }
        return (od8) invokeV.objValue;
    }
}
