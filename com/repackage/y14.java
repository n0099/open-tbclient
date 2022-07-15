package com.repackage;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(p72 p72Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, p72Var, str) == null) && p72Var != null && p72Var.o().hasEventListener("deviceOrientationChange")) {
            JSEvent jSEvent = new JSEvent("deviceOrientationChange");
            jSEvent.data = new a24(str);
            p72Var.dispatchEvent(jSEvent);
        }
    }
}
