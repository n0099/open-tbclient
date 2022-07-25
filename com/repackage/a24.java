package com.repackage;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(q72 q72Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, q72Var) == null) && q72Var != null && q72Var.o().hasEventListener("audiointerruptionbegin") && ku3.h().i()) {
            q72Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(q72 q72Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, q72Var) == null) && q72Var != null && q72Var.o().hasEventListener("audiointerruptionend")) {
            q72Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
