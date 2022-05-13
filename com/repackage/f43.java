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
import com.repackage.d02;
import com.repackage.qj2;
import com.repackage.rl2;
import com.repackage.vy1;
import com.repackage.yz2;
/* loaded from: classes6.dex */
public class f43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy1 a;
        public final /* synthetic */ q22 b;
        public final /* synthetic */ an1 c;
        public final /* synthetic */ rl2 d;
        public final /* synthetic */ qj2.g e;

        public a(vy1 vy1Var, q22 q22Var, an1 an1Var, rl2 rl2Var, qj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy1Var, q22Var, an1Var, rl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vy1Var;
            this.b = q22Var;
            this.c = an1Var;
            this.d = rl2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                vy1.g(0);
                f43.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements vy1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q22 a;
        public final /* synthetic */ an1 b;
        public final /* synthetic */ rl2 c;
        public final /* synthetic */ qj2.g d;
        public final /* synthetic */ yz2 e;

        public b(q22 q22Var, an1 an1Var, rl2 rl2Var, qj2.g gVar, yz2 yz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q22Var, an1Var, rl2Var, gVar, yz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q22Var;
            this.b = an1Var;
            this.c = rl2Var;
            this.d = gVar;
            this.e = yz2Var;
        }

        @Override // com.repackage.vy1.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f43.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755757844, "Lcom/repackage/f43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755757844, "Lcom/repackage/f43;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void a(q22 q22Var, an1 an1Var, rl2 rl2Var, qj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, q22Var, an1Var, rl2Var, gVar) == null) {
            HybridUbcFlow o = zt2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            hm2 U = hm2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, rl2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                c62.c().b(q22Var, an1Var, rl2Var, gVar.b, gVar, false);
                q22Var.f(activity);
                an1Var.f(activity);
                d02 V = U.V();
                if (V == null) {
                    return;
                }
                uq2 d2 = uq2.d(d, U.z());
                z62.o(oe3.a(d2.c, d2.a, d2.b), an1Var);
                g(V, d);
                n73.E();
                hr2.e(an1Var.c());
                if (!TextUtils.isEmpty(h)) {
                    zt2.l(h);
                }
                n73.F(true, rl2Var.T());
                wf3 loadingView = activity.getLoadingView();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + loadingView);
                }
                if (loadingView != null) {
                    loadingView.F(1);
                }
                t03 J = t03.J();
                if (J.D() && TextUtils.equals(J.getAppId(), rl2Var.H())) {
                    J.r().I(true);
                }
                w02.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            hm2 U = hm2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                d02 V = U.V();
                if (V == null) {
                    ux1.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    ux1.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    pg3.a().k();
                    wf3 loadingView = activity.getLoadingView();
                    if (loadingView != null) {
                        loadingView.F(1);
                    }
                    t03 J = t03.J();
                    if (J.D()) {
                        J.r().I(true);
                    }
                    w02.f(true);
                    return;
                }
            }
            ux1.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b : (String) invokeV.objValue;
    }

    public static String d(hm2 hm2Var, rl2 rl2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hm2Var, rl2Var, swanAppConfigData)) == null) {
            String b2 = hm2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (rl2Var.o0()) {
                    b2 = swanAppConfigData.g(rl2Var.h0());
                } else {
                    b2 = hm2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        rl2.a V;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            u03 r = t03.J().r();
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

    public static boolean f(d02 d02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, d02Var)) == null) ? d02Var.k() >= 1 && (d02Var.m() instanceof h02) : invokeL.booleanValue;
    }

    public static void g(d02 d02Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, d02Var, str) == null) || d02Var == null) {
            return;
        }
        c02.R3(null);
        hm2 U = hm2.U();
        d02.b i = d02Var.i("init");
        int i2 = d02.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", uq2.d(str, U.z()), true).a();
    }

    public static void h(d02 d02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, d02Var, str) == null) {
            if (d02Var == null) {
                ux1.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(d02Var)) {
                ux1.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                c02.R3(null);
                d02.b i = d02Var.i("init");
                int i2 = d02.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", uq2.d(str, str), true).a();
                mg3.c().o(d02Var.m());
            }
        }
    }

    public static void i(q22 q22Var, an1 an1Var, rl2 rl2Var, qj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, q22Var, an1Var, rl2Var, gVar) == null) {
            if (!tw2.H() && vy1.e() != 2) {
                if (tw2.D()) {
                    fy1.k().q(q22Var, an1Var, rl2Var, gVar);
                    return;
                } else {
                    a(q22Var, an1Var, rl2Var, gVar);
                    return;
                }
            }
            ux1.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            vy1 vy1Var = new vy1(bk2.c());
            yz2.a aVar = new yz2.a(t03.J().x());
            aVar.U(R.string.obfuscated_res_0x7f0f0148);
            aVar.v(R.string.obfuscated_res_0x7f0f0137);
            aVar.n(new cg3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0136, new a(vy1Var, q22Var, an1Var, rl2Var, gVar));
            yz2 X = aVar.X();
            HybridUbcFlow o = zt2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            vy1Var.f(new b(q22Var, an1Var, rl2Var, gVar, X));
            vy1Var.h();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b(ng3.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
