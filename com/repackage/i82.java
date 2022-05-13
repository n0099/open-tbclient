package com.repackage;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class i82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c82 a(j82 j82Var, z82 z82Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, j82Var, z82Var, v8ThreadDelegatePolicy)) == null) {
            k82 a = bk2.B0().a(j82Var);
            c82 b = a.b(j82Var.a(), z82Var, v8ThreadDelegatePolicy);
            b.K0(a.a());
            return b;
        }
        return (c82) invokeLLL.objValue;
    }

    public static c82 b(j82 j82Var, z82 z82Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, j82Var, z82Var, v8ThreadDelegatePolicy)) == null) {
            c82 a = a(j82Var, z82Var, v8ThreadDelegatePolicy);
            a.s0();
            return a;
        }
        return (c82) invokeLLL.objValue;
    }
}
