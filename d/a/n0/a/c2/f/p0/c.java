package d.a.n0.a.c2.f.p0;

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
import d.a.n0.a.a1.e;
import d.a.n0.a.e0.h.a;
import d.a.n0.a.h0.g.g;
import d.a.n0.a.v2.q0;
import d.a.n0.a.z1.b.b.h;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43782a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43783b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.e0.h.a f43784e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.l.a f43785f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.p.e.b f43786g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.f1.e.b f43787h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e.g f43788i;

        public a(d.a.n0.a.e0.h.a aVar, d.a.n0.a.h0.l.a aVar2, d.a.n0.a.p.e.b bVar, d.a.n0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f43784e = aVar;
            this.f43785f = aVar2;
            this.f43786g = bVar;
            this.f43787h = bVar2;
            this.f43788i = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f43784e.i();
                d.a.n0.a.e0.h.a.g(0);
                c.a(this.f43785f, this.f43786g, this.f43787h, this.f43788i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.l.a f43789a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.p.e.b f43790b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.f1.e.b f43791c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f43792d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.z1.b.b.h f43793e;

        public b(d.a.n0.a.h0.l.a aVar, d.a.n0.a.p.e.b bVar, d.a.n0.a.f1.e.b bVar2, e.g gVar, d.a.n0.a.z1.b.b.h hVar) {
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
            this.f43789a = aVar;
            this.f43790b = bVar;
            this.f43791c = bVar2;
            this.f43792d = gVar;
            this.f43793e = hVar;
        }

        @Override // d.a.n0.a.e0.h.a.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a(this.f43789a, this.f43790b, this.f43791c, this.f43792d);
                this.f43793e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(369833364, "Ld/a/n0/a/c2/f/p0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(369833364, "Ld/a/n0/a/c2/f/p0/c;");
                return;
            }
        }
        f43782a = d.a.n0.a.k.f45831a;
    }

    public static void a(d.a.n0.a.h0.l.a aVar, d.a.n0.a.p.e.b bVar, d.a.n0.a.f1.e.b bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, aVar, bVar, bVar2, gVar) == null) {
            HybridUbcFlow o = d.a.n0.a.r1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.C(ubcFlowEvent);
            d.a.n0.a.g1.f V = d.a.n0.a.g1.f.V();
            SwanAppConfigData swanAppConfigData = gVar.f43324b;
            if (swanAppConfigData == null) {
                if (f43782a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String c2 = c(V, bVar2, swanAppConfigData);
            String g2 = gVar.f43324b.g(c2);
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                d.a.n0.a.h0.p.b.c().b(aVar, bVar, bVar2, gVar.f43324b, gVar, false);
                aVar.e(activity);
                bVar.e(activity);
                d.a.n0.a.h0.g.g W = V.W();
                if (W == null) {
                    return;
                }
                d.a.n0.a.l1.b g3 = d.a.n0.a.l1.b.g(c2, V.A());
                d.a.n0.a.h0.t.a.m(q0.a(g3.f45991g, g3.f45989e, g3.f45990f), bVar);
                d(W, c2);
                d.a.n0.a.j2.k.A();
                d.a.n0.a.m1.f.e(bVar.b());
                if (!TextUtils.isEmpty(g2)) {
                    d.a.n0.a.r1.h.l(g2);
                }
                d.a.n0.a.j2.k.B(true, bVar2.T());
                d.a.n0.a.w2.e loadingView = activity.getLoadingView();
                if (f43782a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + loadingView);
                }
                if (loadingView != null) {
                    loadingView.H(1);
                }
                d.a.n0.a.a2.d g4 = d.a.n0.a.a2.d.g();
                if (g4.C() && TextUtils.equals(g4.getAppId(), bVar2.H())) {
                    g4.r().f(true);
                }
                d.a.n0.a.h0.i.i.h(true);
            } else if (f43782a) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f43783b : (String) invokeV.objValue;
    }

    public static String c(d.a.n0.a.g1.f fVar, d.a.n0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
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
            f43783b = a2;
            return a2;
        }
        return (String) invokeLLL.objValue;
    }

    public static void d(d.a.n0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, gVar, str) == null) || gVar == null) {
            return;
        }
        d.a.n0.a.h0.g.f.E3(null);
        d.a.n0.a.g1.f V = d.a.n0.a.g1.f.V();
        g.b i2 = gVar.i("init");
        int i3 = d.a.n0.a.h0.g.g.f44710i;
        i2.n(i3, i3);
        i2.f();
        i2.l("normal", d.a.n0.a.l1.b.g(str, V.A()), true).a();
    }

    public static void e(d.a.n0.a.h0.l.a aVar, d.a.n0.a.p.e.b bVar, d.a.n0.a.f1.e.b bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, aVar, bVar, bVar2, gVar) == null) {
            if (!d.a.n0.a.u1.a.a.G() && d.a.n0.a.e0.h.a.e() != 2) {
                if (d.a.n0.a.u1.a.a.C()) {
                    d.a.n0.a.e0.f.d.f.k().q(aVar, bVar, bVar2, gVar);
                    return;
                } else {
                    a(aVar, bVar, bVar2, gVar);
                    return;
                }
            }
            d.a.n0.a.e0.d.g("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            d.a.n0.a.e0.h.a aVar2 = new d.a.n0.a.e0.h.a(d.a.n0.a.c1.a.b());
            h.a aVar3 = new h.a(d.a.n0.a.a2.d.g().x());
            aVar3.U(d.a.n0.a.h.aiapps_debug_start_inspect);
            aVar3.v(d.a.n0.a.h.aiapps_debug_inspect_waiting);
            aVar3.n(new d.a.n0.a.w2.h.a());
            aVar3.m(false);
            aVar3.O(d.a.n0.a.h.aiapps_debug_inspect_skip, new a(aVar2, aVar, bVar, bVar2, gVar));
            d.a.n0.a.z1.b.b.h X = aVar3.X();
            HybridUbcFlow o = d.a.n0.a.r1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.C(ubcFlowEvent);
            aVar2.f(new b(aVar, bVar, bVar2, gVar, X));
            aVar2.h();
        }
    }
}
