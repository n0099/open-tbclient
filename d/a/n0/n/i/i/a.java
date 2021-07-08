package d.a.n0.n.i.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.n0.n.h.g;
import d.a.n0.n.i.i.g.d;
import d.a.n0.n.i.i.g.f;
import d.a.n0.n.i.i.g.h;
import d.a.n0.n.i.i.g.i;
import d.a.n0.n.i.l.c;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull d.a.n0.n.i.l.a aVar, @Nullable List<g> list, @NonNull d.a.n0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, aVar, list, gVar) == null) {
            i a2 = d.a.n0.n.i.i.c.a.a(aVar, gVar);
            if (list != null && !list.isEmpty()) {
                for (f<g> fVar : h.g(list, gVar)) {
                    a2.c(d.b().a(fVar));
                }
            }
            a2.e();
        }
    }

    public static void b(d.a.n0.n.i.l.b bVar, d.a.n0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bVar, gVar) == null) {
            d.a.n0.n.i.i.c.a.b(bVar, gVar);
        }
    }

    public static void c(c cVar, d.a.n0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cVar, gVar) == null) {
            d.a.n0.n.i.i.c.a.c(cVar, gVar);
        }
    }

    public static void d(d.a.n0.n.i.l.d dVar, d.a.n0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, dVar, gVar) == null) {
            d.a.n0.n.i.i.c.a.d(dVar, gVar);
        }
    }

    public static void e(d.a.n0.n.j.k.a aVar, d.a.n0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, gVar) == null) {
            d.a.n0.n.i.i.c.a.e(aVar, gVar);
        }
    }
}
