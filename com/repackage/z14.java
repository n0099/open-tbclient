package com.repackage;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class z14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(p72 p72Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, p72Var) == null) && p72Var != null && p72Var.o().hasEventListener("audiointerruptionbegin") && ju3.h().i()) {
            p72Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(p72 p72Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, p72Var) == null) && p72Var != null && p72Var.o().hasEventListener("audiointerruptionend")) {
            p72Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
