package com.repackage;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class n82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static h82 a(o82 o82Var, e92 e92Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, o82Var, e92Var, v8ThreadDelegatePolicy)) == null) {
            p82 a = gk2.B0().a(o82Var);
            h82 a2 = a.a(o82Var.a(), e92Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (h82) invokeLLL.objValue;
    }

    public static h82 b(o82 o82Var, e92 e92Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, o82Var, e92Var, v8ThreadDelegatePolicy)) == null) {
            h82 a = a(o82Var, e92Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (h82) invokeLLL.objValue;
    }
}
