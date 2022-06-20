package com.repackage;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class g72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static a72 a(h72 h72Var, x72 x72Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, h72Var, x72Var, v8ThreadDelegatePolicy)) == null) {
            i72 a = zi2.B0().a(h72Var);
            a72 b = a.b(h72Var.a(), x72Var, v8ThreadDelegatePolicy);
            b.K0(a.a());
            return b;
        }
        return (a72) invokeLLL.objValue;
    }

    public static a72 b(h72 h72Var, x72 x72Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, h72Var, x72Var, v8ThreadDelegatePolicy)) == null) {
            a72 a = a(h72Var, x72Var, v8ThreadDelegatePolicy);
            a.s0();
            return a;
        }
        return (a72) invokeLLL.objValue;
    }
}
