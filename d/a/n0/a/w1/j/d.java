package d.a.n0.a.w1.j;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.j2.k;
/* loaded from: classes7.dex */
public class d extends d.a.n0.a.j2.p.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            b.a L = d.a.n0.a.a2.d.g().r().L();
            d.a.n0.a.j2.p.f fVar = new d.a.n0.a.j2.p.f();
            fVar.f45818b = str;
            fVar.f45817a = k.m(L.G());
            fVar.f45822f = L.H();
            fVar.f45819c = L.T();
            k.u("1088", fVar);
        }
    }
}
