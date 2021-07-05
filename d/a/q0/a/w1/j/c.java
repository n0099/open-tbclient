package d.a.q0.a.w1.j;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.j2.k;
/* loaded from: classes8.dex */
public class c extends d.a.q0.a.j2.p.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            b.a L = d.a.q0.a.a2.d.g().r().L();
            d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
            fVar.f49120b = str;
            fVar.f49119a = k.m(L.G());
            fVar.f49124f = L.H();
            fVar.f49121c = L.T();
            k.u("1045", fVar);
        }
    }
}
