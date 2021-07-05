package d.a.d.m;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.s0.w2.i0.e;
import d.a.s0.w2.i0.g;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(d.a.d.m.g.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, aVar, str) == null) {
            d.a.s0.w2.i0.c f2 = g.f(aVar);
            f2.c(str);
            f2.j(aVar.f45229h);
            e.b().d(f2);
        }
    }

    public static void b(d.a.d.m.g.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, aVar, i2) == null) {
            d.a.s0.w2.i0.c f2 = g.f(aVar);
            f2.j(aVar.f45229h);
            f2.l(aVar.f45227f);
            f2.m(i2);
            e.b().d(f2);
        }
    }

    public static void c(d.a.d.m.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            e.b().d(g.q(aVar));
        }
    }

    public static void d(d.a.d.m.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            e.b().d(g.p(aVar));
        }
    }

    public static void e(d.a.d.m.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, aVar) == null) {
            d.a.s0.w2.i0.c f2 = g.f(aVar);
            f2.j(aVar.f45229h);
            e.b().d(f2);
        }
    }

    public static void f(d.a.d.m.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, aVar) == null) {
            e.b().d(g.q(aVar));
        }
    }

    public static void g(d.a.d.m.g.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, aVar, i2) == null) {
            d.a.s0.w2.i0.c n = g.n(aVar);
            n.i(SDKLogTypeConstants.CLOSE_GAME_TYPE);
            boolean z = i2 == 1000;
            n.c(z ? "APP" : "URL");
            if (!z) {
                n.l(i2);
            }
            n.h("DEEPLINK");
            e.b().d(n);
        }
    }
}
