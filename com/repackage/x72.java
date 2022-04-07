package com.repackage;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class x72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static r72 a(y72 y72Var, o82 o82Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, y72Var, o82Var, v8ThreadDelegatePolicy)) == null) {
            z72 a = qj2.B0().a(y72Var);
            r72 b = a.b(y72Var.a(), o82Var, v8ThreadDelegatePolicy);
            b.K0(a.a());
            return b;
        }
        return (r72) invokeLLL.objValue;
    }

    public static r72 b(y72 y72Var, o82 o82Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, y72Var, o82Var, v8ThreadDelegatePolicy)) == null) {
            r72 a = a(y72Var, o82Var, v8ThreadDelegatePolicy);
            a.s0();
            return a;
        }
        return (r72) invokeLLL.objValue;
    }
}
