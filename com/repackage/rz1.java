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
import com.repackage.o62;
import com.repackage.qz2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class rz1 extends pz1 implements qz2.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean V0;
    public static final int W0;
    public static String X0;
    public static jq2 Y0;
    public static String Z0;
    public static String a1;
    public transient /* synthetic */ FieldHolder $fh;
    public p63 F0;
    public jq2 G0;
    public jq2 H0;
    public Map<String, pm1> I0;
    public FrameLayout J0;
    public pm1 K0;
    public vb3 L0;
    public qz2 M0;
    public View N0;
    public y03 O0;
    public int P0;
    public w12 Q0;
    public nl1 R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz1 a;

        public a(rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R0 = qj2.Q();
                nl1 nl1Var = this.a.R0;
                rz1 rz1Var = this.a;
                nl1Var.a(rz1Var.h0, rz1Var.j0, rz1Var.getContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz1 a;

        public b(rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rz1Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String c = this.a.K0.c();
                pa2 pa2Var = new pa2();
                pa2Var.c = qf3.a(c, "scrollViewBackToTop");
                wl2.U().m(c, pa2Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz1 a;

        public c(rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements o62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ rz1 f;

        public d(rz1 rz1Var, o62.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz1Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = rz1Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.repackage.qm1] */
        @Override // com.repackage.o62.f
        public void onReady() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a72 a72Var = new a72();
                a72Var.i = this.a.a.M();
                if (!TextUtils.isEmpty(this.b)) {
                    pt2.e(this.a, this.b);
                }
                String b = b43.b(this.c);
                a72Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                a72Var.b = str;
                if (j03.a0() != null) {
                    a72Var.c = j03.a0().c0(b);
                    a72Var.f = j03.a0().W(b);
                }
                a72Var.k = x62.c(j03.L(), a72Var.b);
                a72Var.d = wl2.U().f(b).g;
                a72Var.e = String.valueOf(gx1.a());
                a72Var.g = rz1.V0 || wl2.U().N();
                if (iw2.H()) {
                    a72Var.j = mx1.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    a72Var.h = str2;
                    ot2.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                qd3.d();
                this.a.a.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.U(a72Var.b);
                wl2.U().m(this.a.a.c(), a72.a(a72Var));
                if (b72.b()) {
                    b72 b72Var = new b72();
                    b72Var.a = this.a.a.c();
                    wl2.U().u(b72.a(b72Var));
                }
                t63.F(this.a.a.c(), a72Var.b);
                if (rz1.V0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + a72Var.toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements cf3<j53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz1 a;

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
                    this.a.a.A2(true, false);
                }
            }
        }

        public e(rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rz1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(j53 j53Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, j53Var) == null) || j53Var == null || j53Var.d || j53Var.j != 1) {
                return;
            }
            de3.e0(new a(this));
        }
    }

    /* loaded from: classes7.dex */
    public class f implements w12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz1 a;

        public f(rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rz1Var;
        }

        @Override // com.repackage.w12
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                this.a.X3(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements y12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz1 a;

        public g(rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rz1Var;
        }

        @Override // com.repackage.y12
        public void a(sm1 sm1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, sm1Var) == null) || sm1Var == null) {
                return;
            }
            sm1Var.v(this.a.Q0);
            sm1Var.c0(this.a.x3());
            xq2.e().a(sm1Var);
        }

        @Override // com.repackage.y12
        public void b(sm1 sm1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sm1Var) == null) || sm1Var == null) {
                return;
            }
            sm1Var.X(this.a.Q0);
            xq2.e().b(sm1Var);
        }
    }

    /* loaded from: classes7.dex */
    public class h extends u12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz1 c;

        public h(rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rz1Var;
        }

        @Override // com.repackage.u12, com.repackage.x12
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.u2(str);
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
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-25697149, "Lcom/repackage/rz1$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-25697149, "Lcom/repackage/rz1$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    qj2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (rz1.V0) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755333144, "Lcom/repackage/rz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755333144, "Lcom/repackage/rz1;");
                return;
            }
        }
        V0 = tg1.a;
        W0 = ae3.g(149.0f);
        X0 = "-1";
        Z0 = "-1";
    }

    public rz1() {
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
        this.G0 = new jq2();
        this.I0 = new TreeMap();
        this.P0 = 0;
        this.S0 = false;
        this.T0 = false;
        this.U0 = false;
    }

    public static rz1 L3(kq2 kq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, kq2Var)) == null) {
            rz1 rz1Var = new rz1();
            if (kq2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", kq2Var.m());
                rz1Var.i1(bundle);
            }
            return rz1Var;
        }
        return (rz1) invokeL.objValue;
    }

    public static void R3(jq2 jq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, jq2Var) == null) {
            try {
                if (V0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + jq2Var);
                }
                if (jq2Var == null) {
                    Y0 = null;
                } else {
                    Y0 = (jq2) jq2Var.clone();
                }
            } catch (Exception e2) {
                if (V0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void T3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            a1 = str;
        }
    }

    private void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (Q()) {
                pause();
            }
            if (V0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.K0.c())));
            }
        }
    }

    private void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (Q()) {
                resume();
            }
            o64 o64Var = this.m0;
            if (o64Var != null && o64Var.j()) {
                this.m0.C(qj2.M().a());
            }
            if (V0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.K0.c())));
            }
        }
    }

    public final void A3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || F3()) {
            return;
        }
        wl2 U = wl2.U();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (U.f(str).h && this.Q0 == null) {
            this.Q0 = new f(this);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.B0();
            Map<String, pm1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (pm1 pm1Var : this.I0.values()) {
                    if (pm1Var != null) {
                        pm1Var.h0();
                    }
                }
            } else {
                pm1 pm1Var2 = this.K0;
                if (pm1Var2 != null) {
                    pm1Var2.h0();
                }
            }
            z3();
        }
    }

    @DebugTrace
    public void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.n0 == null) {
                this.n0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity == null || this.m0 != null) {
                return;
            }
            this.m0 = new o64(activity, this.l0, o3(), qj2.K(), new sf3());
            new zp2(this.m0, this, this.n0).z();
            if (fq2.e()) {
                this.m0.m(50);
            }
        }
    }

    @Override // com.repackage.pz1, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.C0();
        }
    }

    public boolean C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            vb3 vb3Var = this.L0;
            if (vb3Var == null) {
                return false;
            }
            return vb3Var.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SwanAppConfigData s = wl2.U().s();
            boolean z = false;
            if (s == null) {
                return false;
            }
            return !((TextUtils.equals(s.f(), this.G0.a) || s.r(this.G0.a)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    public final boolean E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            y03 y03Var = this.O0;
            return y03Var != null && y03Var.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.pz1
    public y03 F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.O0 : (y03) invokeV.objValue;
    }

    public boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            y03 y03Var = this.O0;
            if (y03Var != null) {
                return TextUtils.equals(y03Var.j, "custom");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean G3(sz1 sz1Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, sz1Var, swanAppConfigData)) == null) {
            pz1 j = sz1Var.j(0);
            if (j == null || !(j instanceof rz1)) {
                return false;
            }
            String e2 = ((rz1) j).l3().e();
            return swanAppConfigData.r(e2) || TextUtils.equals(swanAppConfigData.f(), e2);
        }
        return invokeLL.booleanValue;
    }

    public final boolean H3() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            sz1 L1 = L1();
            if (L1 == null) {
                return false;
            }
            y03 y03Var = this.O0;
            if ((y03Var != null && y03Var.k) || (s = wl2.U().s()) == null) {
                return false;
            }
            return !G3(L1, s);
        }
        return invokeV.booleanValue;
    }

    public final boolean I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            SwanAppConfigData s = wl2.U().s();
            return (s == null || TextUtils.equals(s.f(), this.G0.e())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean J3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? (this.I0.isEmpty() || this.I0.get(str) == null) ? false : true : invokeL.booleanValue;
    }

    public void K3(n73 n73Var) {
        p63 p63Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, n73Var) == null) || (p63Var = this.F0) == null) {
            return;
        }
        c73.i(p63Var, n73Var);
        this.F0 = null;
    }

    @Override // com.repackage.pz1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (getFloatLayer() != null && getFloatLayer().e() && getFloatLayer().f()) {
                return true;
            }
            if ((getFloatLayer() == null || !getFloatLayer().c()) && !PaymentManager.k()) {
                pm1 pm1Var = this.K0;
                if (pm1Var != null) {
                    if (in2.g(pm1Var.c())) {
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

    @Override // com.repackage.pz1
    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.K0 == null) {
                if (V0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.c());
            sm1 m = this.K0.m();
            if (m != null) {
                hashMap.put("webViewUrl", m.getCurrentPageUrl());
            }
            wl2.U().u(new ka2("sharebtn", hashMap));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void M3() {
        int i2;
        y03 y03Var;
        qm1 qm1Var;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.l0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (F3()) {
            A2(true, this.T0);
            i2 = 0;
        } else if (E3()) {
            A2(false, false);
            pm1 pm1Var = this.K0;
            if (pm1Var != null) {
                if (pm1Var.m() != null) {
                    qm1Var = this.K0.m().u();
                } else {
                    qm1Var = this.K0.u();
                }
                if (qm1Var != null) {
                    i2 = qm1Var.getWebViewScrollY();
                    y03Var = this.O0;
                    if (y03Var != null && y03Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            y03Var = this.O0;
            if (y03Var != null) {
                i3 = 0;
            }
        } else {
            A2(false, false);
            i2 = W0 + this.P0;
            centerTitleView = this.l0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            X3(i2);
            Z3(z);
        }
        z = true;
        centerTitleView = this.l0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        X3(i2);
        Z3(z);
    }

    public final void N3() {
        Bundle p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (p = p()) == null) {
            return;
        }
        this.H0 = Y0;
        if (V0) {
            Log.d("SwanAppFragment", "restoreArguments sPrePageParams=" + this.H0);
        }
        kq2 g2 = kq2.g(p.getString("ai_apps_param"));
        this.j0 = g2;
        if (g2 == null) {
            jq2 jq2Var = this.G0;
            jq2Var.a = "";
            jq2Var.b = "";
            jq2Var.e = "";
            jq2Var.f = "";
        } else {
            this.G0.a = g2.i();
            this.G0.b = this.j0.j();
            this.G0.e = this.j0.l();
            this.G0.f = this.j0.k();
        }
        jq2 jq2Var2 = this.G0;
        jq2Var2.d = b43.b(jq2Var2.e());
        y03 f2 = wl2.U().f(this.G0.g());
        this.O0 = f2;
        if (f2.p) {
            this.O0 = wl2.U().j(this.G0.e());
        }
        if (this.D0) {
            y03 y03Var = this.O0;
            y03Var.f = false;
            y03Var.h = true;
            y03Var.p = true;
        }
        this.P0 = I1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07015b);
    }

    public final void O3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.c());
            la2 la2Var = new la2(hashMap);
            if (V0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.K0.c());
            }
            wl2.U().u(la2Var);
        }
    }

    public final void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (!TextUtils.equals(Z0, this.K0.c()) || TextUtils.equals(a1, "switchTab")) {
                int o = this.L0.o(l3().g());
                na2 na2Var = new na2();
                na2Var.c = Z0;
                na2Var.d = this.K0.c();
                na2Var.e = a1;
                na2Var.f = this.G0.a;
                na2Var.g = String.valueOf(o);
                a1 = "";
                if (V0) {
                    Log.d("SwanAppFragment", "sendRouteMessage fromId: " + na2Var.c + " ,toId: " + na2Var.d + " ,RouteType: " + na2Var.e + " page:" + na2Var.f + ",TabIndex: " + na2Var.g);
                }
                wl2.U().u(na2Var);
                Z0 = this.K0.c();
            }
        }
    }

    public void Q3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.U0 = z;
        }
    }

    public final void S3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "setting immersive portrait fullscreen video");
            }
            qc3.h();
            if (this.i0.getWindow() != null) {
                this.i0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = fz2.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f09203c).setVisibility(8);
            }
            SwanAppActionBar J1 = J1();
            if (J1 != null) {
                J1.setRightMenuStyle();
                J1.setRightZoneImmersiveStyle();
                J1.setBackgroundColor(0);
            }
            View S = S();
            if (S != null) {
                S.findViewById(R.id.obfuscated_res_0x7f090ee4).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) S.findViewById(R.id.obfuscated_res_0x7f090182);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.repackage.pz1
    public void T1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            super.T1(view2);
            boolean z = false;
            w2(Y1() || D3());
            if (H3()) {
                e2();
            }
            M3();
            this.l0.setOnDoubleClickListener(new b(this));
            if (!t63.i()) {
                t63.d(i03.J().r().V());
            }
            if (F3() && D3()) {
                z = true;
            }
            this.T0 = z;
            if (z) {
                e3();
            }
        }
    }

    public void U3(jq2 jq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, jq2Var) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + jq2Var);
            }
            if (this.L0.o(l3().g()) == this.L0.o(jq2Var.g())) {
                jq2 jq2Var2 = this.G0;
                jq2Var2.e = jq2Var.e;
                jq2Var2.f = jq2Var.f;
                return;
            }
            this.L0.E(jq2Var.g());
            onPause();
            k3(jq2Var, "");
        }
    }

    public final void V3(String str, jq2 jq2Var) {
        pm1 pm1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048600, this, str, jq2Var) == null) || this.K0 == (pm1Var = this.I0.get(str)) || pm1Var == null) {
            return;
        }
        y03 f2 = wl2.U().f(str);
        pm1Var.B(this.J0, f2);
        if (!pm1Var.e()) {
            pm1Var.R(this.J0, f2);
        }
        pm1Var.E(0);
        pm1 pm1Var2 = this.K0;
        if (pm1Var2 != null) {
            pm1Var2.E(8);
        }
        this.K0 = pm1Var;
        jq2 jq2Var2 = this.G0;
        jq2Var2.e = jq2Var.e;
        jq2Var2.f = jq2Var.f;
        pm1Var.j(jq2Var2);
    }

    public final void W3(pm1 pm1Var) {
        w12 w12Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, pm1Var) == null) || (w12Var = this.Q0) == null || pm1Var == null) {
            return;
        }
        pm1Var.X(w12Var);
        if (pm1Var.m() != null) {
            pm1Var.X(this.Q0);
        }
    }

    public final void X3(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
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
            kf3 kf3Var = this.t0;
            if (kf3Var != null && kf3Var.i() && (e2 = this.t0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.l0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            y03 y03Var = this.O0;
            if (y03Var != null && y03Var.i && (centerTitleView = this.l0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.o0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public void Y3() {
        kq2 kq2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (kq2Var = this.j0) == null) {
            return;
        }
        kq2Var.n();
    }

    public final void Z3(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            int i3 = 0;
            if (z) {
                kf3 kf3Var = this.t0;
                if (kf3Var != null && kf3Var.i()) {
                    i2 = ae3.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.J0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.J0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.k0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.k0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = I1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07015b);
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

    @Override // com.repackage.pz1
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void c3(pm1 pm1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, pm1Var) == null) || pm1Var == null) {
            return;
        }
        w12 w12Var = this.Q0;
        if (w12Var != null) {
            pm1Var.v(w12Var);
        }
        pm1Var.d0(y3());
    }

    @Override // com.repackage.pz1
    public boolean d2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        kq2 kq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            wl2 U = wl2.U();
            if (U == null || (s = U.s()) == null || !s.n() || (kq2Var = this.j0) == null) {
                return false;
            }
            return s.r(kq2Var.i());
        }
        return invokeV.booleanValue;
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.F0 = c73.c("805");
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            i03.J().r().d0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public final pm1 f3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048610, this, str, str2, str3, str4)) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            o62.e f2 = o62.f(getActivity(), t62.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = ot2.q("route", str4);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.b ? "1" : "0");
            }
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + f2);
            }
            o62.q(f2, new d(this, f2, str4, str2, str, str3));
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (pm1) invokeLLLL.objValue;
    }

    public final void g3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view2) == null) {
            nt2.a("route", "createSlaveWebView start.");
            String h2 = this.j0.h();
            String j = this.j0.j();
            String i2 = this.j0.i();
            String a2 = de3.a(h2, i2, j);
            this.K0 = o62.h(a2);
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
                this.K0 = f3(h2, i2, j, "");
            }
            this.K0.j(this.G0);
            y03 f2 = wl2.U().f(i2);
            this.K0.B(this.J0, f2);
            this.K0.R(this.J0, f2);
            A3(i2);
            c3(this.K0);
            if (d2()) {
                this.I0.put(i2, this.K0);
                this.L0.f(view2, getContext(), i2);
            }
            nt2.a("route", "createSlaveWebView end.");
            d3();
        }
    }

    @Override // com.repackage.qz2.a
    public qz2 getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.M0 == null) {
                if (this.N0 == null) {
                    return null;
                }
                this.M0 = new qz2(this, (LinearLayout) this.N0.findViewById(R.id.obfuscated_res_0x7f090181), I1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07015b));
            }
            return this.M0;
        }
        return (qz2) invokeV.objValue;
    }

    @Override // com.repackage.pz1
    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            O1();
            m73 m73Var = new m73();
            m73Var.e = "gohome";
            m73Var.c = "bar";
            rz1 H = wl2.U().H();
            kq2 M1 = H == null ? null : H.M1();
            if (M1 != null && !TextUtils.isEmpty(M1.i())) {
                m73Var.a("page", M1.i());
            }
            z1(m73Var);
        }
    }

    public final void h3(jq2 jq2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048614, this, jq2Var, str) == null) && this.I0.get(jq2Var.d) == null) {
            String a2 = de3.a(jq2Var.c, jq2Var.a, jq2Var.b);
            pm1 h2 = o62.h(a2);
            if (h2 != null) {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.I0.put(jq2Var.a, h2);
            } else {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = f3(jq2Var.c, jq2Var.a, jq2Var.b, str);
                this.I0.put(jq2Var.a, h2);
            }
            A3(jq2Var.a);
            c3(h2);
        }
    }

    @Override // com.repackage.pz1
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            pm1 pm1Var = this.K0;
            if (pm1Var != null) {
                pm1Var.W();
            }
            B3();
            p3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.n0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(h72.n(i03.J().getAppId()));
            }
            this.m0.u(qj2.M().a(), G1(), this.n0, false);
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            Map<String, pm1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (pm1 pm1Var : this.I0.values()) {
                    if (pm1Var != null) {
                        W3(pm1Var);
                        pm1Var.destroy();
                    }
                }
                this.I0.clear();
            } else {
                pm1 pm1Var2 = this.K0;
                if (pm1Var2 != null) {
                    W3(pm1Var2);
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
            o62.n(wl2.U().getActivity());
        }
    }

    @Override // com.repackage.pz1, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, motionEvent)) == null) ? Y1() && this.K0.isSlidable(motionEvent) : invokeL.booleanValue;
    }

    public void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.O0.j = "default";
            u1();
            M3();
        }
    }

    public PullToRefreshBaseWebView k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            pm1 pm1Var = this.K0;
            if (pm1Var != null) {
                return pm1Var.k0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public void k3(jq2 jq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, jq2Var, str) == null) {
            R3(this.G0);
            this.H0 = Y0;
            if (V0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.H0);
            }
            String str2 = jq2Var.a;
            String str3 = jq2Var.d;
            y03 f2 = wl2.U().f(TextUtils.isEmpty(str3) ? "" : str3);
            jq2 jq2Var2 = this.G0;
            jq2Var2.a = str2;
            jq2Var2.b = jq2Var != null ? jq2Var.f() : "";
            this.G0.d = str3;
            this.O0 = f2;
            boolean z = !J3(str3);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    pt2.c(7, str);
                } else {
                    pt2.c(6, str);
                }
            }
            if (!z) {
                V3(str3, jq2Var);
            } else {
                h3(jq2Var, str);
                V3(str2, jq2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                ot2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                pt2.a(str, jq2Var);
            }
            u2(f2.b);
            B2(SwanAppConfigData.t(f2.c));
            s2(f2.a);
            M3();
            Y3();
            jx1.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str2);
        }
    }

    @Override // com.repackage.pz1, com.baidu.swan.support.v4.app.Fragment
    public void l1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048621, this, z) == null) && g0()) {
            super.l1(z);
            if (V0) {
                Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (z) {
                resume();
                r3(false);
                return;
            }
            pause();
        }
    }

    @NonNull
    public jq2 l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.G0 : (jq2) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.repackage.qm1] */
    @NonNull
    public Pair<Integer, Integer> m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            pm1 pm1Var = this.K0;
            if (pm1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = pm1Var.u().getCurrentWebView();
            return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public pm1 n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.K0 : (pm1) invokeV.objValue;
    }

    @Override // com.repackage.pz1
    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            super.o2();
            M3();
            if (this.U0) {
                S3();
            }
        }
    }

    public final int o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? c2() ? I3() ? 18 : 17 : I3() ? 12 : 15 : invokeV.intValue;
    }

    @Override // com.repackage.pz1, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            a1();
        }
    }

    @Override // com.repackage.pz1, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            d1();
            r3(false);
        }
    }

    public final void p3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && qj2.K().k(z, 2)) {
            hq2.l(getContext(), this.m0, this.l0, j03.a0().V().f0().paNumber);
        }
    }

    public void pause() {
        PullToRefreshBaseWebView k0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            boolean z = this.K0 == null;
            String c2 = z ? "" : this.K0.c();
            if (V0) {
                Log.d("SwanAppFragment", "pause() wvID: " + c2);
            }
            if (!z) {
                this.K0.onPause();
                O3("onHide");
                xq2.e().i(false);
            }
            if (getFloatLayer() != null && !getFloatLayer().c() && (!getFloatLayer().f() || getFloatLayer().j())) {
                getFloatLayer().g();
            }
            jx1.i("SwanApp", "onHide");
            in2.i(c2, false);
            if (!z && (k0 = this.K0.k0()) != null) {
                k0.w(false);
            }
            qj2.H().f(j03.a0() != null ? j03.a0().N() : "");
        }
    }

    @Nullable
    public jq2 q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.H0 : (jq2) invokeV.objValue;
    }

    public final void r3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            if (qj2.K().k(z, 1)) {
                hq2.k(getContext(), this.l0, j03.a0().V().f0().paNumber);
            } else if (j03.a0() == null) {
            } else {
                hq2.o(this.l0, j03.a0().T().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            boolean z = false;
            boolean z2 = this.K0 == null;
            String c2 = z2 ? "" : this.K0.c();
            if (V0) {
                Log.d("SwanAppFragment", "resume() wvID: " + c2);
            }
            if (!z2) {
                w2((Y1() || D3()) ? true : true);
                this.K0.onResume();
                P3();
                O3("onShow");
                xq2.e().i(true);
            }
            jx1.i("SwanApp", "onShow");
            in2.i(c2, true);
            if (jx1.f()) {
                ez1.b();
            }
            qj2.H().e(j03.a0() != null ? j03.a0().N() : "");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void s0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, activity) == null) {
            super.s0(activity);
            if (V0) {
                Log.d("SwanAppFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Override // com.repackage.pz1
    public boolean s2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i2)) == null) {
            boolean s2 = super.s2(i2);
            M3();
            return s2;
        }
        return invokeI.booleanValue;
    }

    public String s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            pm1 pm1Var = this.K0;
            return pm1Var != null ? pm1Var.c() : "";
        }
        return (String) invokeV.objValue;
    }

    public List<String> t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, pm1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, pm1> entry : this.I0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().c());
                    }
                }
            }
            pm1 pm1Var = this.K0;
            if (pm1Var != null) {
                String c2 = pm1Var.c();
                if (!arrayList.contains(c2)) {
                    arrayList.add(c2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public vb3 u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.L0 : (vb3) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, bundle) == null) {
            super.v0(bundle);
            N3();
            if (V0) {
                Log.d("SwanAppFragment", "onCreate() obj: " + this);
            }
            dd3.j(new a(this), "SwanAppPageHistory");
            nt2.a("route", "fragment create.");
        }
    }

    @Override // com.repackage.pz1
    public void v1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            if (!y03.f(this.O0)) {
                super.v1(i2);
                return;
            }
            w1(i2, F3() ? true : true ^ sd3.h(this.i0));
            M3();
        }
    }

    public String v3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, str)) == null) {
            if (this.I0.containsKey(str)) {
                return this.I0.get(str).c();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public FrameLayout w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.J0 : (FrameLayout) invokeV.objValue;
    }

    public final u12 x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? new h(this) : (u12) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048644, this, layoutInflater, viewGroup, bundle)) == null) {
            nt2.a("route", "fragment onCreateView.");
            View b2 = tu2.a().b(R.layout.obfuscated_res_0x7f0d00ac, viewGroup, false);
            this.J0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f090182);
            T1(b2);
            S2(b2);
            this.L0 = new vb3(this);
            g3(b2);
            if (!fq2.e() && !fq2.f()) {
                eq2.b(this.K0.c(), String.valueOf(fq2.d()), String.valueOf(fq2.a(fq2.b())));
            }
            if (S1()) {
                b2 = V1(b2);
            }
            this.N0 = C1(b2, this);
            F2(this.K0.C());
            xq2.e().m();
            return this.N0;
        }
        return (View) invokeLLL.objValue;
    }

    public final y12 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? new g(this) : (y12) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            super.z0();
            this.B0.a();
            if (i.b()) {
                de3.q().postAtFrontOfQueue(new c(this));
            } else {
                i3();
            }
        }
    }

    public final void z3() {
        mh2 I0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            pm1 n3 = n3();
            if (!(n3 instanceof SwanAppWebViewManager) || (I0 = ((SwanAppWebViewManager) n3).I0()) == null) {
                return;
            }
            I0.d();
        }
    }
}
