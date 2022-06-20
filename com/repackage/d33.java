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
import com.repackage.bz1;
import com.repackage.oi2;
import com.repackage.pk2;
import com.repackage.tx1;
import com.repackage.wy2;
/* loaded from: classes5.dex */
public class d33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx1 a;
        public final /* synthetic */ o12 b;
        public final /* synthetic */ yl1 c;
        public final /* synthetic */ pk2 d;
        public final /* synthetic */ oi2.g e;

        public a(tx1 tx1Var, o12 o12Var, yl1 yl1Var, pk2 pk2Var, oi2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx1Var, o12Var, yl1Var, pk2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx1Var;
            this.b = o12Var;
            this.c = yl1Var;
            this.d = pk2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                tx1.g(0);
                d33.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements tx1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o12 a;
        public final /* synthetic */ yl1 b;
        public final /* synthetic */ pk2 c;
        public final /* synthetic */ oi2.g d;
        public final /* synthetic */ wy2 e;

        public b(o12 o12Var, yl1 yl1Var, pk2 pk2Var, oi2.g gVar, wy2 wy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o12Var, yl1Var, pk2Var, gVar, wy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o12Var;
            this.b = yl1Var;
            this.c = pk2Var;
            this.d = gVar;
            this.e = wy2Var;
        }

        @Override // com.repackage.tx1.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d33.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755818387, "Lcom/repackage/d33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755818387, "Lcom/repackage/d33;");
                return;
            }
        }
        a = cg1.a;
    }

    public static void a(o12 o12Var, yl1 yl1Var, pk2 pk2Var, oi2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, o12Var, yl1Var, pk2Var, gVar) == null) {
            HybridUbcFlow o = xs2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            fl2 U = fl2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, pk2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                a52.c().b(o12Var, yl1Var, pk2Var, gVar.b, gVar, false);
                o12Var.f(activity);
                yl1Var.f(activity);
                bz1 V = U.V();
                if (V == null) {
                    return;
                }
                sp2 d2 = sp2.d(d, U.z());
                x52.o(md3.a(d2.c, d2.a, d2.b), yl1Var);
                g(V, d);
                l63.E();
                fq2.e(yl1Var.c());
                if (!TextUtils.isEmpty(h)) {
                    xs2.l(h);
                }
                l63.F(true, pk2Var.T());
                ue3 T = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T);
                }
                if (T != null) {
                    T.F(1);
                }
                rz2 K = rz2.K();
                if (K.E() && TextUtils.equals(K.getAppId(), pk2Var.H())) {
                    K.r().J(true);
                }
                uz1.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            fl2 U = fl2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                bz1 V = U.V();
                if (V == null) {
                    sw1.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    sw1.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    nf3.a().k();
                    ue3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    rz2 K = rz2.K();
                    if (K.E()) {
                        K.r().J(true);
                    }
                    uz1.f(true);
                    return;
                }
            }
            sw1.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b : (String) invokeV.objValue;
    }

    public static String d(fl2 fl2Var, pk2 pk2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fl2Var, pk2Var, swanAppConfigData)) == null) {
            String b2 = fl2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (pk2Var.o0()) {
                    b2 = swanAppConfigData.g(pk2Var.h0());
                } else {
                    b2 = fl2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        pk2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            sz2 r = rz2.K().r();
            if (r == null || (W = r.W()) == null || (f0 = W.f0()) == null) {
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

    public static boolean f(bz1 bz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bz1Var)) == null) ? bz1Var.k() >= 1 && (bz1Var.m() instanceof fz1) : invokeL.booleanValue;
    }

    public static void g(bz1 bz1Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, bz1Var, str) == null) || bz1Var == null) {
            return;
        }
        az1.S3(null);
        fl2 U = fl2.U();
        bz1.b i = bz1Var.i("init");
        int i2 = bz1.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", sp2.d(str, U.z()), true).a();
    }

    public static void h(bz1 bz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, bz1Var, str) == null) {
            if (bz1Var == null) {
                sw1.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(bz1Var)) {
                sw1.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                az1.S3(null);
                bz1.b i = bz1Var.i("init");
                int i2 = bz1.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", sp2.d(str, str), true).a();
                kf3.c().o(bz1Var.m());
            }
        }
    }

    public static void i(o12 o12Var, yl1 yl1Var, pk2 pk2Var, oi2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, o12Var, yl1Var, pk2Var, gVar) == null) {
            if (!rv2.H() && tx1.e() != 2) {
                if (rv2.D()) {
                    dx1.k().q(o12Var, yl1Var, pk2Var, gVar);
                    return;
                } else {
                    a(o12Var, yl1Var, pk2Var, gVar);
                    return;
                }
            }
            sw1.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            tx1 tx1Var = new tx1(zi2.c());
            wy2.a aVar = new wy2.a(rz2.K().x());
            aVar.U(R.string.obfuscated_res_0x7f0f0149);
            aVar.v(R.string.obfuscated_res_0x7f0f0138);
            aVar.n(new af3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0137, new a(tx1Var, o12Var, yl1Var, pk2Var, gVar));
            wy2 X = aVar.X();
            HybridUbcFlow o = xs2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            tx1Var.f(new b(o12Var, yl1Var, pk2Var, gVar, X));
            tx1Var.h();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b(lf3.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
