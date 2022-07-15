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
import com.repackage.dj2;
import com.repackage.el2;
import com.repackage.iy1;
import com.repackage.lz2;
import com.repackage.qz1;
/* loaded from: classes7.dex */
public class s33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy1 a;
        public final /* synthetic */ d22 b;
        public final /* synthetic */ nm1 c;
        public final /* synthetic */ el2 d;
        public final /* synthetic */ dj2.g e;

        public a(iy1 iy1Var, d22 d22Var, nm1 nm1Var, el2 el2Var, dj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy1Var, d22Var, nm1Var, el2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy1Var;
            this.b = d22Var;
            this.c = nm1Var;
            this.d = el2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                iy1.g(0);
                s33.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements iy1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d22 a;
        public final /* synthetic */ nm1 b;
        public final /* synthetic */ el2 c;
        public final /* synthetic */ dj2.g d;
        public final /* synthetic */ lz2 e;

        public b(d22 d22Var, nm1 nm1Var, el2 el2Var, dj2.g gVar, lz2 lz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d22Var, nm1Var, el2Var, gVar, lz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d22Var;
            this.b = nm1Var;
            this.c = el2Var;
            this.d = gVar;
            this.e = lz2Var;
        }

        @Override // com.repackage.iy1.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s33.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755371522, "Lcom/repackage/s33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755371522, "Lcom/repackage/s33;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void a(d22 d22Var, nm1 nm1Var, el2 el2Var, dj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, d22Var, nm1Var, el2Var, gVar) == null) {
            HybridUbcFlow o = mt2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            ul2 U = ul2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, el2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                p52.c().b(d22Var, nm1Var, el2Var, gVar.b, gVar, false);
                d22Var.e(activity);
                nm1Var.e(activity);
                qz1 V = U.V();
                if (V == null) {
                    return;
                }
                hq2 d2 = hq2.d(d, U.z());
                m62.o(be3.a(d2.c, d2.a, d2.b), nm1Var);
                g(V, d);
                a73.E();
                uq2.e(nm1Var.b());
                if (!TextUtils.isEmpty(h)) {
                    mt2.l(h);
                }
                a73.F(true, el2Var.T());
                jf3 T = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T);
                }
                if (T != null) {
                    T.F(1);
                }
                g03 K = g03.K();
                if (K.E() && TextUtils.equals(K.getAppId(), el2Var.H())) {
                    K.q().J(true);
                }
                j02.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            ul2 U = ul2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                qz1 V = U.V();
                if (V == null) {
                    hx1.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    hx1.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    cg3.a().k();
                    jf3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    g03 K = g03.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    j02.f(true);
                    return;
                }
            }
            hx1.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b : (String) invokeV.objValue;
    }

    public static String d(ul2 ul2Var, el2 el2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ul2Var, el2Var, swanAppConfigData)) == null) {
            String b2 = ul2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (el2Var.o0()) {
                    b2 = swanAppConfigData.g(el2Var.h0());
                } else {
                    b2 = ul2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        el2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            h03 q = g03.K().q();
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

    public static boolean f(qz1 qz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, qz1Var)) == null) ? qz1Var.k() >= 1 && (qz1Var.m() instanceof uz1) : invokeL.booleanValue;
    }

    public static void g(qz1 qz1Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, qz1Var, str) == null) || qz1Var == null) {
            return;
        }
        pz1.S3(null);
        ul2 U = ul2.U();
        qz1.b i = qz1Var.i("init");
        int i2 = qz1.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", hq2.d(str, U.z()), true).a();
    }

    public static void h(qz1 qz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, qz1Var, str) == null) {
            if (qz1Var == null) {
                hx1.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(qz1Var)) {
                hx1.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                pz1.S3(null);
                qz1.b i = qz1Var.i("init");
                int i2 = qz1.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", hq2.d(str, str), true).a();
                zf3.c().o(qz1Var.m());
            }
        }
    }

    public static void i(d22 d22Var, nm1 nm1Var, el2 el2Var, dj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, d22Var, nm1Var, el2Var, gVar) == null) {
            if (!gw2.H() && iy1.e() != 2) {
                if (gw2.D()) {
                    sx1.k().q(d22Var, nm1Var, el2Var, gVar);
                    return;
                } else {
                    a(d22Var, nm1Var, el2Var, gVar);
                    return;
                }
            }
            hx1.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            iy1 iy1Var = new iy1(oj2.c());
            lz2.a aVar = new lz2.a(g03.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f014b);
            aVar.v(R.string.obfuscated_res_0x7f0f013a);
            aVar.n(new pf3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0139, new a(iy1Var, d22Var, nm1Var, el2Var, gVar));
            lz2 X = aVar.X();
            HybridUbcFlow o = mt2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            iy1Var.f(new b(d22Var, nm1Var, el2Var, gVar, X));
            iy1Var.h();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b(ag3.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
