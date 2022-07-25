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
import com.repackage.n62;
import com.repackage.pz2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class qz1 extends oz1 implements pz2.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean V0;
    public static final int W0;
    public static String X0;
    public static iq2 Y0;
    public static String Z0;
    public static String a1;
    public transient /* synthetic */ FieldHolder $fh;
    public o63 F0;
    public iq2 G0;
    public iq2 H0;
    public Map<String, om1> I0;
    public FrameLayout J0;
    public om1 K0;
    public ub3 L0;
    public pz2 M0;
    public View N0;
    public x03 O0;
    public int P0;
    public v12 Q0;
    public ml1 R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 a;

        public a(qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R0 = pj2.Q();
                ml1 ml1Var = this.a.R0;
                qz1 qz1Var = this.a;
                ml1Var.a(qz1Var.b0, qz1Var.d0, qz1Var.getContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 a;

        public b(qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz1Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String b = this.a.K0.b();
                oa2 oa2Var = new oa2();
                oa2Var.c = pf3.a(b, "scrollViewBackToTop");
                vl2.U().m(b, oa2Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 a;

        public c(qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements n62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ qz1 f;

        public d(qz1 qz1Var, n62.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = qz1Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.repackage.pm1] */
        @Override // com.repackage.n62.f
        public void onReady() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z62 z62Var = new z62();
                z62Var.i = this.a.a.M();
                if (!TextUtils.isEmpty(this.b)) {
                    ot2.e(this.a, this.b);
                }
                String b = a43.b(this.c);
                z62Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                z62Var.b = str;
                if (i03.b0() != null) {
                    z62Var.c = i03.b0().d0(b);
                    z62Var.f = i03.b0().X(b);
                }
                z62Var.k = w62.c(i03.M(), z62Var.b);
                z62Var.d = vl2.U().f(b).g;
                z62Var.e = String.valueOf(fx1.a());
                z62Var.g = qz1.V0 || vl2.U().N();
                if (hw2.H()) {
                    z62Var.j = lx1.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    z62Var.h = str2;
                    nt2.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                pd3.d();
                this.a.a.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.T(z62Var.b);
                vl2.U().m(this.a.a.b(), z62.a(z62Var));
                if (a72.b()) {
                    a72 a72Var = new a72();
                    a72Var.a = this.a.a.b();
                    vl2.U().u(a72.a(a72Var));
                }
                s63.F(this.a.a.b(), z62Var.b);
                if (qz1.V0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + z62Var.toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements bf3<i53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 a;

        /* loaded from: classes7.dex */
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

        public e(qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(i53 i53Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i53Var) == null) || i53Var == null || i53Var.d || i53Var.j != 1) {
                return;
            }
            ce3.e0(new a(this));
        }
    }

    /* loaded from: classes7.dex */
    public class f implements v12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 a;

        public f(qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz1Var;
        }

        @Override // com.repackage.v12
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                this.a.Y3(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements x12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 a;

        public g(qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz1Var;
        }

        @Override // com.repackage.x12
        public void a(rm1 rm1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, rm1Var) == null) || rm1Var == null) {
                return;
            }
            rm1Var.u(this.a.Q0);
            rm1Var.b0(this.a.y3());
            wq2.e().a(rm1Var);
        }

        @Override // com.repackage.x12
        public void b(rm1 rm1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rm1Var) == null) || rm1Var == null) {
                return;
            }
            rm1Var.W(this.a.Q0);
            wq2.e().b(rm1Var);
        }
    }

    /* loaded from: classes7.dex */
    public class h extends t12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 c;

        public h(qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qz1Var;
        }

        @Override // com.repackage.t12, com.repackage.w12
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.v2(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-54326300, "Lcom/repackage/qz1$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-54326300, "Lcom/repackage/qz1$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    pj2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (qz1.V0) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755362935, "Lcom/repackage/qz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755362935, "Lcom/repackage/qz1;");
                return;
            }
        }
        V0 = sg1.a;
        W0 = zd3.g(149.0f);
        X0 = "-1";
        Z0 = "-1";
    }

    public qz1() {
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
        this.G0 = new iq2();
        this.I0 = new TreeMap();
        this.P0 = 0;
        this.S0 = false;
        this.T0 = false;
        this.U0 = false;
    }

    public static qz1 M3(jq2 jq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jq2Var)) == null) {
            qz1 qz1Var = new qz1();
            if (jq2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", jq2Var.m());
                qz1Var.j1(bundle);
            }
            return qz1Var;
        }
        return (qz1) invokeL.objValue;
    }

    public static void S3(iq2 iq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, iq2Var) == null) {
            try {
                if (V0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + iq2Var);
                }
                if (iq2Var == null) {
                    Y0 = null;
                } else {
                    Y0 = (iq2) iq2Var.clone();
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
            n64 n64Var = this.g0;
            if (n64Var != null && n64Var.i()) {
                this.g0.B(pj2.M().a());
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
            Map<String, om1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (om1 om1Var : this.I0.values()) {
                    if (om1Var != null) {
                        om1Var.g0();
                    }
                }
            } else {
                om1 om1Var2 = this.K0;
                if (om1Var2 != null) {
                    om1Var2.g0();
                }
            }
            A3();
        }
    }

    public final void A3() {
        lh2 H0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            om1 o3 = o3();
            if (!(o3 instanceof SwanAppWebViewManager) || (H0 = ((SwanAppWebViewManager) o3).H0()) == null) {
                return;
            }
            H0.d();
        }
    }

    @Override // com.repackage.oz1, com.baidu.swan.support.v4.app.Fragment
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
        vl2 U = vl2.U();
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
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity == null || this.g0 != null) {
                return;
            }
            this.g0 = new n64(activity, this.f0, p3(), pj2.K(), new rf3());
            new yp2(this.g0, this, this.h0).z();
            if (eq2.e()) {
                this.g0.l(50);
            }
        }
    }

    public boolean D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ub3 ub3Var = this.L0;
            if (ub3Var == null) {
                return false;
            }
            return ub3Var.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SwanAppConfigData s = vl2.U().s();
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
            x03 x03Var = this.O0;
            return x03Var != null && x03Var.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.oz1
    public x03 G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.O0 : (x03) invokeV.objValue;
    }

    public boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            x03 x03Var = this.O0;
            if (x03Var != null) {
                return TextUtils.equals(x03Var.j, "custom");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean H3(rz1 rz1Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, rz1Var, swanAppConfigData)) == null) {
            oz1 j = rz1Var.j(0);
            if (j == null || !(j instanceof qz1)) {
                return false;
            }
            String e2 = ((qz1) j).m3().e();
            return swanAppConfigData.r(e2) || TextUtils.equals(swanAppConfigData.f(), e2);
        }
        return invokeLL.booleanValue;
    }

    public final boolean I3() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            rz1 M1 = M1();
            if (M1 == null) {
                return false;
            }
            x03 x03Var = this.O0;
            if ((x03Var != null && x03Var.k) || (s = vl2.U().s()) == null) {
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
            SwanAppConfigData s = vl2.U().s();
            return (s == null || TextUtils.equals(s.f(), this.G0.e())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean K3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? (this.I0.isEmpty() || this.I0.get(str) == null) ? false : true : invokeL.booleanValue;
    }

    @Override // com.repackage.oz1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (c() != null && c().e() && c().f()) {
                return true;
            }
            if ((c() == null || !c().c()) && !PaymentManager.k()) {
                om1 om1Var = this.K0;
                if (om1Var != null) {
                    if (hn2.g(om1Var.b())) {
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

    public void L3(m73 m73Var) {
        o63 o63Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, m73Var) == null) || (o63Var = this.F0) == null) {
            return;
        }
        b73.i(o63Var, m73Var);
        this.F0 = null;
    }

    @Override // com.repackage.oz1
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
            rm1 l = this.K0.l();
            if (l != null) {
                hashMap.put("webViewUrl", l.getCurrentPageUrl());
            }
            vl2.U().u(new ja2("sharebtn", hashMap));
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
        x03 x03Var;
        pm1 pm1Var;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.f0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (G3()) {
            B2(true, this.T0);
            i2 = 0;
        } else if (F3()) {
            B2(false, false);
            om1 om1Var = this.K0;
            if (om1Var != null) {
                if (om1Var.l() != null) {
                    pm1Var = this.K0.l().t();
                } else {
                    pm1Var = this.K0.t();
                }
                if (pm1Var != null) {
                    i2 = pm1Var.getWebViewScrollY();
                    x03Var = this.O0;
                    if (x03Var != null && x03Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            x03Var = this.O0;
            if (x03Var != null) {
                i3 = 0;
            }
        } else {
            B2(false, false);
            i2 = W0 + this.P0;
            centerTitleView = this.f0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            Y3(i2);
            a4(z);
        }
        z = true;
        centerTitleView = this.f0.getCenterTitleView();
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
        jq2 g2 = jq2.g(p.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            iq2 iq2Var = this.G0;
            iq2Var.a = "";
            iq2Var.b = "";
            iq2Var.e = "";
            iq2Var.f = "";
        } else {
            this.G0.a = g2.i();
            this.G0.b = this.d0.j();
            this.G0.e = this.d0.l();
            this.G0.f = this.d0.k();
        }
        iq2 iq2Var2 = this.G0;
        iq2Var2.d = a43.b(iq2Var2.e());
        x03 f2 = vl2.U().f(this.G0.g());
        this.O0 = f2;
        if (f2.p) {
            this.O0 = vl2.U().j(this.G0.e());
        }
        if (this.D0) {
            x03 x03Var = this.O0;
            x03Var.f = false;
            x03Var.h = true;
            x03Var.p = true;
        }
        this.P0 = J1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070159);
    }

    public final void P3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.b());
            ka2 ka2Var = new ka2(hashMap);
            if (V0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.K0.b());
            }
            vl2.U().u(ka2Var);
        }
    }

    public final void Q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!TextUtils.equals(Z0, this.K0.b()) || TextUtils.equals(a1, "switchTab")) {
                int o = this.L0.o(m3().g());
                ma2 ma2Var = new ma2();
                ma2Var.c = Z0;
                ma2Var.d = this.K0.b();
                ma2Var.e = a1;
                ma2Var.f = this.G0.a;
                ma2Var.g = String.valueOf(o);
                a1 = "";
                if (V0) {
                    Log.d("SwanAppFragment", "sendRouteMessage fromId: " + ma2Var.c + " ,toId: " + ma2Var.d + " ,RouteType: " + ma2Var.e + " page:" + ma2Var.f + ",TabIndex: " + ma2Var.g);
                }
                vl2.U().u(ma2Var);
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
            pc3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = ez2.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f0920e6).setVisibility(8);
            }
            SwanAppActionBar K1 = K1();
            if (K1 != null) {
                K1.setRightMenuStyle();
                K1.setRightZoneImmersiveStyle();
                K1.setBackgroundColor(0);
            }
            View U = U();
            if (U != null) {
                U.findViewById(R.id.obfuscated_res_0x7f090eb1).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) U.findViewById(R.id.obfuscated_res_0x7f090176);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.repackage.oz1
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
            this.f0.setOnDoubleClickListener(new b(this));
            if (!s63.i()) {
                s63.d(h03.K().q().W());
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

    public void V3(iq2 iq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, iq2Var) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + iq2Var);
            }
            if (this.L0.o(m3().g()) == this.L0.o(iq2Var.g())) {
                iq2 iq2Var2 = this.G0;
                iq2Var2.e = iq2Var.e;
                iq2Var2.f = iq2Var.f;
                return;
            }
            this.L0.E(iq2Var.g());
            onPause();
            l3(iq2Var, "");
        }
    }

    public final void W3(String str, iq2 iq2Var) {
        om1 om1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, str, iq2Var) == null) || this.K0 == (om1Var = this.I0.get(str)) || om1Var == null) {
            return;
        }
        x03 f2 = vl2.U().f(str);
        om1Var.A(this.J0, f2);
        if (!om1Var.d()) {
            om1Var.Q(this.J0, f2);
        }
        om1Var.D(0);
        om1 om1Var2 = this.K0;
        if (om1Var2 != null) {
            om1Var2.D(8);
        }
        this.K0 = om1Var;
        iq2 iq2Var2 = this.G0;
        iq2Var2.e = iq2Var.e;
        iq2Var2.f = iq2Var.f;
        om1Var.i(iq2Var2);
    }

    public final void X3(om1 om1Var) {
        v12 v12Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, om1Var) == null) || (v12Var = this.Q0) == null || om1Var == null) {
            return;
        }
        om1Var.W(v12Var);
        if (om1Var.l() != null) {
            om1Var.W(this.Q0);
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
            jf3 jf3Var = this.t0;
            if (jf3Var != null && jf3Var.i() && (e2 = this.t0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            x03 x03Var = this.O0;
            if (x03Var != null && x03Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.i0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public void Z3() {
        jq2 jq2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (jq2Var = this.d0) == null) {
            return;
        }
        jq2Var.n();
    }

    public final void a4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            int i3 = 0;
            if (z) {
                jf3 jf3Var = this.t0;
                if (jf3Var != null && jf3Var.i()) {
                    i2 = zd3.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.J0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.J0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.e0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = J1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070159);
            }
            i2 = 0;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.J0.getLayoutParams();
            layoutParams3.topMargin = i3;
            this.J0.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
            layoutParams22.topMargin = i2;
            this.e0.setLayoutParams(layoutParams22);
        }
    }

    @Override // com.repackage.pz2.a
    public pz2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.M0 == null) {
                if (this.N0 == null) {
                    return null;
                }
                this.M0 = new pz2(this, (LinearLayout) this.N0.findViewById(R.id.obfuscated_res_0x7f090175), J1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070159));
            }
            return this.M0;
        }
        return (pz2) invokeV.objValue;
    }

    @Override // com.repackage.oz1
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d3(om1 om1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, om1Var) == null) || om1Var == null) {
            return;
        }
        v12 v12Var = this.Q0;
        if (v12Var != null) {
            om1Var.u(v12Var);
        }
        om1Var.c0(z3());
    }

    @Override // com.repackage.oz1
    public boolean e2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        jq2 jq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            vl2 U = vl2.U();
            if (U == null || (s = U.s()) == null || !s.n() || (jq2Var = this.d0) == null) {
                return false;
            }
            return s.r(jq2Var.i());
        }
        return invokeV.booleanValue;
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.F0 = b73.c("805");
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            h03.K().q().e0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public final om1 g3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048612, this, str, str2, str3, str4)) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            n62.e f2 = n62.f(getActivity(), s62.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = nt2.q("route", str4);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.b ? "1" : "0");
            }
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + f2);
            }
            n62.q(f2, new d(this, f2, str4, str2, str, str3));
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (om1) invokeLLLL.objValue;
    }

    public final void h3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view2) == null) {
            mt2.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = ce3.a(h2, i2, j);
            this.K0 = n62.h(a2);
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
            x03 f2 = vl2.U().f(i2);
            this.K0.A(this.J0, f2);
            this.K0.Q(this.J0, f2);
            B3(i2);
            d3(this.K0);
            if (e2()) {
                this.I0.put(i2, this.K0);
                this.L0.f(view2, getContext(), i2);
            }
            mt2.a("route", "createSlaveWebView end.");
            e3();
        }
    }

    @Override // com.repackage.oz1
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            P1();
            l73 l73Var = new l73();
            l73Var.e = "gohome";
            l73Var.c = "bar";
            qz1 H = vl2.U().H();
            jq2 N1 = H == null ? null : H.N1();
            if (N1 != null && !TextUtils.isEmpty(N1.i())) {
                l73Var.a("page", N1.i());
            }
            A1(l73Var);
        }
    }

    public final void i3(iq2 iq2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048615, this, iq2Var, str) == null) && this.I0.get(iq2Var.d) == null) {
            String a2 = ce3.a(iq2Var.c, iq2Var.a, iq2Var.b);
            om1 h2 = n62.h(a2);
            if (h2 != null) {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.I0.put(iq2Var.a, h2);
            } else {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = g3(iq2Var.c, iq2Var.a, iq2Var.b, str);
                this.I0.put(iq2Var.a, h2);
            }
            B3(iq2Var.a);
            d3(h2);
        }
    }

    @Override // com.repackage.oz1, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, motionEvent)) == null) ? Z1() && this.K0.isSlidable(motionEvent) : invokeL.booleanValue;
    }

    public PullToRefreshBaseWebView j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            om1 om1Var = this.K0;
            if (om1Var != null) {
                return om1Var.j0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    @Override // com.repackage.oz1
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            om1 om1Var = this.K0;
            if (om1Var != null) {
                om1Var.V();
            }
            C3();
            q3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(g72.n(h03.K().getAppId()));
            }
            this.g0.u(pj2.M().a(), H1(), this.h0, false);
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            Map<String, om1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (om1 om1Var : this.I0.values()) {
                    if (om1Var != null) {
                        X3(om1Var);
                        om1Var.destroy();
                    }
                }
                this.I0.clear();
            } else {
                om1 om1Var2 = this.K0;
                if (om1Var2 != null) {
                    X3(om1Var2);
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
            n62.n(vl2.U().getActivity());
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

    public void l3(iq2 iq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, iq2Var, str) == null) {
            S3(this.G0);
            this.H0 = Y0;
            if (V0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.H0);
            }
            String str2 = iq2Var.a;
            String str3 = iq2Var.d;
            x03 f2 = vl2.U().f(TextUtils.isEmpty(str3) ? "" : str3);
            iq2 iq2Var2 = this.G0;
            iq2Var2.a = str2;
            iq2Var2.b = iq2Var != null ? iq2Var.f() : "";
            this.G0.d = str3;
            this.O0 = f2;
            boolean z = !K3(str3);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    ot2.c(7, str);
                } else {
                    ot2.c(6, str);
                }
            }
            if (!z) {
                W3(str3, iq2Var);
            } else {
                i3(iq2Var, str);
                W3(str2, iq2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                nt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                ot2.a(str, iq2Var);
            }
            v2(f2.b);
            C2(SwanAppConfigData.t(f2.c));
            t2(f2.a);
            N3();
            Z3();
            ix1.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str2);
        }
    }

    @Override // com.repackage.oz1, com.baidu.swan.support.v4.app.Fragment
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
    public iq2 m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.G0 : (iq2) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.repackage.pm1] */
    @NonNull
    public Pair<Integer, Integer> n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            om1 om1Var = this.K0;
            if (om1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = om1Var.t().getCurrentWebView();
            return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public om1 o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.K0 : (om1) invokeV.objValue;
    }

    @Override // com.repackage.oz1, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onPause();
            b1();
        }
    }

    @Override // com.repackage.oz1, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onResume();
            e1();
            s3(false);
        }
    }

    @Override // com.repackage.oz1
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
                wq2.e().i(false);
            }
            if (c() != null && !c().c() && (!c().f() || c().j())) {
                c().g();
            }
            ix1.i("SwanApp", "onHide");
            hn2.i(b2, false);
            if (!z && (j0 = this.K0.j0()) != null) {
                j0.w(false);
            }
            pj2.H().f(i03.b0() != null ? i03.b0().O() : "");
        }
    }

    public final void q3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048631, this, z) == null) && pj2.K().k(z, 2)) {
            gq2.l(getContext(), this.g0, this.f0, i03.b0().W().f0().paNumber);
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
    public iq2 r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.H0 : (iq2) invokeV.objValue;
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
                wq2.e().i(true);
            }
            ix1.i("SwanApp", "onShow");
            hn2.i(b2, true);
            if (ix1.f()) {
                dz1.b();
            }
            pj2.H().e(i03.b0() != null ? i03.b0().O() : "");
        }
    }

    public final void s3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (pj2.K().k(z, 1)) {
                gq2.k(getContext(), this.f0, i03.b0().W().f0().paNumber);
            } else if (i03.b0() == null) {
            } else {
                gq2.o(this.f0, i03.b0().U().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.repackage.oz1
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
            om1 om1Var = this.K0;
            return om1Var != null ? om1Var.b() : "";
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
            cd3.j(new a(this), "SwanAppPageHistory");
            mt2.a("route", "fragment create.");
        }
    }

    public List<String> u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, om1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, om1> entry : this.I0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().b());
                    }
                }
            }
            om1 om1Var = this.K0;
            if (om1Var != null) {
                String b2 = om1Var.b();
                if (!arrayList.contains(b2)) {
                    arrayList.add(b2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public ub3 v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.L0 : (ub3) invokeV.objValue;
    }

    @Override // com.repackage.oz1
    public void w1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            if (!x03.f(this.O0)) {
                super.w1(i2);
                return;
            }
            x1(i2, G3() ? true : true ^ rd3.h(this.c0));
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
            mt2.a("route", "fragment onCreateView.");
            View b2 = su2.a().b(R.layout.obfuscated_res_0x7f0d00a3, viewGroup, false);
            this.J0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f090176);
            U1(b2);
            T2(b2);
            this.L0 = new ub3(this);
            h3(b2);
            if (!eq2.e() && !eq2.f()) {
                dq2.b(this.K0.b(), String.valueOf(eq2.d()), String.valueOf(eq2.a(eq2.b())));
            }
            if (T1()) {
                b2 = W1(b2);
            }
            this.N0 = D1(b2, this);
            G2(this.K0.B());
            wq2.e().m();
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
                ce3.q().postAtFrontOfQueue(new c(this));
            } else {
                j3();
            }
        }
    }

    public final t12 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? new h(this) : (t12) invokeV.objValue;
    }

    public final x12 z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? new g(this) : (x12) invokeV.objValue;
    }
}
