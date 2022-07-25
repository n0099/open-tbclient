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
import com.repackage.ej2;
import com.repackage.fl2;
import com.repackage.jy1;
import com.repackage.mz2;
import com.repackage.rz1;
/* loaded from: classes7.dex */
public class t33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy1 a;
        public final /* synthetic */ e22 b;
        public final /* synthetic */ om1 c;
        public final /* synthetic */ fl2 d;
        public final /* synthetic */ ej2.g e;

        public a(jy1 jy1Var, e22 e22Var, om1 om1Var, fl2 fl2Var, ej2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy1Var, e22Var, om1Var, fl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jy1Var;
            this.b = e22Var;
            this.c = om1Var;
            this.d = fl2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                jy1.g(0);
                t33.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements jy1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e22 a;
        public final /* synthetic */ om1 b;
        public final /* synthetic */ fl2 c;
        public final /* synthetic */ ej2.g d;
        public final /* synthetic */ mz2 e;

        public b(e22 e22Var, om1 om1Var, fl2 fl2Var, ej2.g gVar, mz2 mz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e22Var, om1Var, fl2Var, gVar, mz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e22Var;
            this.b = om1Var;
            this.c = fl2Var;
            this.d = gVar;
            this.e = mz2Var;
        }

        @Override // com.repackage.jy1.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t33.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755341731, "Lcom/repackage/t33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755341731, "Lcom/repackage/t33;");
                return;
            }
        }
        a = sg1.a;
    }

    public static void a(e22 e22Var, om1 om1Var, fl2 fl2Var, ej2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, e22Var, om1Var, fl2Var, gVar) == null) {
            HybridUbcFlow o = nt2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            vl2 U = vl2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, fl2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                q52.c().b(e22Var, om1Var, fl2Var, gVar.b, gVar, false);
                e22Var.e(activity);
                om1Var.e(activity);
                rz1 V = U.V();
                if (V == null) {
                    return;
                }
                iq2 d2 = iq2.d(d, U.z());
                n62.o(ce3.a(d2.c, d2.a, d2.b), om1Var);
                g(V, d);
                b73.E();
                vq2.e(om1Var.b());
                if (!TextUtils.isEmpty(h)) {
                    nt2.l(h);
                }
                b73.F(true, fl2Var.T());
                kf3 T = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T);
                }
                if (T != null) {
                    T.F(1);
                }
                h03 K = h03.K();
                if (K.E() && TextUtils.equals(K.getAppId(), fl2Var.H())) {
                    K.q().J(true);
                }
                k02.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            vl2 U = vl2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                rz1 V = U.V();
                if (V == null) {
                    ix1.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    ix1.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    dg3.a().k();
                    kf3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    h03 K = h03.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    k02.f(true);
                    return;
                }
            }
            ix1.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b : (String) invokeV.objValue;
    }

    public static String d(vl2 vl2Var, fl2 fl2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, vl2Var, fl2Var, swanAppConfigData)) == null) {
            String b2 = vl2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (fl2Var.o0()) {
                    b2 = swanAppConfigData.g(fl2Var.h0());
                } else {
                    b2 = vl2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        fl2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            i03 q = h03.K().q();
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

    public static boolean f(rz1 rz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, rz1Var)) == null) ? rz1Var.k() >= 1 && (rz1Var.m() instanceof vz1) : invokeL.booleanValue;
    }

    public static void g(rz1 rz1Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, rz1Var, str) == null) || rz1Var == null) {
            return;
        }
        qz1.S3(null);
        vl2 U = vl2.U();
        rz1.b i = rz1Var.i("init");
        int i2 = rz1.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", iq2.d(str, U.z()), true).a();
    }

    public static void h(rz1 rz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, rz1Var, str) == null) {
            if (rz1Var == null) {
                ix1.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(rz1Var)) {
                ix1.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                qz1.S3(null);
                rz1.b i = rz1Var.i("init");
                int i2 = rz1.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", iq2.d(str, str), true).a();
                ag3.c().o(rz1Var.m());
            }
        }
    }

    public static void i(e22 e22Var, om1 om1Var, fl2 fl2Var, ej2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, e22Var, om1Var, fl2Var, gVar) == null) {
            if (!hw2.H() && jy1.e() != 2) {
                if (hw2.D()) {
                    tx1.k().q(e22Var, om1Var, fl2Var, gVar);
                    return;
                } else {
                    a(e22Var, om1Var, fl2Var, gVar);
                    return;
                }
            }
            ix1.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            jy1 jy1Var = new jy1(pj2.c());
            mz2.a aVar = new mz2.a(h03.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f014b);
            aVar.v(R.string.obfuscated_res_0x7f0f013a);
            aVar.n(new qf3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0139, new a(jy1Var, e22Var, om1Var, fl2Var, gVar));
            mz2 X = aVar.X();
            HybridUbcFlow o = nt2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            jy1Var.f(new b(e22Var, om1Var, fl2Var, gVar, X));
            jy1Var.h();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b(bg3.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
