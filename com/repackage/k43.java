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
import com.repackage.az1;
import com.repackage.d03;
import com.repackage.i02;
import com.repackage.vj2;
import com.repackage.wl2;
/* loaded from: classes6.dex */
public class k43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az1 a;
        public final /* synthetic */ v22 b;
        public final /* synthetic */ fn1 c;
        public final /* synthetic */ wl2 d;
        public final /* synthetic */ vj2.g e;

        public a(az1 az1Var, v22 v22Var, fn1 fn1Var, wl2 wl2Var, vj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var, v22Var, fn1Var, wl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = az1Var;
            this.b = v22Var;
            this.c = fn1Var;
            this.d = wl2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                az1.g(0);
                k43.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements az1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v22 a;
        public final /* synthetic */ fn1 b;
        public final /* synthetic */ wl2 c;
        public final /* synthetic */ vj2.g d;
        public final /* synthetic */ d03 e;

        public b(v22 v22Var, fn1 fn1Var, wl2 wl2Var, vj2.g gVar, d03 d03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v22Var, fn1Var, wl2Var, gVar, d03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v22Var;
            this.b = fn1Var;
            this.c = wl2Var;
            this.d = gVar;
            this.e = d03Var;
        }

        @Override // com.repackage.az1.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k43.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755608889, "Lcom/repackage/k43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755608889, "Lcom/repackage/k43;");
                return;
            }
        }
        a = jh1.a;
    }

    public static void a(v22 v22Var, fn1 fn1Var, wl2 wl2Var, vj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, v22Var, fn1Var, wl2Var, gVar) == null) {
            HybridUbcFlow o = eu2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            mm2 U = mm2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, wl2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                h62.c().b(v22Var, fn1Var, wl2Var, gVar.b, gVar, false);
                v22Var.attachActivity(activity);
                fn1Var.attachActivity(activity);
                i02 V = U.V();
                if (V == null) {
                    return;
                }
                zq2 d2 = zq2.d(d, U.z());
                e72.o(te3.a(d2.c, d2.a, d2.b), fn1Var);
                g(V, d);
                s73.E();
                mr2.e(fn1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    eu2.l(h);
                }
                s73.F(true, wl2Var.T());
                bg3 T = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T);
                }
                if (T != null) {
                    T.F(1);
                }
                y03 K = y03.K();
                if (K.E() && TextUtils.equals(K.getAppId(), wl2Var.H())) {
                    K.q().J(true);
                }
                b12.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            mm2 U = mm2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                i02 V = U.V();
                if (V == null) {
                    zx1.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    zx1.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    ug3.a().k();
                    bg3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    y03 K = y03.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    b12.f(true);
                    return;
                }
            }
            zx1.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b : (String) invokeV.objValue;
    }

    public static String d(mm2 mm2Var, wl2 wl2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mm2Var, wl2Var, swanAppConfigData)) == null) {
            String b2 = mm2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (wl2Var.o0()) {
                    b2 = swanAppConfigData.g(wl2Var.h0());
                } else {
                    b2 = mm2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        wl2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            z03 q = y03.K().q();
            if (q == null || (W = q.W()) == null || (f0 = W.f0()) == null) {
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

    public static boolean f(i02 i02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, i02Var)) == null) ? i02Var.k() >= 1 && (i02Var.m() instanceof m02) : invokeL.booleanValue;
    }

    public static void g(i02 i02Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, i02Var, str) == null) || i02Var == null) {
            return;
        }
        h02.S3(null);
        mm2 U = mm2.U();
        i02.b i = i02Var.i("init");
        int i2 = i02.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", zq2.d(str, U.z()), true).a();
    }

    public static void h(i02 i02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, i02Var, str) == null) {
            if (i02Var == null) {
                zx1.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(i02Var)) {
                zx1.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                h02.S3(null);
                i02.b i = i02Var.i("init");
                int i2 = i02.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", zq2.d(str, str), true).a();
                rg3.c().o(i02Var.m());
            }
        }
    }

    public static void i(v22 v22Var, fn1 fn1Var, wl2 wl2Var, vj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, v22Var, fn1Var, wl2Var, gVar) == null) {
            if (!yw2.H() && az1.e() != 2) {
                if (yw2.D()) {
                    ky1.k().q(v22Var, fn1Var, wl2Var, gVar);
                    return;
                } else {
                    a(v22Var, fn1Var, wl2Var, gVar);
                    return;
                }
            }
            zx1.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            az1 az1Var = new az1(gk2.c());
            d03.a aVar = new d03.a(y03.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f014e);
            aVar.v(R.string.obfuscated_res_0x7f0f013d);
            aVar.n(new hg3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f013c, new a(az1Var, v22Var, fn1Var, wl2Var, gVar));
            d03 X = aVar.X();
            HybridUbcFlow o = eu2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            az1Var.f(new b(v22Var, fn1Var, wl2Var, gVar, X));
            az1Var.h();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b(sg3.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
