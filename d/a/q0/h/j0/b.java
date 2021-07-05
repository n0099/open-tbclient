package d.a.q0.h.j0;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(d.a.q0.a.l0.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, aVar) == null) && aVar != null && aVar.p().hasEventListener("audiointerruptionbegin") && d.a.q0.h.c.j.b.h().i()) {
            aVar.F(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(d.a.q0.a.l0.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, aVar) == null) && aVar != null && aVar.p().hasEventListener("audiointerruptionend")) {
            aVar.F(new JSEvent("audiointerruptionend"));
        }
    }
}
