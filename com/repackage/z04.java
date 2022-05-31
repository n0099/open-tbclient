package com.repackage;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class z04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(p62 p62Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, p62Var) == null) && p62Var != null && p62Var.p().hasEventListener("audiointerruptionbegin") && jt3.h().i()) {
            p62Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(p62 p62Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, p62Var) == null) && p62Var != null && p62Var.p().hasEventListener("audiointerruptionend")) {
            p62Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
