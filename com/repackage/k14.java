package com.repackage;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(a72 a72Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, a72Var) == null) && a72Var != null && a72Var.p().hasEventListener("audiointerruptionbegin") && ut3.h().i()) {
            a72Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(a72 a72Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, a72Var) == null) && a72Var != null && a72Var.p().hasEventListener("audiointerruptionend")) {
            a72Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
