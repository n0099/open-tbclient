package d.a.p0.s.q;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f53296a;

    /* renamed from: b  reason: collision with root package name */
    public int f53297b;

    /* renamed from: c  reason: collision with root package name */
    public String f53298c;

    /* renamed from: d  reason: collision with root package name */
    public String f53299d;

    /* renamed from: e  reason: collision with root package name */
    public String f53300e;

    /* renamed from: f  reason: collision with root package name */
    public String f53301f;

    /* renamed from: g  reason: collision with root package name */
    public String f53302g;

    /* renamed from: h  reason: collision with root package name */
    public String f53303h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53304i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1136863238, "Ld/a/p0/s/q/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1136863238, "Ld/a/p0/s/q/e;");
                return;
            }
        }
        j = new HashSet();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? j.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.a4) == null || eVar.f53304i || a(eVar.f53303h)) {
            return;
        }
        d.a.q0.w2.i0.c b2 = d.a.q0.w2.i0.g.b(advertAppInfo, 3, eVar.f53297b);
        b2.h(eVar.f53296a);
        b2.a("isCache", eVar.f53298c);
        b2.e(eVar.f53300e);
        b2.f(eVar.f53301f);
        b2.g(eVar.f53299d);
        b2.a("vc", eVar.f53302g);
        b2.t(eVar.f53303h);
        d.a.q0.w2.i0.e.b().d(b2);
        d.a.q0.n1.o.h.c.g(d.a.q0.n1.o.h.c.e(advertAppInfo));
        eVar.f53304i = true;
        j.add(eVar.f53303h);
    }

    public static void c(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f53304i || a(eVar.f53303h)) {
            return;
        }
        d.a.q0.w2.i0.c g2 = d.a.q0.w2.i0.g.g(z ? 13 : 3, i2, eVar.f53297b);
        g2.h(eVar.f53296a);
        g2.a("isCache", String.valueOf(eVar.f53298c));
        g2.e(eVar.f53300e);
        g2.f(eVar.f53301f);
        g2.g(eVar.f53299d);
        g2.a("vc", eVar.f53302g);
        g2.t(eVar.f53303h);
        d.a.q0.w2.i0.e.b().d(g2);
        eVar.f53304i = true;
        j.add(eVar.f53303h);
    }

    public static void d(d.a.q0.a0.e0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, dVar) == null) || dVar == null || dVar.c() == null || dVar.c().a4 == null || dVar.c().a4.f53304i || a(dVar.c().a4.f53303h)) {
            return;
        }
        dVar.c().b4 = dVar.c().a4.f53296a;
        d.a.q0.w2.i0.c c2 = d.a.q0.w2.i0.g.c(dVar.c(), 3, dVar.c().a4.f53297b);
        c2.t(dVar.c().a4.f53303h);
        d.a.q0.w2.i0.e.b().d(c2);
        d.a.q0.n1.o.h.c.g(d.a.q0.n1.o.h.c.e(dVar.c()));
        dVar.c().a4.f53304i = true;
        j.add(dVar.c().a4.f53303h);
    }

    public static void e(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f53304i || a(eVar.f53303h)) {
            return;
        }
        d.a.q0.w2.i0.c g2 = d.a.q0.w2.i0.g.g(z ? 13 : 3, i2, eVar.f53297b);
        g2.h(eVar.f53296a);
        g2.t(eVar.f53303h);
        d.a.q0.w2.i0.e.b().d(g2);
        eVar.f53304i = true;
        j.add(eVar.f53303h);
    }

    public static void f(d.a.q0.h3.h0.o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, oVar) == null) || oVar == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = oVar.getAdvertAppInfo().a4;
        if (oVar.L0 || !(eVar == null || eVar.f53304i || a(eVar.f53303h))) {
            oVar.F0 = eVar.f53300e;
            oVar.G0 = eVar.f53301f;
            oVar.E0 = eVar.f53299d;
            int i2 = 3;
            if (oVar != null && oVar.F0() != null && oVar.F0().forFree()) {
                i2 = 103;
            }
            d.a.q0.w2.i0.c e2 = d.a.q0.w2.i0.g.e(oVar, i2);
            e2.t(eVar.f53303h);
            d.a.q0.w2.i0.e.b().d(e2);
            if (!oVar.L0) {
                d.a.q0.n1.o.h.c.g(d.a.q0.n1.o.h.c.e(oVar.getAdvertAppInfo()));
            }
            eVar.f53304i = true;
            j.add(eVar.f53303h);
        }
    }

    public static void g(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f53304i || a(eVar.f53303h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        d.a.q0.w2.i0.c cVar = new d.a.q0.w2.i0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(eVar.f53296a)) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(i2);
            cVar.v(eVar.f53297b);
        }
        cVar.h(eVar.f53296a);
        cVar.e(eVar.f53300e);
        cVar.f(eVar.f53301f);
        cVar.g(eVar.f53299d);
        cVar.a("vc", eVar.f53302g);
        cVar.t(eVar.f53303h);
        d.a.q0.w2.i0.e.b().d(cVar);
        eVar.f53304i = true;
        j.add(eVar.f53303h);
    }

    public static void h(d.a.e.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.d() == null || dVar.f42485i || TextUtils.isEmpty(dVar.d().f42487b) || a(dVar.d().f42487b)) {
            return;
        }
        d.a.q0.w2.i0.e.b().d(d.a.q0.w2.i0.g.a(dVar, 3, dVar.e()));
        d.a.q0.n1.o.h.c.g(dVar);
        dVar.f42485i = true;
        j.add(dVar.d().f42487b);
    }
}
