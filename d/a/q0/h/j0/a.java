package d.a.q0.h.j0;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(d.a.q0.a.l0.a aVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, aVar, str) == null) && aVar != null && aVar.p().hasEventListener("deviceOrientationChange")) {
            JSEvent jSEvent = new JSEvent("deviceOrientationChange");
            jSEvent.data = new d.a.q0.h.j0.c.a(str);
            aVar.F(jSEvent);
        }
    }
}
