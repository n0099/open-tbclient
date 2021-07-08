package d.a.o0.r.q;

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
    public String f52632a;

    /* renamed from: b  reason: collision with root package name */
    public int f52633b;

    /* renamed from: c  reason: collision with root package name */
    public String f52634c;

    /* renamed from: d  reason: collision with root package name */
    public String f52635d;

    /* renamed from: e  reason: collision with root package name */
    public String f52636e;

    /* renamed from: f  reason: collision with root package name */
    public String f52637f;

    /* renamed from: g  reason: collision with root package name */
    public String f52638g;

    /* renamed from: h  reason: collision with root package name */
    public String f52639h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52640i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(641962074, "Ld/a/o0/r/q/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(641962074, "Ld/a/o0/r/q/e;");
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
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.U3) == null || eVar.f52640i || a(eVar.f52639h)) {
            return;
        }
        d.a.p0.w2.i0.c b2 = d.a.p0.w2.i0.g.b(advertAppInfo, 3, eVar.f52633b);
        b2.h(eVar.f52632a);
        b2.a("isCache", eVar.f52634c);
        b2.e(eVar.f52636e);
        b2.f(eVar.f52637f);
        b2.g(eVar.f52635d);
        b2.a("vc", eVar.f52638g);
        b2.t(eVar.f52639h);
        d.a.p0.w2.i0.e.b().d(b2);
        d.a.p0.n1.o.h.c.g(d.a.p0.n1.o.h.c.e(advertAppInfo));
        eVar.f52640i = true;
        j.add(eVar.f52639h);
    }

    public static void c(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f52640i || a(eVar.f52639h)) {
            return;
        }
        d.a.p0.w2.i0.c g2 = d.a.p0.w2.i0.g.g(z ? 13 : 3, i2, eVar.f52633b);
        g2.h(eVar.f52632a);
        g2.a("isCache", String.valueOf(eVar.f52634c));
        g2.e(eVar.f52636e);
        g2.f(eVar.f52637f);
        g2.g(eVar.f52635d);
        g2.a("vc", eVar.f52638g);
        g2.t(eVar.f52639h);
        d.a.p0.w2.i0.e.b().d(g2);
        eVar.f52640i = true;
        j.add(eVar.f52639h);
    }

    public static void d(d.a.p0.a0.e0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, dVar) == null) || dVar == null || dVar.c() == null || dVar.c().U3 == null || dVar.c().U3.f52640i || a(dVar.c().U3.f52639h)) {
            return;
        }
        dVar.c().V3 = dVar.c().U3.f52632a;
        d.a.p0.w2.i0.c c2 = d.a.p0.w2.i0.g.c(dVar.c(), 3, dVar.c().U3.f52633b);
        c2.t(dVar.c().U3.f52639h);
        d.a.p0.w2.i0.e.b().d(c2);
        d.a.p0.n1.o.h.c.g(d.a.p0.n1.o.h.c.e(dVar.c()));
        dVar.c().U3.f52640i = true;
        j.add(dVar.c().U3.f52639h);
    }

    public static void e(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f52640i || a(eVar.f52639h)) {
            return;
        }
        d.a.p0.w2.i0.c g2 = d.a.p0.w2.i0.g.g(z ? 13 : 3, i2, eVar.f52633b);
        g2.h(eVar.f52632a);
        g2.t(eVar.f52639h);
        d.a.p0.w2.i0.e.b().d(g2);
        eVar.f52640i = true;
        j.add(eVar.f52639h);
    }

    public static void f(d.a.p0.h3.h0.o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, oVar) == null) || oVar == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = oVar.getAdvertAppInfo().U3;
        if (oVar.L0 || !(eVar == null || eVar.f52640i || a(eVar.f52639h))) {
            oVar.F0 = eVar.f52636e;
            oVar.G0 = eVar.f52637f;
            oVar.E0 = eVar.f52635d;
            int i2 = 3;
            if (oVar != null && oVar.F0() != null && oVar.F0().forFree()) {
                i2 = 103;
            }
            d.a.p0.w2.i0.c e2 = d.a.p0.w2.i0.g.e(oVar, i2);
            e2.t(eVar.f52639h);
            d.a.p0.w2.i0.e.b().d(e2);
            if (!oVar.L0) {
                d.a.p0.n1.o.h.c.g(d.a.p0.n1.o.h.c.e(oVar.getAdvertAppInfo()));
            }
            eVar.f52640i = true;
            j.add(eVar.f52639h);
        }
    }

    public static void g(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f52640i || a(eVar.f52639h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        d.a.p0.w2.i0.c cVar = new d.a.p0.w2.i0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(eVar.f52632a)) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(i2);
            cVar.v(eVar.f52633b);
        }
        cVar.h(eVar.f52632a);
        cVar.e(eVar.f52636e);
        cVar.f(eVar.f52637f);
        cVar.g(eVar.f52635d);
        cVar.a("vc", eVar.f52638g);
        cVar.t(eVar.f52639h);
        d.a.p0.w2.i0.e.b().d(cVar);
        eVar.f52640i = true;
        j.add(eVar.f52639h);
    }

    public static void h(d.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.d() == null || dVar.f41981i || TextUtils.isEmpty(dVar.d().f41983b) || a(dVar.d().f41983b)) {
            return;
        }
        d.a.p0.w2.i0.e.b().d(d.a.p0.w2.i0.g.a(dVar, 3, dVar.e()));
        d.a.p0.n1.o.h.c.g(dVar);
        dVar.f41981i = true;
        j.add(dVar.d().f41983b);
    }
}
