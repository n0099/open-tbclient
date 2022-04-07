package com.repackage;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fj2;
import com.repackage.gl2;
import com.repackage.ky1;
import com.repackage.nz2;
import com.repackage.sz1;
/* loaded from: classes7.dex */
public class u33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky1 a;
        public final /* synthetic */ f22 b;
        public final /* synthetic */ pm1 c;
        public final /* synthetic */ gl2 d;
        public final /* synthetic */ fj2.g e;

        public a(ky1 ky1Var, f22 f22Var, pm1 pm1Var, gl2 gl2Var, fj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var, f22Var, pm1Var, gl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky1Var;
            this.b = f22Var;
            this.c = pm1Var;
            this.d = gl2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                ky1.g(0);
                u33.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements ky1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f22 a;
        public final /* synthetic */ pm1 b;
        public final /* synthetic */ gl2 c;
        public final /* synthetic */ fj2.g d;
        public final /* synthetic */ nz2 e;

        public b(f22 f22Var, pm1 pm1Var, gl2 gl2Var, fj2.g gVar, nz2 nz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f22Var, pm1Var, gl2Var, gVar, nz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f22Var;
            this.b = pm1Var;
            this.c = gl2Var;
            this.d = gVar;
            this.e = nz2Var;
        }

        @Override // com.repackage.ky1.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u33.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755311940, "Lcom/repackage/u33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755311940, "Lcom/repackage/u33;");
                return;
            }
        }
        a = tg1.a;
    }

    public static void a(f22 f22Var, pm1 pm1Var, gl2 gl2Var, fj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, f22Var, pm1Var, gl2Var, gVar) == null) {
            HybridUbcFlow o = ot2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            wl2 U = wl2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, gl2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                r52.c().b(f22Var, pm1Var, gl2Var, gVar.b, gVar, false);
                f22Var.f(activity);
                pm1Var.f(activity);
                sz1 V = U.V();
                if (V == null) {
                    return;
                }
                jq2 d2 = jq2.d(d, U.z());
                o62.o(de3.a(d2.c, d2.a, d2.b), pm1Var);
                g(V, d);
                c73.E();
                wq2.e(pm1Var.c());
                if (!TextUtils.isEmpty(h)) {
                    ot2.l(h);
                }
                c73.F(true, gl2Var.T());
                lf3 loadingView = activity.getLoadingView();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + loadingView);
                }
                if (loadingView != null) {
                    loadingView.F(1);
                }
                i03 J = i03.J();
                if (J.D() && TextUtils.equals(J.getAppId(), gl2Var.H())) {
                    J.r().I(true);
                }
                l02.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            wl2 U = wl2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                sz1 V = U.V();
                if (V == null) {
                    jx1.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    jx1.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    eg3.a().k();
                    lf3 loadingView = activity.getLoadingView();
                    if (loadingView != null) {
                        loadingView.F(1);
                    }
                    i03 J = i03.J();
                    if (J.D()) {
                        J.r().I(true);
                    }
                    l02.f(true);
                    return;
                }
            }
            jx1.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b : (String) invokeV.objValue;
    }

    public static String d(wl2 wl2Var, gl2 gl2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, wl2Var, gl2Var, swanAppConfigData)) == null) {
            String b2 = wl2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (gl2Var.o0()) {
                    b2 = swanAppConfigData.g(gl2Var.h0());
                } else {
                    b2 = wl2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        gl2.a V;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            j03 r = i03.J().r();
            if (r == null || (V = r.V()) == null || (f0 = V.f0()) == null) {
                return null;
            }
            String str = f0.webUrl;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static boolean f(sz1 sz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, sz1Var)) == null) ? sz1Var.k() >= 1 && (sz1Var.m() instanceof wz1) : invokeL.booleanValue;
    }

    public static void g(sz1 sz1Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, sz1Var, str) == null) || sz1Var == null) {
            return;
        }
        rz1.R3(null);
        wl2 U = wl2.U();
        sz1.b i = sz1Var.i("init");
        int i2 = sz1.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", jq2.d(str, U.z()), true).a();
    }

    public static void h(sz1 sz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, sz1Var, str) == null) {
            if (sz1Var == null) {
                jx1.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(sz1Var)) {
                jx1.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                rz1.R3(null);
                sz1.b i = sz1Var.i("init");
                int i2 = sz1.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", jq2.d(str, str), true).a();
                bg3.c().o(sz1Var.m());
            }
        }
    }

    public static void i(f22 f22Var, pm1 pm1Var, gl2 gl2Var, fj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, f22Var, pm1Var, gl2Var, gVar) == null) {
            if (!iw2.H() && ky1.e() != 2) {
                if (iw2.D()) {
                    ux1.k().q(f22Var, pm1Var, gl2Var, gVar);
                    return;
                } else {
                    a(f22Var, pm1Var, gl2Var, gVar);
                    return;
                }
            }
            jx1.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            ky1 ky1Var = new ky1(qj2.c());
            nz2.a aVar = new nz2.a(i03.J().x());
            aVar.U(R.string.obfuscated_res_0x7f0f0146);
            aVar.v(R.string.obfuscated_res_0x7f0f0135);
            aVar.n(new rf3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0134, new a(ky1Var, f22Var, pm1Var, gl2Var, gVar));
            nz2 X = aVar.X();
            HybridUbcFlow o = ot2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            ky1Var.f(new b(f22Var, pm1Var, gl2Var, gVar, X));
            ky1Var.h();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b(cg3.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
