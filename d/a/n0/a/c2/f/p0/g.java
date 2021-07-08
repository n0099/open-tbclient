package d.a.n0.a.c2.f.p0;

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
import d.a.n0.a.a1.e;
import d.a.n0.a.h0.m.o.a;
import d.a.n0.a.v2.o0;
import d.a.n0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43815a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f43816a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f43817b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f43818c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f43819d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43820e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43821f;

        public a(boolean z, d.a.n0.a.a2.e eVar, d dVar, String str, String str2, String str3) {
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
            this.f43816a = z;
            this.f43817b = eVar;
            this.f43818c = dVar;
            this.f43819d = str;
            this.f43820e = str2;
            this.f43821f = str3;
        }

        @Override // d.a.n0.a.h0.m.o.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.h(this.f43816a, this.f43817b.f43381f, "pkg_retry_fail", String.valueOf(2113));
                this.f43818c.b(2113);
            }
        }

        @Override // d.a.n0.a.h0.m.o.a.b
        public void b(d.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                boolean n = g.n(this.f43817b.f43381f, aVar);
                if (g.f43815a) {
                    Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + n + ",isRetry:" + this.f43816a + ",pmsErrorCode:" + aVar);
                }
                if (n) {
                    g.i(this.f43817b.f43381f, aVar);
                    d.a.n0.a.f1.d.b.a.b().a(this.f43817b.f43381f);
                    g.j(this.f43817b, this.f43820e, this.f43819d, this.f43818c, this.f43821f, true);
                    return;
                }
                d.a.n0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.n0.a.h.swanapp_tip_package_unavailable).F();
                g.h(this.f43816a, this.f43817b.f43381f, "pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f43818c.b(2113);
            }
        }

        @Override // d.a.n0.a.h0.m.o.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                g.h(this.f43816a, this.f43817b.f43381f, "pkg_retry_success", "");
                this.f43818c.a(this.f43819d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements d.a.n0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43822a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f43823b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43824c;

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
            this.f43822a = str;
            this.f43823b = dVar;
            this.f43824c = str2;
        }

        @Override // d.a.n0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.a2.e i2 = d.a.n0.a.a2.e.i();
                if (i2 != null) {
                    i2.y0(this.f43822a, true);
                }
                this.f43823b.a(this.f43824c);
            }
        }

        @Override // d.a.n0.a.h0.m.b
        public void b(int i2, d.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f43823b.b(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements d.a.n0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43825a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f43826b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43827c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f43828d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43829e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43830f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43831g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43832h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f43833i;

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
            this.f43825a = str;
            this.f43826b = z;
            this.f43827c = str2;
            this.f43828d = dVar;
            this.f43829e = str3;
            this.f43830f = str4;
            this.f43831g = str5;
            this.f43832h = str6;
            this.f43833i = str7;
        }

        @Override // d.a.n0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.a2.d.g().r().y0(this.f43825a, true);
                g.h(this.f43826b, this.f43827c, "sub_pkg_retry_success", "");
                this.f43828d.a(this.f43829e);
            }
        }

        @Override // d.a.n0.a.h0.m.b
        public void b(int i2, d.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                boolean n = g.n(this.f43827c, aVar);
                if (g.f43815a) {
                    Log.d("PagesRoute", "isNeedGetPkgRetry:" + n + ",isRetry:" + this.f43826b + ",pmsErrorCode:" + aVar);
                }
                if (n) {
                    g.i(this.f43830f, aVar);
                    d.a.n0.a.f1.d.b.a.b().a(this.f43827c);
                    g.m(this.f43830f, this.f43831g, this.f43832h, this.f43825a, this.f43833i, this.f43829e, this.f43828d, true);
                    return;
                }
                g.h(this.f43826b, this.f43827c, "sub_pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
                this.f43828d.b(i2);
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
        public final d f43834a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f43835b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43836e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f43837f;

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
                this.f43837f = eVar;
                this.f43836e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43837f.f43834a.a(this.f43836e);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43838e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f43839f;

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
                this.f43839f = eVar;
                this.f43838e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f43839f.f43835b) {
                        d.a.n0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.n0.a.h.swanapp_tip_package_unavailable).F();
                    }
                    this.f43839f.f43834a.b(this.f43838e);
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
            this.f43834a = dVar;
            this.f43835b = z;
        }

        @Override // d.a.n0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                q0.b0(new a(this, str));
            }
        }

        @Override // d.a.n0.a.c2.f.p0.g.d
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(369833488, "Ld/a/n0/a/c2/f/p0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(369833488, "Ld/a/n0/a/c2/f/p0/g;");
                return;
            }
        }
        f43815a = d.a.n0.a.k.f45831a;
    }

    public static void g(d.a.n0.a.a2.e eVar, d.a.n0.a.l1.b bVar, String str, d dVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, eVar, bVar, str, dVar, str2) == null) {
            if (eVar != null) {
                eVar.B().e(eVar.getAppId());
            }
            if (dVar == null) {
                return;
            }
            if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.f45989e) && !TextUtils.isEmpty(bVar.f45992h)) {
                String str3 = bVar.f45992h;
                String R = eVar.R(bVar.f45989e);
                boolean h0 = eVar.h0(str3);
                if (!d.a.n0.a.e0.f.e.e.d() && !d.a.n0.a.u1.a.a.G() && !d.a.n0.a.u1.a.a.C()) {
                    if (d.a.n0.a.t1.b.a.e(bVar.f45989e)) {
                        dVar.a(str);
                        return;
                    }
                    if (h0) {
                        if (d.a.n0.a.a1.e.A(eVar.f43381f, eVar.Z())) {
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
                        if (!d.a.n0.a.a1.e.A(eVar.f43381f, eVar.Z()) && !g0) {
                            j(eVar, str3, str, dVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2);
                        q.C(new UbcFlowEvent("na_start_sub_package_download"));
                        q.A("sub_state", "1");
                        l(eVar.f43381f, eVar.Z(), "3", R, G, str, new e(dVar, true));
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
            d.a.n0.a.f1.d.b.a.b().g(str);
            d.a.n0.a.j2.k.G(str2, str3);
        }
    }

    public static void i(String str, d.a.n0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, aVar) == null) {
            if ((aVar == null ? 0L : aVar.g()) == 2205) {
                d.a.n0.a.n0.f.c().d().u(d.a.n0.a.v2.z0.a.a(str), true, 12);
            }
        }
    }

    public static void j(d.a.n0.a.a2.e eVar, String str, String str2, d dVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{eVar, str, str2, dVar, str3, Boolean.valueOf(z)}) == null) || dVar == null) {
            return;
        }
        if (eVar == null) {
            dVar.b(2111);
            return;
        }
        HybridUbcFlow q = d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str3);
        q.C(new UbcFlowEvent("na_start_sub_package_download"));
        q.A("sub_state", "1");
        d.a.n0.n.i.m.c cVar = new d.a.n0.n.i.m.c(eVar.f43381f, d.a.n0.a.a2.d.g().l());
        cVar.o(q0.o(eVar.Z()));
        cVar.r(str);
        d.a.n0.n.b.b(cVar, new d.a.n0.a.h0.m.o.a(eVar.f43381f, new a(z, eVar, dVar, str2, str, str3)));
    }

    public static void k(String str, String str2, String str3, String str4, String str5, String str6, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, str2, str3, str4, str5, str6, dVar}) == null) || dVar == null) {
            return;
        }
        d.a.n0.n.i.m.f fVar = new d.a.n0.n.i.m.f(str, str2, str5, 0);
        fVar.d(str3);
        d.a.n0.n.b.f(fVar, new d.a.n0.a.h0.m.q.a(str, str2, new b(str4, dVar, str6)));
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
        String e2 = d.a.n0.a.f1.d.b.a.b().e(str, str4);
        d.a.n0.n.i.m.f fVar = new d.a.n0.n.i.m.f(str, str2, str5, 0);
        fVar.d(str3);
        d.a.n0.n.b.f(fVar, new d.a.n0.a.h0.m.q.a(str, str2, new c(str4, z, e2, dVar, str6, str, str2, str3, str5)));
    }

    public static boolean n(String str, d.a.n0.a.q2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, aVar)) == null) {
            long g2 = aVar == null ? 0L : aVar.g();
            return SwanAppNetworkUtils.i(d.a.n0.a.c1.a.b()) && d.a.n0.a.f1.d.b.a.b().f(str) && (g2 == 2101 || g2 == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean o(d.a.n0.a.f1.e.b bVar, e.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, bVar, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return p(bVar, gVar.f43324b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(d.a.n0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, bVar, swanAppConfigData)) == null) {
            if (bVar != null && !TextUtils.isEmpty(bVar.e0()) && !d.a.n0.a.e0.f.e.e.d() && !d.a.n0.a.u1.a.a.C()) {
                String f2 = o0.f(bVar.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.f11474b != null) {
                    String c2 = j.c(f2, swanAppConfigData);
                    if (swanAppConfigData.f11474b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.f11475c.f11510c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (d.a.n0.n.g.a.h().m(bVar.H(), bVar.u1(), str)) {
                            return !new File(e.C0629e.i(bVar.H(), bVar.u1()), str).exists();
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
