package com.repackage;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class r24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(h82 h82Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, h82Var) == null) && h82Var != null && h82Var.m().hasEventListener("audiointerruptionbegin") && bv3.h().i()) {
            h82Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(h82 h82Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, h82Var) == null) && h82Var != null && h82Var.m().hasEventListener("audiointerruptionend")) {
            h82Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
