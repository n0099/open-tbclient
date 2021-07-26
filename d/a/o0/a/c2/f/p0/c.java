package d.a.o0.a.c2.f.p0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
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
import d.a.o0.a.a1.e;
import d.a.o0.a.e0.h.a;
import d.a.o0.a.h0.g.g;
import d.a.o0.a.v2.q0;
import d.a.o0.a.z1.b.b.h;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44286a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44287b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.e0.h.a f44288e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.l.a f44289f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.p.e.b f44290g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.f1.e.b f44291h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e.g f44292i;

        public a(d.a.o0.a.e0.h.a aVar, d.a.o0.a.h0.l.a aVar2, d.a.o0.a.p.e.b bVar, d.a.o0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f44288e = aVar;
            this.f44289f = aVar2;
            this.f44290g = bVar;
            this.f44291h = bVar2;
            this.f44292i = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f44288e.i();
                d.a.o0.a.e0.h.a.g(0);
                c.a(this.f44289f, this.f44290g, this.f44291h, this.f44292i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.l.a f44293a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.p.e.b f44294b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.f1.e.b f44295c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f44296d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.z1.b.b.h f44297e;

        public b(d.a.o0.a.h0.l.a aVar, d.a.o0.a.p.e.b bVar, d.a.o0.a.f1.e.b bVar2, e.g gVar, d.a.o0.a.z1.b.b.h hVar) {
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
            this.f44293a = aVar;
            this.f44294b = bVar;
            this.f44295c = bVar2;
            this.f44296d = gVar;
            this.f44297e = hVar;
        }

        @Override // d.a.o0.a.e0.h.a.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a(this.f44293a, this.f44294b, this.f44295c, this.f44296d);
                this.f44297e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1877385173, "Ld/a/o0/a/c2/f/p0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1877385173, "Ld/a/o0/a/c2/f/p0/c;");
                return;
            }
        }
        f44286a = d.a.o0.a.k.f46335a;
    }

    public static void a(d.a.o0.a.h0.l.a aVar, d.a.o0.a.p.e.b bVar, d.a.o0.a.f1.e.b bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, aVar, bVar, bVar2, gVar) == null) {
            HybridUbcFlow o = d.a.o0.a.r1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.C(ubcFlowEvent);
            d.a.o0.a.g1.f V = d.a.o0.a.g1.f.V();
            SwanAppConfigData swanAppConfigData = gVar.f43828b;
            if (swanAppConfigData == null) {
                if (f44286a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String c2 = c(V, bVar2, swanAppConfigData);
            String g2 = gVar.f43828b.g(c2);
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                d.a.o0.a.h0.p.b.c().b(aVar, bVar, bVar2, gVar.f43828b, gVar, false);
                aVar.e(activity);
                bVar.e(activity);
                d.a.o0.a.h0.g.g W = V.W();
                if (W == null) {
                    return;
                }
                d.a.o0.a.l1.b g3 = d.a.o0.a.l1.b.g(c2, V.A());
                d.a.o0.a.h0.t.a.m(q0.a(g3.f46495g, g3.f46493e, g3.f46494f), bVar);
                d(W, c2);
                d.a.o0.a.j2.k.A();
                d.a.o0.a.m1.f.e(bVar.b());
                if (!TextUtils.isEmpty(g2)) {
                    d.a.o0.a.r1.h.l(g2);
                }
                d.a.o0.a.j2.k.B(true, bVar2.T());
                d.a.o0.a.w2.e loadingView = activity.getLoadingView();
                if (f44286a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + loadingView);
                }
                if (loadingView != null) {
                    loadingView.H(1);
                }
                d.a.o0.a.a2.d g4 = d.a.o0.a.a2.d.g();
                if (g4.C() && TextUtils.equals(g4.getAppId(), bVar2.H())) {
                    g4.r().f(true);
                }
                d.a.o0.a.h0.i.i.h(true);
            } else if (f44286a) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f44287b : (String) invokeV.objValue;
    }

    public static String c(d.a.o0.a.g1.f fVar, d.a.o0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
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
            f44287b = a2;
            return a2;
        }
        return (String) invokeLLL.objValue;
    }

    public static void d(d.a.o0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, gVar, str) == null) || gVar == null) {
            return;
        }
        d.a.o0.a.h0.g.f.E3(null);
        d.a.o0.a.g1.f V = d.a.o0.a.g1.f.V();
        g.b i2 = gVar.i("init");
        int i3 = d.a.o0.a.h0.g.g.f45214i;
        i2.n(i3, i3);
        i2.f();
        i2.l("normal", d.a.o0.a.l1.b.g(str, V.A()), true).a();
    }

    public static void e(d.a.o0.a.h0.l.a aVar, d.a.o0.a.p.e.b bVar, d.a.o0.a.f1.e.b bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, aVar, bVar, bVar2, gVar) == null) {
            if (!d.a.o0.a.u1.a.a.G() && d.a.o0.a.e0.h.a.e() != 2) {
                if (d.a.o0.a.u1.a.a.C()) {
                    d.a.o0.a.e0.f.d.f.k().q(aVar, bVar, bVar2, gVar);
                    return;
                } else {
                    a(aVar, bVar, bVar2, gVar);
                    return;
                }
            }
            d.a.o0.a.e0.d.g("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            d.a.o0.a.e0.h.a aVar2 = new d.a.o0.a.e0.h.a(d.a.o0.a.c1.a.b());
            h.a aVar3 = new h.a(d.a.o0.a.a2.d.g().x());
            aVar3.U(d.a.o0.a.h.aiapps_debug_start_inspect);
            aVar3.v(d.a.o0.a.h.aiapps_debug_inspect_waiting);
            aVar3.n(new d.a.o0.a.w2.h.a());
            aVar3.m(false);
            aVar3.O(d.a.o0.a.h.aiapps_debug_inspect_skip, new a(aVar2, aVar, bVar, bVar2, gVar));
            d.a.o0.a.z1.b.b.h X = aVar3.X();
            HybridUbcFlow o = d.a.o0.a.r1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.C(ubcFlowEvent);
            aVar2.f(new b(aVar, bVar, bVar2, gVar, X));
            aVar2.h();
        }
    }
}
