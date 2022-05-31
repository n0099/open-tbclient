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
import com.repackage.di2;
import com.repackage.ek2;
import com.repackage.ix1;
import com.repackage.ly2;
import com.repackage.qy1;
/* loaded from: classes7.dex */
public class s23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix1 a;
        public final /* synthetic */ d12 b;
        public final /* synthetic */ nl1 c;
        public final /* synthetic */ ek2 d;
        public final /* synthetic */ di2.g e;

        public a(ix1 ix1Var, d12 d12Var, nl1 nl1Var, ek2 ek2Var, di2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix1Var, d12Var, nl1Var, ek2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix1Var;
            this.b = d12Var;
            this.c = nl1Var;
            this.d = ek2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                ix1.g(0);
                s23.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements ix1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d12 a;
        public final /* synthetic */ nl1 b;
        public final /* synthetic */ ek2 c;
        public final /* synthetic */ di2.g d;
        public final /* synthetic */ ly2 e;

        public b(d12 d12Var, nl1 nl1Var, ek2 ek2Var, di2.g gVar, ly2 ly2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d12Var, nl1Var, ek2Var, gVar, ly2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d12Var;
            this.b = nl1Var;
            this.c = ek2Var;
            this.d = gVar;
            this.e = ly2Var;
        }

        @Override // com.repackage.ix1.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s23.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755372483, "Lcom/repackage/s23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755372483, "Lcom/repackage/s23;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void a(d12 d12Var, nl1 nl1Var, ek2 ek2Var, di2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, d12Var, nl1Var, ek2Var, gVar) == null) {
            HybridUbcFlow o = ms2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            uk2 U = uk2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, ek2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                p42.c().b(d12Var, nl1Var, ek2Var, gVar.b, gVar, false);
                d12Var.f(activity);
                nl1Var.f(activity);
                qy1 V = U.V();
                if (V == null) {
                    return;
                }
                hp2 d2 = hp2.d(d, U.z());
                m52.o(bd3.a(d2.c, d2.a, d2.b), nl1Var);
                g(V, d);
                a63.E();
                up2.e(nl1Var.c());
                if (!TextUtils.isEmpty(h)) {
                    ms2.l(h);
                }
                a63.F(true, ek2Var.T());
                je3 loadingView = activity.getLoadingView();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + loadingView);
                }
                if (loadingView != null) {
                    loadingView.F(1);
                }
                gz2 J = gz2.J();
                if (J.D() && TextUtils.equals(J.getAppId(), ek2Var.H())) {
                    J.r().I(true);
                }
                jz1.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            uk2 U = uk2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                qy1 V = U.V();
                if (V == null) {
                    hw1.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    hw1.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    cf3.a().k();
                    je3 loadingView = activity.getLoadingView();
                    if (loadingView != null) {
                        loadingView.F(1);
                    }
                    gz2 J = gz2.J();
                    if (J.D()) {
                        J.r().I(true);
                    }
                    jz1.f(true);
                    return;
                }
            }
            hw1.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b : (String) invokeV.objValue;
    }

    public static String d(uk2 uk2Var, ek2 ek2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uk2Var, ek2Var, swanAppConfigData)) == null) {
            String b2 = uk2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (ek2Var.o0()) {
                    b2 = swanAppConfigData.g(ek2Var.h0());
                } else {
                    b2 = uk2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        ek2.a V;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            hz2 r = gz2.J().r();
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

    public static boolean f(qy1 qy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, qy1Var)) == null) ? qy1Var.k() >= 1 && (qy1Var.m() instanceof uy1) : invokeL.booleanValue;
    }

    public static void g(qy1 qy1Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, qy1Var, str) == null) || qy1Var == null) {
            return;
        }
        py1.R3(null);
        uk2 U = uk2.U();
        qy1.b i = qy1Var.i("init");
        int i2 = qy1.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", hp2.d(str, U.z()), true).a();
    }

    public static void h(qy1 qy1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, qy1Var, str) == null) {
            if (qy1Var == null) {
                hw1.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(qy1Var)) {
                hw1.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                py1.R3(null);
                qy1.b i = qy1Var.i("init");
                int i2 = qy1.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", hp2.d(str, str), true).a();
                ze3.c().o(qy1Var.m());
            }
        }
    }

    public static void i(d12 d12Var, nl1 nl1Var, ek2 ek2Var, di2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, d12Var, nl1Var, ek2Var, gVar) == null) {
            if (!gv2.H() && ix1.e() != 2) {
                if (gv2.D()) {
                    sw1.k().q(d12Var, nl1Var, ek2Var, gVar);
                    return;
                } else {
                    a(d12Var, nl1Var, ek2Var, gVar);
                    return;
                }
            }
            hw1.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            ix1 ix1Var = new ix1(oi2.c());
            ly2.a aVar = new ly2.a(gz2.J().x());
            aVar.U(R.string.obfuscated_res_0x7f0f0149);
            aVar.v(R.string.obfuscated_res_0x7f0f0138);
            aVar.n(new pe3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0137, new a(ix1Var, d12Var, nl1Var, ek2Var, gVar));
            ly2 X = aVar.X();
            HybridUbcFlow o = ms2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            ix1Var.f(new b(d12Var, nl1Var, ek2Var, gVar, X));
            ix1Var.h();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b(af3.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
