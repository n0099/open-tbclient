package com.repackage;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class v72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static p72 a(w72 w72Var, m82 m82Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, w72Var, m82Var, v8ThreadDelegatePolicy)) == null) {
            x72 a = oj2.B0().a(w72Var);
            p72 a2 = a.a(w72Var.a(), m82Var, v8ThreadDelegatePolicy);
            a2.J0(a.getUserAgent());
            return a2;
        }
        return (p72) invokeLLL.objValue;
    }

    public static p72 b(w72 w72Var, m82 m82Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, w72Var, m82Var, v8ThreadDelegatePolicy)) == null) {
            p72 a = a(w72Var, m82Var, v8ThreadDelegatePolicy);
            a.r0();
            return a;
        }
        return (p72) invokeLLL.objValue;
    }
}
