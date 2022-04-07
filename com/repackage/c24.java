package com.repackage;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(r72 r72Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, r72Var) == null) && r72Var != null && r72Var.p().hasEventListener("audiointerruptionbegin") && lu3.h().i()) {
            r72Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(r72 r72Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, r72Var) == null) && r72Var != null && r72Var.p().hasEventListener("audiointerruptionend")) {
            r72Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
