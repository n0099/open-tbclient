package d.a.o0.a.c2.f.p0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a1.e;
import d.a.o0.a.h0.m.o.a;
import d.a.o0.a.v2.o0;
import d.a.o0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44319a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f44320a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f44321b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f44322c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44323d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44324e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44325f;

        public a(boolean z, d.a.o0.a.a2.e eVar, d dVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), eVar, dVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44320a = z;
            this.f44321b = eVar;
            this.f44322c = dVar;
            this.f44323d = str;
            this.f44324e = str2;
            this.f44325f = str3;
        }

        @Override // d.a.o0.a.h0.m.o.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.h(this.f44320a, this.f44321b.f43885f, "pkg_retry_fail", String.valueOf(2113));
                this.f44322c.b(2113);
            }
        }

        @Override // d.a.o0.a.h0.m.o.a.b
        public void b(d.a.o0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                boolean n = g.n(this.f44321b.f43885f, aVar);
                if (g.f44319a) {
                    Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + n + ",isRetry:" + this.f44320a + ",pmsErrorCode:" + aVar);
                }
                if (n) {
                    g.i(this.f44321b.f43885f, aVar);
                    d.a.o0.a.f1.d.b.a.b().a(this.f44321b.f43885f);
                    g.j(this.f44321b, this.f44324e, this.f44323d, this.f44322c, this.f44325f, true);
                    return;
                }
                d.a.o0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.o0.a.h.swanapp_tip_package_unavailable).F();
                g.h(this.f44320a, this.f44321b.f43885f, "pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f44322c.b(2113);
            }
        }

        @Override // d.a.o0.a.h0.m.o.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                g.h(this.f44320a, this.f44321b.f43885f, "pkg_retry_success", "");
                this.f44322c.a(this.f44323d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements d.a.o0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44326a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f44327b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44328c;

        public b(String str, d dVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, dVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44326a = str;
            this.f44327b = dVar;
            this.f44328c = str2;
        }

        @Override // d.a.o0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
                if (i2 != null) {
                    i2.y0(this.f44326a, true);
                }
                this.f44327b.a(this.f44328c);
            }
        }

        @Override // d.a.o0.a.h0.m.b
        public void b(int i2, d.a.o0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f44327b.b(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements d.a.o0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44329a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f44330b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44331c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f44332d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44333e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44334f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44335g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44336h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44337i;

        public c(String str, boolean z, String str2, d dVar, String str3, String str4, String str5, String str6, String str7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), str2, dVar, str3, str4, str5, str6, str7};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44329a = str;
            this.f44330b = z;
            this.f44331c = str2;
            this.f44332d = dVar;
            this.f44333e = str3;
            this.f44334f = str4;
            this.f44335g = str5;
            this.f44336h = str6;
            this.f44337i = str7;
        }

        @Override // d.a.o0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.a2.d.g().r().y0(this.f44329a, true);
                g.h(this.f44330b, this.f44331c, "sub_pkg_retry_success", "");
                this.f44332d.a(this.f44333e);
            }
        }

        @Override // d.a.o0.a.h0.m.b
        public void b(int i2, d.a.o0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                boolean n = g.n(this.f44331c, aVar);
                if (g.f44319a) {
                    Log.d("PagesRoute", "isNeedGetPkgRetry:" + n + ",isRetry:" + this.f44330b + ",pmsErrorCode:" + aVar);
                }
                if (n) {
                    g.i(this.f44334f, aVar);
                    d.a.o0.a.f1.d.b.a.b().a(this.f44331c);
                    g.m(this.f44334f, this.f44335g, this.f44336h, this.f44329a, this.f44337i, this.f44333e, this.f44332d, true);
                    return;
                }
                g.h(this.f44330b, this.f44331c, "sub_pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f44332d.b(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(String str);

        void b(int i2);
    }

    /* loaded from: classes7.dex */
    public static class e implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d f44338a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f44339b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f44340e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f44341f;

            public a(e eVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44341f = eVar;
                this.f44340e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44341f.f44338a.a(this.f44340e);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f44342e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f44343f;

            public b(e eVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44343f = eVar;
                this.f44342e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f44343f.f44339b) {
                        d.a.o0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.o0.a.h.swanapp_tip_package_unavailable).F();
                    }
                    this.f44343f.f44338a.b(this.f44342e);
                }
            }
        }

        public e(@NonNull d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44338a = dVar;
            this.f44339b = z;
        }

        @Override // d.a.o0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                q0.b0(new a(this, str));
            }
        }

        @Override // d.a.o0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                q0.b0(new b(this, i2));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1877385297, "Ld/a/o0/a/c2/f/p0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1877385297, "Ld/a/o0/a/c2/f/p0/g;");
                return;
            }
        }
        f44319a = d.a.o0.a.k.f46335a;
    }

    public static void g(d.a.o0.a.a2.e eVar, d.a.o0.a.l1.b bVar, String str, d dVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, eVar, bVar, str, dVar, str2) == null) {
            if (eVar != null) {
                eVar.B().e(eVar.getAppId());
            }
            if (dVar == null) {
                return;
            }
            if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.f46493e) && !TextUtils.isEmpty(bVar.f46496h)) {
                String str3 = bVar.f46496h;
                String R = eVar.R(bVar.f46493e);
                boolean h0 = eVar.h0(str3);
                if (!d.a.o0.a.e0.f.e.e.d() && !d.a.o0.a.u1.a.a.G() && !d.a.o0.a.u1.a.a.C()) {
                    if (d.a.o0.a.t1.b.a.e(bVar.f46493e)) {
                        dVar.a(str);
                        return;
                    }
                    if (h0) {
                        if (d.a.o0.a.a1.e.A(eVar.f43885f, eVar.Z())) {
                            dVar.a(str);
                            return;
                        } else if (eVar.e0()) {
                            j(eVar, str3, str, dVar, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(R)) {
                        dVar.b(2111);
                        return;
                    } else if (eVar.j0(R)) {
                        dVar.a(str);
                        return;
                    } else if (eVar.l0(R) && eVar.k0(R)) {
                        dVar.a(str);
                        eVar.y0(R, true);
                        return;
                    } else {
                        String G = eVar.G(R);
                        if (TextUtils.isEmpty(G)) {
                            dVar.b(2112);
                            return;
                        }
                        boolean g0 = eVar.g0(str3);
                        if (!d.a.o0.a.a1.e.A(eVar.f43885f, eVar.Z()) && !g0) {
                            j(eVar, str3, str, dVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2);
                        q.C(new UbcFlowEvent("na_start_sub_package_download"));
                        q.A("sub_state", "1");
                        l(eVar.f43885f, eVar.Z(), "3", R, G, str, new e(dVar, true));
                        return;
                    }
                } else if (!h0 && TextUtils.isEmpty(R)) {
                    dVar.b(2111);
                    return;
                } else {
                    dVar.a(str);
                    return;
                }
            }
            dVar.b(2110);
        }
    }

    public static void h(boolean z, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) && z) {
            d.a.o0.a.f1.d.b.a.b().g(str);
            d.a.o0.a.j2.k.G(str2, str3);
        }
    }

    public static void i(String str, d.a.o0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, aVar) == null) {
            if ((aVar == null ? 0L : aVar.g()) == 2205) {
                d.a.o0.a.n0.f.c().d().u(d.a.o0.a.v2.z0.a.a(str), true, 12);
            }
        }
    }

    public static void j(d.a.o0.a.a2.e eVar, String str, String str2, d dVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{eVar, str, str2, dVar, str3, Boolean.valueOf(z)}) == null) || dVar == null) {
            return;
        }
        if (eVar == null) {
            dVar.b(2111);
            return;
        }
        HybridUbcFlow q = d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str3);
        q.C(new UbcFlowEvent("na_start_sub_package_download"));
        q.A("sub_state", "1");
        d.a.o0.n.i.m.c cVar = new d.a.o0.n.i.m.c(eVar.f43885f, d.a.o0.a.a2.d.g().l());
        cVar.o(q0.o(eVar.Z()));
        cVar.r(str);
        d.a.o0.n.b.b(cVar, new d.a.o0.a.h0.m.o.a(eVar.f43885f, new a(z, eVar, dVar, str2, str, str3)));
    }

    public static void k(String str, String str2, String str3, String str4, String str5, String str6, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, str2, str3, str4, str5, str6, dVar}) == null) || dVar == null) {
            return;
        }
        d.a.o0.n.i.m.f fVar = new d.a.o0.n.i.m.f(str, str2, str5, 0);
        fVar.d(str3);
        d.a.o0.n.b.f(fVar, new d.a.o0.a.h0.m.q.a(str, str2, new b(str4, dVar, str6)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, dVar}) == null) {
            m(str, str2, str3, str4, str5, str6, dVar, false);
        }
    }

    public static void m(String str, String str2, String str3, String str4, String str5, String str6, d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{str, str2, str3, str4, str5, str6, dVar, Boolean.valueOf(z)}) == null) || dVar == null) {
            return;
        }
        String e2 = d.a.o0.a.f1.d.b.a.b().e(str, str4);
        d.a.o0.n.i.m.f fVar = new d.a.o0.n.i.m.f(str, str2, str5, 0);
        fVar.d(str3);
        d.a.o0.n.b.f(fVar, new d.a.o0.a.h0.m.q.a(str, str2, new c(str4, z, e2, dVar, str6, str, str2, str3, str5)));
    }

    public static boolean n(String str, d.a.o0.a.q2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, aVar)) == null) {
            long g2 = aVar == null ? 0L : aVar.g();
            return SwanAppNetworkUtils.i(d.a.o0.a.c1.a.b()) && d.a.o0.a.f1.d.b.a.b().f(str) && (g2 == 2101 || g2 == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean o(d.a.o0.a.f1.e.b bVar, e.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, bVar, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return p(bVar, gVar.f43828b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(d.a.o0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, bVar, swanAppConfigData)) == null) {
            if (bVar != null && !TextUtils.isEmpty(bVar.e0()) && !d.a.o0.a.e0.f.e.e.d() && !d.a.o0.a.u1.a.a.C()) {
                String f2 = o0.f(bVar.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.f11500b != null) {
                    String c2 = j.c(f2, swanAppConfigData);
                    if (swanAppConfigData.f11500b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.f11501c.f11536c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (d.a.o0.n.g.a.h().m(bVar.H(), bVar.u1(), str)) {
                            return !new File(e.C0638e.i(bVar.H(), bVar.u1()), str).exists();
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
