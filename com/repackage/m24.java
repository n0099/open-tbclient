package com.repackage;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c82 c82Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, c82Var) == null) && c82Var != null && c82Var.p().hasEventListener("audiointerruptionbegin") && wu3.h().i()) {
            c82Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(c82 c82Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, c82Var) == null) && c82Var != null && c82Var.p().hasEventListener("audiointerruptionend")) {
            c82Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
