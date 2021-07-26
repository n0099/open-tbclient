package d.a.o0.a.w1.j;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.f1.e.b;
import d.a.o0.a.j2.k;
/* loaded from: classes7.dex */
public class d extends d.a.o0.a.j2.p.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            b.a L = d.a.o0.a.a2.d.g().r().L();
            d.a.o0.a.j2.p.f fVar = new d.a.o0.a.j2.p.f();
            fVar.f46322b = str;
            fVar.f46321a = k.m(L.G());
            fVar.f46326f = L.H();
            fVar.f46323c = L.T();
            k.u("1088", fVar);
        }
    }
}
