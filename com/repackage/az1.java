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
import com.repackage.x52;
import com.repackage.zy2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public class az1 extends yy1 implements zy2.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean V0;
    public static final int W0;
    public static String X0;
    public static sp2 Y0;
    public static String Z0;
    public static String a1;
    public transient /* synthetic */ FieldHolder $fh;
    public y53 F0;
    public sp2 G0;
    public sp2 H0;
    public Map<String, yl1> I0;
    public FrameLayout J0;
    public yl1 K0;
    public eb3 L0;
    public zy2 M0;
    public View N0;
    public h03 O0;
    public int P0;
    public f12 Q0;
    public wk1 R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az1 a;

        public a(az1 az1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var};
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
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R0 = zi2.Q();
                wk1 wk1Var = this.a.R0;
                az1 az1Var = this.a;
                wk1Var.a(az1Var.h0, az1Var.j0, az1Var.getContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az1 a;

        public b(az1 az1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var};
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
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String c = this.a.K0.c();
                y92 y92Var = new y92();
                y92Var.c = ze3.a(c, "scrollViewBackToTop");
                fl2.U().m(c, y92Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az1 a;

        public c(az1 az1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var};
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
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements x52.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x52.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ az1 f;

        public d(az1 az1Var, x52.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = az1Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.repackage.zl1] */
        @Override // com.repackage.x52.f
        public void onReady() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j62 j62Var = new j62();
                j62Var.i = this.a.a.M();
                if (!TextUtils.isEmpty(this.b)) {
                    ys2.e(this.a, this.b);
                }
                String b = k33.b(this.c);
                j62Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                j62Var.b = str;
                if (sz2.b0() != null) {
                    j62Var.c = sz2.b0().d0(b);
                    j62Var.f = sz2.b0().X(b);
                }
                j62Var.k = g62.c(sz2.M(), j62Var.b);
                j62Var.d = fl2.U().f(b).g;
                j62Var.e = String.valueOf(pw1.a());
                j62Var.g = az1.V0 || fl2.U().N();
                if (rv2.H()) {
                    j62Var.j = vw1.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    j62Var.h = str2;
                    xs2.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                zc3.d();
                this.a.a.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.U(j62Var.b);
                fl2.U().m(this.a.a.c(), j62.a(j62Var));
                if (k62.b()) {
                    k62 k62Var = new k62();
                    k62Var.a = this.a.a.c();
                    fl2.U().u(k62.a(k62Var));
                }
                c63.F(this.a.a.c(), j62Var.b);
                if (az1.V0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + j62Var.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements le3<s43> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az1 a;

        /* loaded from: classes5.dex */
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

        public e(az1 az1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(s43 s43Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s43Var) == null) || s43Var == null || s43Var.d || s43Var.j != 1) {
                return;
            }
            md3.e0(new a(this));
        }
    }

    /* loaded from: classes5.dex */
    public class f implements f12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az1 a;

        public f(az1 az1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var};
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
        }

        @Override // com.repackage.f12
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                this.a.Y3(i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements h12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az1 a;

        public g(az1 az1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var};
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
        }

        @Override // com.repackage.h12
        public void a(bm1 bm1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bm1Var) == null) || bm1Var == null) {
                return;
            }
            bm1Var.v(this.a.Q0);
            bm1Var.c0(this.a.y3());
            gq2.e().a(bm1Var);
        }

        @Override // com.repackage.h12
        public void b(bm1 bm1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bm1Var) == null) || bm1Var == null) {
                return;
            }
            bm1Var.X(this.a.Q0);
            gq2.e().b(bm1Var);
        }
    }

    /* loaded from: classes5.dex */
    public class h extends d12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az1 c;

        public h(az1 az1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = az1Var;
        }

        @Override // com.repackage.d12, com.repackage.g12
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.v2(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-512392716, "Lcom/repackage/az1$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-512392716, "Lcom/repackage/az1$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    zi2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (az1.V0) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755839591, "Lcom/repackage/az1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755839591, "Lcom/repackage/az1;");
                return;
            }
        }
        V0 = cg1.a;
        W0 = jd3.g(149.0f);
        X0 = "-1";
        Z0 = "-1";
    }

    public az1() {
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
        this.G0 = new sp2();
        this.I0 = new TreeMap();
        this.P0 = 0;
        this.S0 = false;
        this.T0 = false;
        this.U0 = false;
    }

    public static az1 M3(tp2 tp2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tp2Var)) == null) {
            az1 az1Var = new az1();
            if (tp2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", tp2Var.m());
                az1Var.j1(bundle);
            }
            return az1Var;
        }
        return (az1) invokeL.objValue;
    }

    public static void S3(sp2 sp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, sp2Var) == null) {
            try {
                if (V0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + sp2Var);
                }
                if (sp2Var == null) {
                    Y0 = null;
                } else {
                    Y0 = (sp2) sp2Var.clone();
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
            if (Q()) {
                pause();
            }
            if (V0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.K0.c())));
            }
        }
    }

    private void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (Q()) {
                resume();
            }
            x54 x54Var = this.m0;
            if (x54Var != null && x54Var.i()) {
                this.m0.B(zi2.M().a());
            }
            if (V0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.K0.c())));
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A0();
            Map<String, yl1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (yl1 yl1Var : this.I0.values()) {
                    if (yl1Var != null) {
                        yl1Var.h0();
                    }
                }
            } else {
                yl1 yl1Var2 = this.K0;
                if (yl1Var2 != null) {
                    yl1Var2.h0();
                }
            }
            A3();
        }
    }

    public final void A3() {
        vg2 I0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            yl1 o3 = o3();
            if (!(o3 instanceof SwanAppWebViewManager) || (I0 = ((SwanAppWebViewManager) o3).I0()) == null) {
                return;
            }
            I0.d();
        }
    }

    @Override // com.repackage.yy1, com.baidu.swan.support.v4.app.Fragment
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
        fl2 U = fl2.U();
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
            this.m0 = new x54(activity, this.l0, p3(), zi2.K(), new bf3());
            new ip2(this.m0, this, this.n0).z();
            if (op2.e()) {
                this.m0.l(50);
            }
        }
    }

    public boolean D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            eb3 eb3Var = this.L0;
            if (eb3Var == null) {
                return false;
            }
            return eb3Var.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SwanAppConfigData s = fl2.U().s();
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
            h03 h03Var = this.O0;
            return h03Var != null && h03Var.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.yy1
    public h03 G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.O0 : (h03) invokeV.objValue;
    }

    public boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            h03 h03Var = this.O0;
            if (h03Var != null) {
                return TextUtils.equals(h03Var.j, "custom");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean H3(bz1 bz1Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bz1Var, swanAppConfigData)) == null) {
            yy1 j = bz1Var.j(0);
            if (j == null || !(j instanceof az1)) {
                return false;
            }
            String e2 = ((az1) j).m3().e();
            return swanAppConfigData.r(e2) || TextUtils.equals(swanAppConfigData.f(), e2);
        }
        return invokeLL.booleanValue;
    }

    public final boolean I3() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            bz1 M1 = M1();
            if (M1 == null) {
                return false;
            }
            h03 h03Var = this.O0;
            if ((h03Var != null && h03Var.k) || (s = fl2.U().s()) == null) {
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
            SwanAppConfigData s = fl2.U().s();
            return (s == null || TextUtils.equals(s.f(), this.G0.e())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean K3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? (this.I0.isEmpty() || this.I0.get(str) == null) ? false : true : invokeL.booleanValue;
    }

    @Override // com.repackage.yy1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (c() != null && c().e() && c().f()) {
                return true;
            }
            if ((c() == null || !c().c()) && !PaymentManager.k()) {
                yl1 yl1Var = this.K0;
                if (yl1Var != null) {
                    if (rm2.g(yl1Var.c())) {
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

    public void L3(w63 w63Var) {
        y53 y53Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, w63Var) == null) || (y53Var = this.F0) == null) {
            return;
        }
        l63.i(y53Var, w63Var);
        this.F0 = null;
    }

    @Override // com.repackage.yy1
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
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.c());
            bm1 m = this.K0.m();
            if (m != null) {
                hashMap.put("webViewUrl", m.getCurrentPageUrl());
            }
            fl2.U().u(new t92("sharebtn", hashMap));
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
        h03 h03Var;
        zl1 zl1Var;
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
            yl1 yl1Var = this.K0;
            if (yl1Var != null) {
                if (yl1Var.m() != null) {
                    zl1Var = this.K0.m().u();
                } else {
                    zl1Var = this.K0.u();
                }
                if (zl1Var != null) {
                    i2 = zl1Var.getWebViewScrollY();
                    h03Var = this.O0;
                    if (h03Var != null && h03Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            h03Var = this.O0;
            if (h03Var != null) {
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
        tp2 g2 = tp2.g(p.getString("ai_apps_param"));
        this.j0 = g2;
        if (g2 == null) {
            sp2 sp2Var = this.G0;
            sp2Var.a = "";
            sp2Var.b = "";
            sp2Var.e = "";
            sp2Var.f = "";
        } else {
            this.G0.a = g2.i();
            this.G0.b = this.j0.j();
            this.G0.e = this.j0.l();
            this.G0.f = this.j0.k();
        }
        sp2 sp2Var2 = this.G0;
        sp2Var2.d = k33.b(sp2Var2.e());
        h03 f2 = fl2.U().f(this.G0.g());
        this.O0 = f2;
        if (f2.p) {
            this.O0 = fl2.U().j(this.G0.e());
        }
        if (this.D0) {
            h03 h03Var = this.O0;
            h03Var.f = false;
            h03Var.h = true;
            h03Var.p = true;
        }
        this.P0 = J1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07015b);
    }

    public final void P3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.c());
            u92 u92Var = new u92(hashMap);
            if (V0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.K0.c());
            }
            fl2.U().u(u92Var);
        }
    }

    public final void Q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!TextUtils.equals(Z0, this.K0.c()) || TextUtils.equals(a1, "switchTab")) {
                int o = this.L0.o(m3().g());
                w92 w92Var = new w92();
                w92Var.c = Z0;
                w92Var.d = this.K0.c();
                w92Var.e = a1;
                w92Var.f = this.G0.a;
                w92Var.g = String.valueOf(o);
                a1 = "";
                if (V0) {
                    Log.d("SwanAppFragment", "sendRouteMessage fromId: " + w92Var.c + " ,toId: " + w92Var.d + " ,RouteType: " + w92Var.e + " page:" + w92Var.f + ",TabIndex: " + w92Var.g);
                }
                fl2.U().u(w92Var);
                Z0 = this.K0.c();
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
            zb3.h();
            if (this.i0.getWindow() != null) {
                this.i0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = oy2.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f09203f).setVisibility(8);
            }
            SwanAppActionBar K1 = K1();
            if (K1 != null) {
                K1.setRightMenuStyle();
                K1.setRightZoneImmersiveStyle();
                K1.setBackgroundColor(0);
            }
            View S = S();
            if (S != null) {
                S.findViewById(R.id.obfuscated_res_0x7f090ea9).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) S.findViewById(R.id.obfuscated_res_0x7f090175);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.repackage.yy1
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
            if (!c63.i()) {
                c63.d(rz2.K().r().W());
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

    public void V3(sp2 sp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, sp2Var) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + sp2Var);
            }
            if (this.L0.o(m3().g()) == this.L0.o(sp2Var.g())) {
                sp2 sp2Var2 = this.G0;
                sp2Var2.e = sp2Var.e;
                sp2Var2.f = sp2Var.f;
                return;
            }
            this.L0.E(sp2Var.g());
            onPause();
            l3(sp2Var, "");
        }
    }

    public final void W3(String str, sp2 sp2Var) {
        yl1 yl1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, str, sp2Var) == null) || this.K0 == (yl1Var = this.I0.get(str)) || yl1Var == null) {
            return;
        }
        h03 f2 = fl2.U().f(str);
        yl1Var.B(this.J0, f2);
        if (!yl1Var.e()) {
            yl1Var.R(this.J0, f2);
        }
        yl1Var.E(0);
        yl1 yl1Var2 = this.K0;
        if (yl1Var2 != null) {
            yl1Var2.E(8);
        }
        this.K0 = yl1Var;
        sp2 sp2Var2 = this.G0;
        sp2Var2.e = sp2Var.e;
        sp2Var2.f = sp2Var.f;
        yl1Var.j(sp2Var2);
    }

    public final void X3(yl1 yl1Var) {
        f12 f12Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, yl1Var) == null) || (f12Var = this.Q0) == null || yl1Var == null) {
            return;
        }
        yl1Var.X(f12Var);
        if (yl1Var.m() != null) {
            yl1Var.X(this.Q0);
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
            te3 te3Var = this.t0;
            if (te3Var != null && te3Var.i() && (e2 = this.t0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.l0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            h03 h03Var = this.O0;
            if (h03Var != null && h03Var.i && (centerTitleView = this.l0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.o0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public void Z3() {
        tp2 tp2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (tp2Var = this.j0) == null) {
            return;
        }
        tp2Var.n();
    }

    public final void a4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            int i3 = 0;
            if (z) {
                te3 te3Var = this.t0;
                if (te3Var != null && te3Var.i()) {
                    i2 = jd3.t();
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

    @Override // com.repackage.zy2.a
    public zy2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.M0 == null) {
                if (this.N0 == null) {
                    return null;
                }
                this.M0 = new zy2(this, (LinearLayout) this.N0.findViewById(R.id.obfuscated_res_0x7f090174), J1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07015b));
            }
            return this.M0;
        }
        return (zy2) invokeV.objValue;
    }

    @Override // com.repackage.yy1
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d3(yl1 yl1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, yl1Var) == null) || yl1Var == null) {
            return;
        }
        f12 f12Var = this.Q0;
        if (f12Var != null) {
            yl1Var.v(f12Var);
        }
        yl1Var.d0(z3());
    }

    @Override // com.repackage.yy1
    public boolean e2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        tp2 tp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            fl2 U = fl2.U();
            if (U == null || (s = U.s()) == null || !s.n() || (tp2Var = this.j0) == null) {
                return false;
            }
            return s.r(tp2Var.i());
        }
        return invokeV.booleanValue;
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.F0 = l63.c("805");
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            rz2.K().r().e0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public final yl1 g3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048612, this, str, str2, str3, str4)) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            x52.e f2 = x52.f(getActivity(), c62.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = xs2.q("route", str4);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.b ? "1" : "0");
            }
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + f2);
            }
            x52.q(f2, new d(this, f2, str4, str2, str, str3));
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (yl1) invokeLLLL.objValue;
    }

    public final void h3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view2) == null) {
            ws2.a("route", "createSlaveWebView start.");
            String h2 = this.j0.h();
            String j = this.j0.j();
            String i2 = this.j0.i();
            String a2 = md3.a(h2, i2, j);
            this.K0 = x52.h(a2);
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
            this.K0.j(this.G0);
            h03 f2 = fl2.U().f(i2);
            this.K0.B(this.J0, f2);
            this.K0.R(this.J0, f2);
            B3(i2);
            d3(this.K0);
            if (e2()) {
                this.I0.put(i2, this.K0);
                this.L0.f(view2, getContext(), i2);
            }
            ws2.a("route", "createSlaveWebView end.");
            e3();
        }
    }

    @Override // com.repackage.yy1
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            P1();
            v63 v63Var = new v63();
            v63Var.e = "gohome";
            v63Var.c = "bar";
            az1 H = fl2.U().H();
            tp2 N1 = H == null ? null : H.N1();
            if (N1 != null && !TextUtils.isEmpty(N1.i())) {
                v63Var.a("page", N1.i());
            }
            A1(v63Var);
        }
    }

    public final void i3(sp2 sp2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048615, this, sp2Var, str) == null) && this.I0.get(sp2Var.d) == null) {
            String a2 = md3.a(sp2Var.c, sp2Var.a, sp2Var.b);
            yl1 h2 = x52.h(a2);
            if (h2 != null) {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.I0.put(sp2Var.a, h2);
            } else {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = g3(sp2Var.c, sp2Var.a, sp2Var.b, str);
                this.I0.put(sp2Var.a, h2);
            }
            B3(sp2Var.a);
            d3(h2);
        }
    }

    @Override // com.repackage.yy1, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, motionEvent)) == null) ? Z1() && this.K0.isSlidable(motionEvent) : invokeL.booleanValue;
    }

    @Override // com.repackage.yy1
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            yl1 yl1Var = this.K0;
            if (yl1Var != null) {
                yl1Var.W();
            }
            C3();
            q3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.n0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(q62.n(rz2.K().getAppId()));
            }
            this.m0.u(zi2.M().a(), H1(), this.n0, false);
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            Map<String, yl1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (yl1 yl1Var : this.I0.values()) {
                    if (yl1Var != null) {
                        X3(yl1Var);
                        yl1Var.destroy();
                    }
                }
                this.I0.clear();
            } else {
                yl1 yl1Var2 = this.K0;
                if (yl1Var2 != null) {
                    X3(yl1Var2);
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
            x52.n(fl2.U().getActivity());
        }
    }

    public PullToRefreshBaseWebView k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            yl1 yl1Var = this.K0;
            if (yl1Var != null) {
                return yl1Var.k0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.O0.j = "default";
            v1();
            N3();
        }
    }

    public void l3(sp2 sp2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, sp2Var, str) == null) {
            S3(this.G0);
            this.H0 = Y0;
            if (V0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.H0);
            }
            String str2 = sp2Var.a;
            String str3 = sp2Var.d;
            h03 f2 = fl2.U().f(TextUtils.isEmpty(str3) ? "" : str3);
            sp2 sp2Var2 = this.G0;
            sp2Var2.a = str2;
            sp2Var2.b = sp2Var != null ? sp2Var.f() : "";
            this.G0.d = str3;
            this.O0 = f2;
            boolean z = !K3(str3);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    ys2.c(7, str);
                } else {
                    ys2.c(6, str);
                }
            }
            if (!z) {
                W3(str3, sp2Var);
            } else {
                i3(sp2Var, str);
                W3(str2, sp2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                xs2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                ys2.a(str, sp2Var);
            }
            v2(f2.b);
            C2(SwanAppConfigData.t(f2.c));
            t2(f2.a);
            N3();
            Z3();
            sw1.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str2);
        }
    }

    @Override // com.repackage.yy1, com.baidu.swan.support.v4.app.Fragment
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
    public sp2 m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.G0 : (sp2) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.repackage.zl1] */
    @NonNull
    public Pair<Integer, Integer> n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            yl1 yl1Var = this.K0;
            if (yl1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = yl1Var.u().getCurrentWebView();
            return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public yl1 o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.K0 : (yl1) invokeV.objValue;
    }

    @Override // com.repackage.yy1, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onPause();
            b1();
        }
    }

    @Override // com.repackage.yy1, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onResume();
            e1();
            s3(false);
        }
    }

    @Override // com.repackage.yy1
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
                P3("onHide");
                gq2.e().i(false);
            }
            if (c() != null && !c().c() && (!c().f() || c().j())) {
                c().g();
            }
            sw1.i("SwanApp", "onHide");
            rm2.i(c2, false);
            if (!z && (k0 = this.K0.k0()) != null) {
                k0.w(false);
            }
            zi2.H().f(sz2.b0() != null ? sz2.b0().O() : "");
        }
    }

    public final void q3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048631, this, z) == null) && zi2.K().k(z, 2)) {
            qp2.l(getContext(), this.m0, this.l0, sz2.b0().W().f0().paNumber);
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
    public sp2 r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.H0 : (sp2) invokeV.objValue;
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            boolean z = false;
            boolean z2 = this.K0 == null;
            String c2 = z2 ? "" : this.K0.c();
            if (V0) {
                Log.d("SwanAppFragment", "resume() wvID: " + c2);
            }
            if (!z2) {
                x2((Z1() || E3()) ? true : true);
                this.K0.onResume();
                Q3();
                P3("onShow");
                gq2.e().i(true);
            }
            sw1.i("SwanApp", "onShow");
            rm2.i(c2, true);
            if (sw1.f()) {
                ny1.b();
            }
            zi2.H().e(sz2.b0() != null ? sz2.b0().O() : "");
        }
    }

    public final void s3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (zi2.K().k(z, 1)) {
                qp2.k(getContext(), this.l0, sz2.b0().W().f0().paNumber);
            } else if (sz2.b0() == null) {
            } else {
                qp2.o(this.l0, sz2.b0().U().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.repackage.yy1
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
            yl1 yl1Var = this.K0;
            return yl1Var != null ? yl1Var.c() : "";
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
            mc3.j(new a(this), "SwanAppPageHistory");
            ws2.a("route", "fragment create.");
        }
    }

    public List<String> u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, yl1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, yl1> entry : this.I0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().c());
                    }
                }
            }
            yl1 yl1Var = this.K0;
            if (yl1Var != null) {
                String c2 = yl1Var.c();
                if (!arrayList.contains(c2)) {
                    arrayList.add(c2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public eb3 v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.L0 : (eb3) invokeV.objValue;
    }

    @Override // com.repackage.yy1
    public void w1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            if (!h03.f(this.O0)) {
                super.w1(i2);
                return;
            }
            x1(i2, G3() ? true : true ^ bd3.h(this.i0));
            N3();
        }
    }

    public String w3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, str)) == null) {
            if (this.I0.containsKey(str)) {
                return this.I0.get(str).c();
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
            ws2.a("route", "fragment onCreateView.");
            View b2 = cu2.a().b(R.layout.obfuscated_res_0x7f0d00a3, viewGroup, false);
            this.J0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f090175);
            U1(b2);
            T2(b2);
            this.L0 = new eb3(this);
            h3(b2);
            if (!op2.e() && !op2.f()) {
                np2.b(this.K0.c(), String.valueOf(op2.d()), String.valueOf(op2.a(op2.b())));
            }
            if (T1()) {
                b2 = W1(b2);
            }
            this.N0 = D1(b2, this);
            G2(this.K0.C());
            gq2.e().m();
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
                md3.q().postAtFrontOfQueue(new c(this));
            } else {
                j3();
            }
        }
    }

    public final d12 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? new h(this) : (d12) invokeV.objValue;
    }

    public final h12 z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? new g(this) : (h12) invokeV.objValue;
    }
}
