package d.a.r0.r.q;

import android.text.TextUtils;
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
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f55917a;

    /* renamed from: b  reason: collision with root package name */
    public int f55918b;

    /* renamed from: c  reason: collision with root package name */
    public String f55919c;

    /* renamed from: d  reason: collision with root package name */
    public String f55920d;

    /* renamed from: e  reason: collision with root package name */
    public String f55921e;

    /* renamed from: f  reason: collision with root package name */
    public String f55922f;

    /* renamed from: g  reason: collision with root package name */
    public String f55923g;

    /* renamed from: h  reason: collision with root package name */
    public String f55924h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55925i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-485434019, "Ld/a/r0/r/q/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-485434019, "Ld/a/r0/r/q/e;");
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
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.U3) == null || eVar.f55925i || a(eVar.f55924h)) {
            return;
        }
        d.a.s0.w2.i0.c b2 = d.a.s0.w2.i0.g.b(advertAppInfo, 3, eVar.f55918b);
        b2.h(eVar.f55917a);
        b2.a("isCache", eVar.f55919c);
        b2.e(eVar.f55921e);
        b2.f(eVar.f55922f);
        b2.g(eVar.f55920d);
        b2.a("vc", eVar.f55923g);
        b2.t(eVar.f55924h);
        d.a.s0.w2.i0.e.b().d(b2);
        d.a.s0.n1.o.h.c.g(d.a.s0.n1.o.h.c.e(advertAppInfo));
        eVar.f55925i = true;
        j.add(eVar.f55924h);
    }

    public static void c(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f55925i || a(eVar.f55924h)) {
            return;
        }
        d.a.s0.w2.i0.c g2 = d.a.s0.w2.i0.g.g(z ? 13 : 3, i2, eVar.f55918b);
        g2.h(eVar.f55917a);
        g2.a("isCache", String.valueOf(eVar.f55919c));
        g2.e(eVar.f55921e);
        g2.f(eVar.f55922f);
        g2.g(eVar.f55920d);
        g2.a("vc", eVar.f55923g);
        g2.t(eVar.f55924h);
        d.a.s0.w2.i0.e.b().d(g2);
        eVar.f55925i = true;
        j.add(eVar.f55924h);
    }

    public static void d(d.a.s0.a0.e0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, dVar) == null) || dVar == null || dVar.c() == null || dVar.c().U3 == null || dVar.c().U3.f55925i || a(dVar.c().U3.f55924h)) {
            return;
        }
        dVar.c().V3 = dVar.c().U3.f55917a;
        d.a.s0.w2.i0.c c2 = d.a.s0.w2.i0.g.c(dVar.c(), 3, dVar.c().U3.f55918b);
        c2.t(dVar.c().U3.f55924h);
        d.a.s0.w2.i0.e.b().d(c2);
        d.a.s0.n1.o.h.c.g(d.a.s0.n1.o.h.c.e(dVar.c()));
        dVar.c().U3.f55925i = true;
        j.add(dVar.c().U3.f55924h);
    }

    public static void e(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f55925i || a(eVar.f55924h)) {
            return;
        }
        d.a.s0.w2.i0.c g2 = d.a.s0.w2.i0.g.g(z ? 13 : 3, i2, eVar.f55918b);
        g2.h(eVar.f55917a);
        g2.t(eVar.f55924h);
        d.a.s0.w2.i0.e.b().d(g2);
        eVar.f55925i = true;
        j.add(eVar.f55924h);
    }

    public static void f(d.a.s0.h3.h0.o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, oVar) == null) || oVar == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = oVar.getAdvertAppInfo().U3;
        if (oVar.L0 || !(eVar == null || eVar.f55925i || a(eVar.f55924h))) {
            oVar.F0 = eVar.f55921e;
            oVar.G0 = eVar.f55922f;
            oVar.E0 = eVar.f55920d;
            int i2 = 3;
            if (oVar != null && oVar.F0() != null && oVar.F0().forFree()) {
                i2 = 103;
            }
            d.a.s0.w2.i0.c e2 = d.a.s0.w2.i0.g.e(oVar, i2);
            e2.t(eVar.f55924h);
            d.a.s0.w2.i0.e.b().d(e2);
            if (!oVar.L0) {
                d.a.s0.n1.o.h.c.g(d.a.s0.n1.o.h.c.e(oVar.getAdvertAppInfo()));
            }
            eVar.f55925i = true;
            j.add(eVar.f55924h);
        }
    }

    public static void g(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f55925i || a(eVar.f55924h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        d.a.s0.w2.i0.c cVar = new d.a.s0.w2.i0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(eVar.f55917a)) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(i2);
            cVar.v(eVar.f55918b);
        }
        cVar.h(eVar.f55917a);
        cVar.e(eVar.f55921e);
        cVar.f(eVar.f55922f);
        cVar.g(eVar.f55920d);
        cVar.a("vc", eVar.f55923g);
        cVar.t(eVar.f55924h);
        d.a.s0.w2.i0.e.b().d(cVar);
        eVar.f55925i = true;
        j.add(eVar.f55924h);
    }

    public static void h(d.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.d() == null || dVar.f45179i || TextUtils.isEmpty(dVar.d().f45181b) || a(dVar.d().f45181b)) {
            return;
        }
        d.a.s0.w2.i0.e.b().d(d.a.s0.w2.i0.g.a(dVar, 3, dVar.e()));
        d.a.s0.n1.o.h.c.g(dVar);
        dVar.f45179i = true;
        j.add(dVar.d().f45181b);
    }
}
