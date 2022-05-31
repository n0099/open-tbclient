package com.repackage;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class v62 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static p62 a(w62 w62Var, m72 m72Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, w62Var, m72Var, v8ThreadDelegatePolicy)) == null) {
            x62 a = oi2.B0().a(w62Var);
            p62 b = a.b(w62Var.a(), m72Var, v8ThreadDelegatePolicy);
            b.K0(a.a());
            return b;
        }
        return (p62) invokeLLL.objValue;
    }

    public static p62 b(w62 w62Var, m72 m72Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, w62Var, m72Var, v8ThreadDelegatePolicy)) == null) {
            p62 a = a(w62Var, m72Var, v8ThreadDelegatePolicy);
            a.s0();
            return a;
        }
        return (p62) invokeLLL.objValue;
    }
}
