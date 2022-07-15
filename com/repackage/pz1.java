package com.repackage;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.repackage.m62;
import com.repackage.oz2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class pz1 extends nz1 implements oz2.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean V0;
    public static final int W0;
    public static String X0;
    public static hq2 Y0;
    public static String Z0;
    public static String a1;
    public transient /* synthetic */ FieldHolder $fh;
    public n63 F0;
    public hq2 G0;
    public hq2 H0;
    public Map<String, nm1> I0;
    public FrameLayout J0;
    public nm1 K0;
    public tb3 L0;
    public oz2 M0;
    public View N0;
    public w03 O0;
    public int P0;
    public u12 Q0;
    public ll1 R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz1 a;

        public a(pz1 pz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R0 = oj2.Q();
                ll1 ll1Var = this.a.R0;
                pz1 pz1Var = this.a;
                ll1Var.a(pz1Var.h0, pz1Var.j0, pz1Var.getContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz1 a;

        public b(pz1 pz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz1Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String b = this.a.K0.b();
                na2 na2Var = new na2();
                na2Var.c = of3.a(b, "scrollViewBackToTop");
                ul2.U().m(b, na2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz1 a;

        public c(pz1 pz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements m62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ pz1 f;

        public d(pz1 pz1Var, m62.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz1Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = pz1Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.repackage.om1] */
        @Override // com.repackage.m62.f
        public void onReady() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y62 y62Var = new y62();
                y62Var.i = this.a.a.M();
                if (!TextUtils.isEmpty(this.b)) {
                    nt2.e(this.a, this.b);
                }
                String b = z33.b(this.c);
                y62Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                y62Var.b = str;
                if (h03.b0() != null) {
                    y62Var.c = h03.b0().d0(b);
                    y62Var.f = h03.b0().X(b);
                }
                y62Var.k = v62.c(h03.M(), y62Var.b);
                y62Var.d = ul2.U().f(b).g;
                y62Var.e = String.valueOf(ex1.a());
                y62Var.g = pz1.V0 || ul2.U().N();
                if (gw2.H()) {
                    y62Var.j = kx1.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    y62Var.h = str2;
                    mt2.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                od3.d();
                this.a.a.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.T(y62Var.b);
                ul2.U().m(this.a.a.b(), y62.a(y62Var));
                if (z62.b()) {
                    z62 z62Var = new z62();
                    z62Var.a = this.a.a.b();
                    ul2.U().u(z62.a(z62Var));
                }
                r63.F(this.a.a.b(), y62Var.b);
                if (pz1.V0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + y62Var.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements af3<h53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz1 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.T0 = false;
                    this.a.a.B2(true, false);
                }
            }
        }

        public e(pz1 pz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(h53 h53Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h53Var) == null) || h53Var == null || h53Var.d || h53Var.j != 1) {
                return;
            }
            be3.e0(new a(this));
        }
    }

    /* loaded from: classes6.dex */
    public class f implements u12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz1 a;

        public f(pz1 pz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz1Var;
        }

        @Override // com.repackage.u12
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                this.a.Y3(i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements w12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz1 a;

        public g(pz1 pz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz1Var;
        }

        @Override // com.repackage.w12
        public void a(qm1 qm1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qm1Var) == null) || qm1Var == null) {
                return;
            }
            qm1Var.u(this.a.Q0);
            qm1Var.b0(this.a.y3());
            vq2.e().a(qm1Var);
        }

        @Override // com.repackage.w12
        public void b(qm1 qm1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qm1Var) == null) || qm1Var == null) {
                return;
            }
            qm1Var.W(this.a.Q0);
            vq2.e().b(qm1Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends s12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz1 c;

        public h(pz1 pz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pz1Var;
        }

        @Override // com.repackage.s12, com.repackage.v12
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.v2(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-82955451, "Lcom/repackage/pz1$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-82955451, "Lcom/repackage/pz1$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    oj2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (pz1.V0) {
                    Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + a);
                }
                return a;
            }
            return invokeV.intValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a() > 0 : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755392726, "Lcom/repackage/pz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755392726, "Lcom/repackage/pz1;");
                return;
            }
        }
        V0 = rg1.a;
        W0 = yd3.g(149.0f);
        X0 = "-1";
        Z0 = "-1";
    }

    public pz1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.G0 = new hq2();
        this.I0 = new TreeMap();
        this.P0 = 0;
        this.S0 = false;
        this.T0 = false;
        this.U0 = false;
    }

    public static pz1 M3(iq2 iq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iq2Var)) == null) {
            pz1 pz1Var = new pz1();
            if (iq2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", iq2Var.m());
                pz1Var.j1(bundle);
            }
            return pz1Var;
        }
        return (pz1) invokeL.objValue;
    }

    public static void S3(hq2 hq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, hq2Var) == null) {
            try {
                if (V0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + hq2Var);
                }
                if (hq2Var == null) {
                    Y0 = null;
                } else {
                    Y0 = (hq2) hq2Var.clone();
                }
            } catch (Exception e2) {
                if (V0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void U3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            a1 = str;
        }
    }

    private void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (R()) {
                pause();
            }
            if (V0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.K0.b())));
            }
        }
    }

    private void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (R()) {
                resume();
            }
            m64 m64Var = this.m0;
            if (m64Var != null && m64Var.i()) {
                this.m0.B(oj2.M().a());
            }
            if (V0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.K0.b())));
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A0();
            Map<String, nm1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (nm1 nm1Var : this.I0.values()) {
                    if (nm1Var != null) {
                        nm1Var.g0();
                    }
                }
            } else {
                nm1 nm1Var2 = this.K0;
                if (nm1Var2 != null) {
                    nm1Var2.g0();
                }
            }
            A3();
        }
    }

    public final void A3() {
        kh2 H0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nm1 o3 = o3();
            if (!(o3 instanceof SwanAppWebViewManager) || (H0 = ((SwanAppWebViewManager) o3).H0()) == null) {
                return;
            }
            H0.d();
        }
    }

    @Override // com.repackage.nz1, com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.B0();
        }
    }

    public final void B3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || G3()) {
            return;
        }
        ul2 U = ul2.U();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (U.f(str).h && this.Q0 == null) {
            this.Q0 = new f(this);
        }
    }

    @DebugTrace
    public void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.n0 == null) {
                this.n0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity == null || this.m0 != null) {
                return;
            }
            this.m0 = new m64(activity, this.l0, p3(), oj2.K(), new qf3());
            new xp2(this.m0, this, this.n0).z();
            if (dq2.e()) {
                this.m0.l(50);
            }
        }
    }

    public boolean D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            tb3 tb3Var = this.L0;
            if (tb3Var == null) {
                return false;
            }
            return tb3Var.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SwanAppConfigData s = ul2.U().s();
            boolean z = false;
            if (s == null) {
                return false;
            }
            return !((TextUtils.equals(s.f(), this.G0.a) || s.r(this.G0.a)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    public final boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            w03 w03Var = this.O0;
            return w03Var != null && w03Var.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.nz1
    public w03 G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.O0 : (w03) invokeV.objValue;
    }

    public boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            w03 w03Var = this.O0;
            if (w03Var != null) {
                return TextUtils.equals(w03Var.j, "custom");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean H3(qz1 qz1Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, qz1Var, swanAppConfigData)) == null) {
            nz1 j = qz1Var.j(0);
            if (j == null || !(j instanceof pz1)) {
                return false;
            }
            String e2 = ((pz1) j).m3().e();
            return swanAppConfigData.r(e2) || TextUtils.equals(swanAppConfigData.f(), e2);
        }
        return invokeLL.booleanValue;
    }

    public final boolean I3() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            qz1 M1 = M1();
            if (M1 == null) {
                return false;
            }
            w03 w03Var = this.O0;
            if ((w03Var != null && w03Var.k) || (s = ul2.U().s()) == null) {
                return false;
            }
            return !H3(M1, s);
        }
        return invokeV.booleanValue;
    }

    public final boolean J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            SwanAppConfigData s = ul2.U().s();
            return (s == null || TextUtils.equals(s.f(), this.G0.e())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean K3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? (this.I0.isEmpty() || this.I0.get(str) == null) ? false : true : invokeL.booleanValue;
    }

    @Override // com.repackage.nz1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (c() != null && c().e() && c().f()) {
                return true;
            }
            if ((c() == null || !c().c()) && !PaymentManager.k()) {
                nm1 nm1Var = this.K0;
                if (nm1Var != null) {
                    if (gn2.g(nm1Var.b())) {
                        return true;
                    }
                    return this.K0.L();
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void L3(l73 l73Var) {
        n63 n63Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, l73Var) == null) || (n63Var = this.F0) == null) {
            return;
        }
        a73.i(n63Var, l73Var);
        this.F0 = null;
    }

    @Override // com.repackage.nz1
    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.K0 == null) {
                if (V0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.b());
            qm1 l = this.K0.l();
            if (l != null) {
                hashMap.put("webViewUrl", l.getCurrentPageUrl());
            }
            ul2.U().u(new ia2("sharebtn", hashMap));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N3() {
        int i2;
        w03 w03Var;
        om1 om1Var;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.l0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (G3()) {
            B2(true, this.T0);
            i2 = 0;
        } else if (F3()) {
            B2(false, false);
            nm1 nm1Var = this.K0;
            if (nm1Var != null) {
                if (nm1Var.l() != null) {
                    om1Var = this.K0.l().t();
                } else {
                    om1Var = this.K0.t();
                }
                if (om1Var != null) {
                    i2 = om1Var.getWebViewScrollY();
                    w03Var = this.O0;
                    if (w03Var != null && w03Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            w03Var = this.O0;
            if (w03Var != null) {
                i3 = 0;
            }
        } else {
            B2(false, false);
            i2 = W0 + this.P0;
            centerTitleView = this.l0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            Y3(i2);
            a4(z);
        }
        z = true;
        centerTitleView = this.l0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        Y3(i2);
        a4(z);
    }

    public final void O3() {
        Bundle p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (p = p()) == null) {
            return;
        }
        this.H0 = Y0;
        if (V0) {
            Log.d("SwanAppFragment", "restoreArguments sPrePageParams=" + this.H0);
        }
        iq2 g2 = iq2.g(p.getString("ai_apps_param"));
        this.j0 = g2;
        if (g2 == null) {
            hq2 hq2Var = this.G0;
            hq2Var.a = "";
            hq2Var.b = "";
            hq2Var.e = "";
            hq2Var.f = "";
        } else {
            this.G0.a = g2.i();
            this.G0.b = this.j0.j();
            this.G0.e = this.j0.l();
            this.G0.f = this.j0.k();
        }
        hq2 hq2Var2 = this.G0;
        hq2Var2.d = z33.b(hq2Var2.e());
        w03 f2 = ul2.U().f(this.G0.g());
        this.O0 = f2;
        if (f2.p) {
            this.O0 = ul2.U().j(this.G0.e());
        }
        if (this.D0) {
            w03 w03Var = this.O0;
            w03Var.f = false;
            w03Var.h = true;
            w03Var.p = true;
        }
        this.P0 = J1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07015b);
    }

    public final void P3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.b());
            ja2 ja2Var = new ja2(hashMap);
            if (V0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.K0.b());
            }
            ul2.U().u(ja2Var);
        }
    }

    public final void Q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!TextUtils.equals(Z0, this.K0.b()) || TextUtils.equals(a1, "switchTab")) {
                int o = this.L0.o(m3().g());
                la2 la2Var = new la2();
                la2Var.c = Z0;
                la2Var.d = this.K0.b();
                la2Var.e = a1;
                la2Var.f = this.G0.a;
                la2Var.g = String.valueOf(o);
                a1 = "";
                if (V0) {
                    Log.d("SwanAppFragment", "sendRouteMessage fromId: " + la2Var.c + " ,toId: " + la2Var.d + " ,RouteType: " + la2Var.e + " page:" + la2Var.f + ",TabIndex: " + la2Var.g);
                }
                ul2.U().u(la2Var);
                Z0 = this.K0.b();
            }
        }
    }

    public void R3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.U0 = z;
        }
    }

    public final void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "setting immersive portrait fullscreen video");
            }
            oc3.h();
            if (this.i0.getWindow() != null) {
                this.i0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = dz2.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f0920e4).setVisibility(8);
            }
            SwanAppActionBar K1 = K1();
            if (K1 != null) {
                K1.setRightMenuStyle();
                K1.setRightZoneImmersiveStyle();
                K1.setBackgroundColor(0);
            }
            View U = U();
            if (U != null) {
                U.findViewById(R.id.obfuscated_res_0x7f090eb8).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) U.findViewById(R.id.obfuscated_res_0x7f090176);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.repackage.nz1
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            super.U1(view2);
            boolean z = false;
            x2(Z1() || E3());
            if (I3()) {
                f2();
            }
            N3();
            this.l0.setOnDoubleClickListener(new b(this));
            if (!r63.i()) {
                r63.d(g03.K().q().W());
            }
            if (G3() && E3()) {
                z = true;
            }
            this.T0 = z;
            if (z) {
                f3();
            }
        }
    }

    public void V3(hq2 hq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, hq2Var) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + hq2Var);
            }
            if (this.L0.o(m3().g()) == this.L0.o(hq2Var.g())) {
                hq2 hq2Var2 = this.G0;
                hq2Var2.e = hq2Var.e;
                hq2Var2.f = hq2Var.f;
                return;
            }
            this.L0.E(hq2Var.g());
            onPause();
            l3(hq2Var, "");
        }
    }

    public final void W3(String str, hq2 hq2Var) {
        nm1 nm1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, str, hq2Var) == null) || this.K0 == (nm1Var = this.I0.get(str)) || nm1Var == null) {
            return;
        }
        w03 f2 = ul2.U().f(str);
        nm1Var.A(this.J0, f2);
        if (!nm1Var.d()) {
            nm1Var.Q(this.J0, f2);
        }
        nm1Var.D(0);
        nm1 nm1Var2 = this.K0;
        if (nm1Var2 != null) {
            nm1Var2.D(8);
        }
        this.K0 = nm1Var;
        hq2 hq2Var2 = this.G0;
        hq2Var2.e = hq2Var.e;
        hq2Var2.f = hq2Var.f;
        nm1Var.i(hq2Var2);
    }

    public final void X3(nm1 nm1Var) {
        u12 u12Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, nm1Var) == null) || (u12Var = this.Q0) == null || nm1Var == null) {
            return;
        }
        nm1Var.W(u12Var);
        if (nm1Var.l() != null) {
            nm1Var.W(this.Q0);
        }
    }

    public final void Y3(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            float f2 = 1.0f;
            float f3 = (i2 - W0) * 1.0f;
            int i3 = this.P0;
            if (i3 == 0) {
                i3 = 1;
            }
            float f4 = f3 / i3;
            if (f4 <= 0.0f) {
                f2 = 0.0f;
            } else if (f4 < 1.0f) {
                f2 = f4;
            }
            int i4 = (int) (255.0f * f2);
            if (V0 && i4 != 0 && i4 != 255) {
                Log.d("SwanAppFragment", "update bar transparent degree: " + f2 + ZeusCrashHandler.NAME_SEPERATOR + i4);
            }
            if3 if3Var = this.t0;
            if (if3Var != null && if3Var.i() && (e2 = this.t0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.l0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            w03 w03Var = this.O0;
            if (w03Var != null && w03Var.i && (centerTitleView = this.l0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.o0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public void Z3() {
        iq2 iq2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (iq2Var = this.j0) == null) {
            return;
        }
        iq2Var.n();
    }

    public final void a4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            int i3 = 0;
            if (z) {
                if3 if3Var = this.t0;
                if (if3Var != null && if3Var.i()) {
                    i2 = yd3.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.J0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.J0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.k0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.k0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = J1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07015b);
            }
            i2 = 0;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.J0.getLayoutParams();
            layoutParams3.topMargin = i3;
            this.J0.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.k0.getLayoutParams();
            layoutParams22.topMargin = i2;
            this.k0.setLayoutParams(layoutParams22);
        }
    }

    @Override // com.repackage.oz2.a
    public oz2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.M0 == null) {
                if (this.N0 == null) {
                    return null;
                }
                this.M0 = new oz2(this, (LinearLayout) this.N0.findViewById(R.id.obfuscated_res_0x7f090175), J1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07015b));
            }
            return this.M0;
        }
        return (oz2) invokeV.objValue;
    }

    @Override // com.repackage.nz1
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d3(nm1 nm1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, nm1Var) == null) || nm1Var == null) {
            return;
        }
        u12 u12Var = this.Q0;
        if (u12Var != null) {
            nm1Var.u(u12Var);
        }
        nm1Var.c0(z3());
    }

    @Override // com.repackage.nz1
    public boolean e2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        iq2 iq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            ul2 U = ul2.U();
            if (U == null || (s = U.s()) == null || !s.n() || (iq2Var = this.j0) == null) {
                return false;
            }
            return s.r(iq2Var.i());
        }
        return invokeV.booleanValue;
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.F0 = a73.c("805");
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            g03.K().q().e0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public final nm1 g3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048612, this, str, str2, str3, str4)) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            m62.e f2 = m62.f(getActivity(), r62.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = mt2.q("route", str4);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.b ? "1" : "0");
            }
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + f2);
            }
            m62.q(f2, new d(this, f2, str4, str2, str, str3));
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (nm1) invokeLLLL.objValue;
    }

    public final void h3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view2) == null) {
            lt2.a("route", "createSlaveWebView start.");
            String h2 = this.j0.h();
            String j = this.j0.j();
            String i2 = this.j0.i();
            String a2 = be3.a(h2, i2, j);
            this.K0 = m62.h(a2);
            if (V0) {
                StringBuilder sb = new StringBuilder();
                sb.append("pageUrl: ");
                sb.append(a2);
                sb.append(" is load: ");
                sb.append(this.K0 != null);
                Log.d("SwanAppFragment", sb.toString());
            }
            if (this.K0 == null) {
                if (V0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
                }
                this.K0 = g3(h2, i2, j, "");
            }
            this.K0.i(this.G0);
            w03 f2 = ul2.U().f(i2);
            this.K0.A(this.J0, f2);
            this.K0.Q(this.J0, f2);
            B3(i2);
            d3(this.K0);
            if (e2()) {
                this.I0.put(i2, this.K0);
                this.L0.f(view2, getContext(), i2);
            }
            lt2.a("route", "createSlaveWebView end.");
            e3();
        }
    }

    @Override // com.repackage.nz1
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            P1();
            k73 k73Var = new k73();
            k73Var.e = "gohome";
            k73Var.c = "bar";
            pz1 H = ul2.U().H();
            iq2 N1 = H == null ? null : H.N1();
            if (N1 != null && !TextUtils.isEmpty(N1.i())) {
                k73Var.a("page", N1.i());
            }
            A1(k73Var);
        }
    }

    public final void i3(hq2 hq2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048615, this, hq2Var, str) == null) && this.I0.get(hq2Var.d) == null) {
            String a2 = be3.a(hq2Var.c, hq2Var.a, hq2Var.b);
            nm1 h2 = m62.h(a2);
            if (h2 != null) {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.I0.put(hq2Var.a, h2);
            } else {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = g3(hq2Var.c, hq2Var.a, hq2Var.b, str);
                this.I0.put(hq2Var.a, h2);
            }
            B3(hq2Var.a);
            d3(h2);
        }
    }

    @Override // com.repackage.nz1, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, motionEvent)) == null) ? Z1() && this.K0.isSlidable(motionEvent) : invokeL.booleanValue;
    }

    public PullToRefreshBaseWebView j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            nm1 nm1Var = this.K0;
            if (nm1Var != null) {
                return nm1Var.j0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    @Override // com.repackage.nz1
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            nm1 nm1Var = this.K0;
            if (nm1Var != null) {
                nm1Var.V();
            }
            C3();
            q3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.n0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(f72.n(g03.K().getAppId()));
            }
            this.m0.u(oj2.M().a(), H1(), this.n0, false);
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            Map<String, nm1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (nm1 nm1Var : this.I0.values()) {
                    if (nm1Var != null) {
                        X3(nm1Var);
                        nm1Var.destroy();
                    }
                }
                this.I0.clear();
            } else {
                nm1 nm1Var2 = this.K0;
                if (nm1Var2 != null) {
                    X3(nm1Var2);
                    this.K0.destroy();
                }
            }
            this.K0 = null;
            if (V0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (this.S0) {
                return;
            }
            m62.n(ul2.U().getActivity());
        }
    }

    public void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.O0.j = "default";
            v1();
            N3();
        }
    }

    public void l3(hq2 hq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, hq2Var, str) == null) {
            S3(this.G0);
            this.H0 = Y0;
            if (V0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.H0);
            }
            String str2 = hq2Var.a;
            String str3 = hq2Var.d;
            w03 f2 = ul2.U().f(TextUtils.isEmpty(str3) ? "" : str3);
            hq2 hq2Var2 = this.G0;
            hq2Var2.a = str2;
            hq2Var2.b = hq2Var != null ? hq2Var.f() : "";
            this.G0.d = str3;
            this.O0 = f2;
            boolean z = !K3(str3);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    nt2.c(7, str);
                } else {
                    nt2.c(6, str);
                }
            }
            if (!z) {
                W3(str3, hq2Var);
            } else {
                i3(hq2Var, str);
                W3(str2, hq2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                mt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                nt2.a(str, hq2Var);
            }
            v2(f2.b);
            C2(SwanAppConfigData.t(f2.c));
            t2(f2.a);
            N3();
            Z3();
            hx1.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str2);
        }
    }

    @Override // com.repackage.nz1, com.baidu.swan.support.v4.app.Fragment
    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && g0()) {
            super.m1(z);
            if (V0) {
                Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (z) {
                resume();
                s3(false);
                return;
            }
            pause();
        }
    }

    @NonNull
    public hq2 m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.G0 : (hq2) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.repackage.om1] */
    @NonNull
    public Pair<Integer, Integer> n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            nm1 nm1Var = this.K0;
            if (nm1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = nm1Var.t().getCurrentWebView();
            return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public nm1 o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.K0 : (nm1) invokeV.objValue;
    }

    @Override // com.repackage.nz1, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onPause();
            b1();
        }
    }

    @Override // com.repackage.nz1, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onResume();
            e1();
            s3(false);
        }
    }

    @Override // com.repackage.nz1
    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.p2();
            N3();
            if (this.U0) {
                T3();
            }
        }
    }

    public final int p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? d2() ? J3() ? 18 : 17 : J3() ? 12 : 15 : invokeV.intValue;
    }

    public void pause() {
        PullToRefreshBaseWebView j0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            boolean z = this.K0 == null;
            String b2 = z ? "" : this.K0.b();
            if (V0) {
                Log.d("SwanAppFragment", "pause() wvID: " + b2);
            }
            if (!z) {
                this.K0.onPause();
                P3("onHide");
                vq2.e().i(false);
            }
            if (c() != null && !c().c() && (!c().f() || c().j())) {
                c().g();
            }
            hx1.i("SwanApp", "onHide");
            gn2.i(b2, false);
            if (!z && (j0 = this.K0.j0()) != null) {
                j0.w(false);
            }
            oj2.H().f(h03.b0() != null ? h03.b0().O() : "");
        }
    }

    public final void q3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048631, this, z) == null) && oj2.K().k(z, 2)) {
            fq2.l(getContext(), this.m0, this.l0, h03.b0().W().f0().paNumber);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, activity) == null) {
            super.r0(activity);
            if (V0) {
                Log.d("SwanAppFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Nullable
    public hq2 r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.H0 : (hq2) invokeV.objValue;
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            boolean z = false;
            boolean z2 = this.K0 == null;
            String b2 = z2 ? "" : this.K0.b();
            if (V0) {
                Log.d("SwanAppFragment", "resume() wvID: " + b2);
            }
            if (!z2) {
                x2((Z1() || E3()) ? true : true);
                this.K0.onResume();
                Q3();
                P3("onShow");
                vq2.e().i(true);
            }
            hx1.i("SwanApp", "onShow");
            gn2.i(b2, true);
            if (hx1.f()) {
                cz1.b();
            }
            oj2.H().e(h03.b0() != null ? h03.b0().O() : "");
        }
    }

    public final void s3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (oj2.K().k(z, 1)) {
                fq2.k(getContext(), this.l0, h03.b0().W().f0().paNumber);
            } else if (h03.b0() == null) {
            } else {
                fq2.o(this.l0, h03.b0().U().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.repackage.nz1
    public boolean t2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i2)) == null) {
            boolean t2 = super.t2(i2);
            N3();
            return t2;
        }
        return invokeI.booleanValue;
    }

    public String t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            nm1 nm1Var = this.K0;
            return nm1Var != null ? nm1Var.b() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            super.u0(bundle);
            O3();
            if (V0) {
                Log.d("SwanAppFragment", "onCreate() obj: " + this);
            }
            bd3.j(new a(this), "SwanAppPageHistory");
            lt2.a("route", "fragment create.");
        }
    }

    public List<String> u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, nm1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, nm1> entry : this.I0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().b());
                    }
                }
            }
            nm1 nm1Var = this.K0;
            if (nm1Var != null) {
                String b2 = nm1Var.b();
                if (!arrayList.contains(b2)) {
                    arrayList.add(b2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public tb3 v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.L0 : (tb3) invokeV.objValue;
    }

    @Override // com.repackage.nz1
    public void w1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            if (!w03.f(this.O0)) {
                super.w1(i2);
                return;
            }
            x1(i2, G3() ? true : true ^ qd3.h(this.i0));
            N3();
        }
    }

    public String w3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, str)) == null) {
            if (this.I0.containsKey(str)) {
                return this.I0.get(str).b();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048643, this, layoutInflater, viewGroup, bundle)) == null) {
            lt2.a("route", "fragment onCreateView.");
            View b2 = ru2.a().b(R.layout.obfuscated_res_0x7f0d00a3, viewGroup, false);
            this.J0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f090176);
            U1(b2);
            T2(b2);
            this.L0 = new tb3(this);
            h3(b2);
            if (!dq2.e() && !dq2.f()) {
                cq2.b(this.K0.b(), String.valueOf(dq2.d()), String.valueOf(dq2.a(dq2.b())));
            }
            if (T1()) {
                b2 = W1(b2);
            }
            this.N0 = D1(b2, this);
            G2(this.K0.B());
            vq2.e().m();
            return this.N0;
        }
        return (View) invokeLLL.objValue;
    }

    public FrameLayout x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.J0 : (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            super.y0();
            this.B0.a();
            if (i.b()) {
                be3.q().postAtFrontOfQueue(new c(this));
            } else {
                j3();
            }
        }
    }

    public final s12 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? new h(this) : (s12) invokeV.objValue;
    }

    public final w12 z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? new g(this) : (w12) invokeV.objValue;
    }
}
