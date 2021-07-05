package d.a.q0.a.c2.f.p0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.SwanAppActivity;
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
import d.a.q0.a.a1.e;
import d.a.q0.a.e0.h.a;
import d.a.q0.a.h0.g.g;
import d.a.q0.a.v2.q0;
import d.a.q0.a.z1.b.b.h;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47084a;

    /* renamed from: b  reason: collision with root package name */
    public static String f47085b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.e0.h.a f47086e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.l.a f47087f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.p.e.b f47088g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f47089h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e.g f47090i;

        public a(d.a.q0.a.e0.h.a aVar, d.a.q0.a.h0.l.a aVar2, d.a.q0.a.p.e.b bVar, d.a.q0.a.f1.e.b bVar2, e.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, bVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47086e = aVar;
            this.f47087f = aVar2;
            this.f47088g = bVar;
            this.f47089h = bVar2;
            this.f47090i = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f47086e.i();
                d.a.q0.a.e0.h.a.g(0);
                c.a(this.f47087f, this.f47088g, this.f47089h, this.f47090i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.l.a f47091a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.p.e.b f47092b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f47093c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f47094d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.z1.b.b.h f47095e;

        public b(d.a.q0.a.h0.l.a aVar, d.a.q0.a.p.e.b bVar, d.a.q0.a.f1.e.b bVar2, e.g gVar, d.a.q0.a.z1.b.b.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, bVar2, gVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47091a = aVar;
            this.f47092b = bVar;
            this.f47093c = bVar2;
            this.f47094d = gVar;
            this.f47095e = hVar;
        }

        @Override // d.a.q0.a.e0.h.a.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a(this.f47091a, this.f47092b, this.f47093c, this.f47094d);
                this.f47095e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(597521495, "Ld/a/q0/a/c2/f/p0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(597521495, "Ld/a/q0/a/c2/f/p0/c;");
                return;
            }
        }
        f47084a = d.a.q0.a.k.f49133a;
    }

    public static void a(d.a.q0.a.h0.l.a aVar, d.a.q0.a.p.e.b bVar, d.a.q0.a.f1.e.b bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, aVar, bVar, bVar2, gVar) == null) {
            HybridUbcFlow o = d.a.q0.a.r1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.C(ubcFlowEvent);
            d.a.q0.a.g1.f V = d.a.q0.a.g1.f.V();
            SwanAppConfigData swanAppConfigData = gVar.f46626b;
            if (swanAppConfigData == null) {
                if (f47084a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String c2 = c(V, bVar2, swanAppConfigData);
            String g2 = gVar.f46626b.g(c2);
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                d.a.q0.a.h0.p.b.c().b(aVar, bVar, bVar2, gVar.f46626b, gVar, false);
                aVar.e(activity);
                bVar.e(activity);
                d.a.q0.a.h0.g.g W = V.W();
                if (W == null) {
                    return;
                }
                d.a.q0.a.l1.b g3 = d.a.q0.a.l1.b.g(c2, V.A());
                d.a.q0.a.h0.t.a.m(q0.a(g3.f49293g, g3.f49291e, g3.f49292f), bVar);
                d(W, c2);
                d.a.q0.a.j2.k.A();
                d.a.q0.a.m1.f.e(bVar.b());
                if (!TextUtils.isEmpty(g2)) {
                    d.a.q0.a.r1.h.l(g2);
                }
                d.a.q0.a.j2.k.B(true, bVar2.T());
                d.a.q0.a.w2.e loadingView = activity.getLoadingView();
                if (f47084a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + loadingView);
                }
                if (loadingView != null) {
                    loadingView.H(1);
                }
                d.a.q0.a.a2.d g4 = d.a.q0.a.a2.d.g();
                if (g4.C() && TextUtils.equals(g4.getAppId(), bVar2.H())) {
                    g4.r().f(true);
                }
                d.a.q0.a.h0.i.i.h(true);
            } else if (f47084a) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f47085b : (String) invokeV.objValue;
    }

    public static String c(d.a.q0.a.g1.f fVar, d.a.q0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, fVar, bVar, swanAppConfigData)) == null) {
            String a2 = fVar.a();
            if (TextUtils.isEmpty(a2)) {
                if (bVar.n0()) {
                    a2 = swanAppConfigData.f(bVar.h0());
                } else {
                    a2 = fVar.f();
                }
            }
            f47085b = a2;
            return a2;
        }
        return (String) invokeLLL.objValue;
    }

    public static void d(d.a.q0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65540, null, gVar, str) == null) || gVar == null) {
            return;
        }
        d.a.q0.a.h0.g.f.E3(null);
        d.a.q0.a.g1.f V = d.a.q0.a.g1.f.V();
        g.b i2 = gVar.i("init");
        int i3 = d.a.q0.a.h0.g.g.f48012i;
        i2.n(i3, i3);
        i2.f();
        i2.l("normal", d.a.q0.a.l1.b.g(str, V.A()), true).a();
    }

    public static void e(d.a.q0.a.h0.l.a aVar, d.a.q0.a.p.e.b bVar, d.a.q0.a.f1.e.b bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, aVar, bVar, bVar2, gVar) == null) {
            if (!d.a.q0.a.u1.a.a.G() && d.a.q0.a.e0.h.a.e() != 2) {
                if (d.a.q0.a.u1.a.a.C()) {
                    d.a.q0.a.e0.f.d.f.k().q(aVar, bVar, bVar2, gVar);
                    return;
                } else {
                    a(aVar, bVar, bVar2, gVar);
                    return;
                }
            }
            d.a.q0.a.e0.d.g("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            d.a.q0.a.e0.h.a aVar2 = new d.a.q0.a.e0.h.a(d.a.q0.a.c1.a.b());
            h.a aVar3 = new h.a(d.a.q0.a.a2.d.g().x());
            aVar3.U(d.a.q0.a.h.aiapps_debug_start_inspect);
            aVar3.v(d.a.q0.a.h.aiapps_debug_inspect_waiting);
            aVar3.n(new d.a.q0.a.w2.h.a());
            aVar3.m(false);
            aVar3.O(d.a.q0.a.h.aiapps_debug_inspect_skip, new a(aVar2, aVar, bVar, bVar2, gVar));
            d.a.q0.a.z1.b.b.h X = aVar3.X();
            HybridUbcFlow o = d.a.q0.a.r1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.C(ubcFlowEvent);
            aVar2.f(new b(aVar, bVar, bVar2, gVar, X));
            aVar2.h();
        }
    }
}
