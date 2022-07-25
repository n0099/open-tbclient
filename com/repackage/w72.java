package com.repackage;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class w72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static q72 a(x72 x72Var, n82 n82Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, x72Var, n82Var, v8ThreadDelegatePolicy)) == null) {
            y72 a = pj2.B0().a(x72Var);
            q72 a2 = a.a(x72Var.a(), n82Var, v8ThreadDelegatePolicy);
            a2.J0(a.getUserAgent());
            return a2;
        }
        return (q72) invokeLLL.objValue;
    }

    public static q72 b(x72 x72Var, n82 n82Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, x72Var, n82Var, v8ThreadDelegatePolicy)) == null) {
            q72 a = a(x72Var, n82Var, v8ThreadDelegatePolicy);
            a.r0();
            return a;
        }
        return (q72) invokeLLL.objValue;
    }
}
