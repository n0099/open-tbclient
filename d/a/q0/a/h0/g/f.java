package d.a.q0.a.h0.g;

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
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import d.a.q0.a.h0.t.a;
import d.a.q0.a.p.d.q0;
import d.a.q0.a.v2.d0;
import d.a.q0.a.v2.f0;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q;
import d.a.q0.a.z1.b.c.a;
import d.a.q0.k.n;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class f extends d.a.q0.a.h0.g.d implements a.InterfaceC1054a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean R0;
    public static final int S0;
    public static String T0;
    public static d.a.q0.a.l1.b U0;
    public static String V0;
    public static String W0;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.a.j2.a C0;
    public d.a.q0.a.l1.b D0;
    public d.a.q0.a.l1.b E0;
    public Map<String, d.a.q0.a.p.e.b> F0;
    public FrameLayout G0;
    public d.a.q0.a.p.e.b H0;
    public d.a.q0.a.o2.b.a I0;
    public d.a.q0.a.z1.b.c.a J0;
    public View K0;
    public d.a.q0.a.a2.n.g L0;
    public int M0;
    public d.a.q0.a.h0.j.c N0;
    public q0 O0;
    public boolean P0;
    public boolean Q0;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f47993e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47993e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47993e.O0 = d.a.q0.a.c1.a.L();
                q0 q0Var = this.f47993e.O0;
                f fVar = this.f47993e;
                q0Var.a(fVar.l0, fVar.q());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f47994a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47994a = fVar;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String b2 = this.f47994a.H0.b();
                d.a.q0.a.o0.d.g gVar = new d.a.q0.a.o0.d.g();
                gVar.f49854c = d.a.q0.a.w2.g.c.a.a(b2, "scrollViewBackToTop");
                d.a.q0.a.g1.f.V().m(b2, gVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f47995e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47995e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47995e.W2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f47996a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47997b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47998c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f47999d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48000e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f48001f;

        public d(f fVar, a.d dVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, dVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48001f = fVar;
            this.f47996a = dVar;
            this.f47997b = str;
            this.f47998c = str2;
            this.f47999d = str3;
            this.f48000e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [d.a.q0.a.p.e.c] */
        @Override // d.a.q0.a.h0.t.a.e
        public void onReady() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.h0.u.d dVar = new d.a.q0.a.h0.u.d();
                dVar.f48554i = this.f47996a.f48514a.L();
                if (!TextUtils.isEmpty(this.f47997b)) {
                    d.a.q0.a.r1.i.e(this.f47996a, this.f47997b);
                }
                String b2 = d.a.q0.a.c2.f.p0.j.b(this.f47998c);
                dVar.f48546a = this.f47999d;
                if (TextUtils.isEmpty(this.f48000e)) {
                    str = this.f47998c;
                } else {
                    str = this.f47998c + "?" + this.f48000e;
                }
                dVar.f48547b = str;
                if (d.a.q0.a.a2.e.Q() != null) {
                    dVar.f48548c = d.a.q0.a.a2.e.Q().S(b2);
                    dVar.f48551f = d.a.q0.a.a2.e.Q().M(b2);
                }
                dVar.k = d.a.q0.a.h0.u.a.c(d.a.q0.a.a2.e.i(), dVar.f48547b);
                dVar.f48549d = d.a.q0.a.g1.f.V().e(b2).f46732g;
                dVar.f48550e = String.valueOf(d.a.q0.a.e0.a.a());
                dVar.f48552g = f.R0 || d.a.q0.a.g1.f.V().O();
                if (d.a.q0.a.u1.a.a.G()) {
                    dVar.j = d.a.q0.a.e0.f.b.d();
                }
                if (!TextUtils.isEmpty(this.f47997b)) {
                    String str2 = this.f47997b;
                    dVar.f48553h = str2;
                    d.a.q0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2).C(new UbcFlowEvent("slave_dispatch_start"));
                }
                d0.d();
                this.f47996a.f48514a.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.f47998c);
                this.f47996a.f48514a.S(dVar.f48547b);
                d.a.q0.a.g1.f.V().m(this.f47996a.f48514a.b(), d.a.q0.a.h0.u.d.a(dVar));
                if (d.a.q0.a.h0.u.e.b()) {
                    d.a.q0.a.h0.u.e eVar = new d.a.q0.a.h0.u.e();
                    eVar.f48557a = this.f47996a.f48514a.b();
                    d.a.q0.a.g1.f.V().v(d.a.q0.a.h0.u.e.a(eVar));
                }
                d.a.q0.a.j2.e.F(this.f47996a.f48514a.b(), dVar.f48547b);
                if (f.R0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + dVar.toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48002e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f48003e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48003e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f48003e.f48002e.Q0 = false;
                    this.f48003e.f48002e.s2(true, false);
                }
            }
        }

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48002e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null || fVar.f47631d || fVar.j != 1) {
                return;
            }
            d.a.q0.a.v2.q0.b0(new a(this));
        }
    }

    /* renamed from: d.a.q0.a.h0.g.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0780f implements d.a.q0.a.h0.j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f48004a;

        public C0780f(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48004a = fVar;
        }

        @Override // d.a.q0.a.h0.j.c
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                this.f48004a.J3(i3);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements d.a.q0.a.h0.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f48005a;

        public g(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48005a = fVar;
        }

        @Override // d.a.q0.a.h0.j.e
        public void a(d.a.q0.a.p.e.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
                return;
            }
            eVar.v(this.f48005a.N0);
            eVar.Z(this.f48005a.l3());
            d.a.q0.a.m1.g.f().a(eVar);
        }

        @Override // d.a.q0.a.h0.j.e
        public void b(d.a.q0.a.p.e.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
                return;
            }
            eVar.V(this.f48005a.N0);
            d.a.q0.a.m1.g.f().b(eVar);
        }
    }

    /* loaded from: classes8.dex */
    public class h extends d.a.q0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f48006c;

        public h(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48006c = fVar;
        }

        @Override // d.a.q0.a.h0.j.a, d.a.q0.a.h0.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f48006c.n2(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f48007a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-698773402, "Ld/a/q0/a/h0/g/f$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-698773402, "Ld/a/q0/a/h0/g/f$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f48007a < 0) {
                    d.a.q0.a.c1.a.Z().getSwitch("swan_app_fragment_destroy_switch", 1);
                    f48007a = 1;
                }
                if (f.R0) {
                    Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + f48007a);
                }
                return f48007a;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705417355, "Ld/a/q0/a/h0/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705417355, "Ld/a/q0/a/h0/g/f;");
                return;
            }
        }
        R0 = d.a.q0.a.k.f49133a;
        S0 = n0.g(149.0f);
        T0 = "-1";
        V0 = "-1";
    }

    public f() {
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
        this.D0 = new d.a.q0.a.l1.b();
        this.F0 = new TreeMap();
        this.M0 = 0;
        this.P0 = false;
        this.Q0 = false;
    }

    public static void E3(d.a.q0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            try {
                if (R0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + bVar);
                }
                if (bVar == null) {
                    U0 = null;
                } else {
                    U0 = (d.a.q0.a.l1.b) bVar.clone();
                }
            } catch (Exception e2) {
                if (R0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void F3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            W0 = str;
        }
    }

    private void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (W()) {
                pause();
            }
            if (R0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.H0.b())));
            }
        }
    }

    private void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (W()) {
                resume();
            }
            n nVar = this.o0;
            if (nVar != null && nVar.g()) {
                this.o0.x(d.a.q0.a.c1.a.H().a());
            }
            if (R0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.H0.b())));
            }
        }
    }

    public static f z3(d.a.q0.a.l1.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, cVar)) == null) {
            f fVar = new f();
            if (cVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", cVar.i());
                fVar.j1(bundle);
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A3() {
        int i2;
        d.a.q0.a.a2.n.g gVar;
        d.a.q0.a.p.e.c cVar;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.n0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (t3()) {
            s2(true, this.Q0);
            i2 = 0;
        } else if (s3()) {
            s2(false, false);
            d.a.q0.a.p.e.b bVar = this.H0;
            if (bVar != null) {
                if (bVar.m() != null) {
                    cVar = this.H0.m().u();
                } else {
                    cVar = this.H0.u();
                }
                if (cVar != null) {
                    i2 = cVar.getWebViewScrollY();
                    gVar = this.L0;
                    if (gVar != null && gVar.f46734i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            gVar = this.L0;
            if (gVar != null) {
                i3 = 0;
            }
        } else {
            s2(false, false);
            i2 = S0 + this.M0;
            centerTitleView = this.n0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            J3(i2);
            L3(z);
        }
        z = true;
        centerTitleView = this.n0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        J3(i2);
        L3(z);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater, viewGroup, bundle)) == null) {
            d.a.q0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment onCreateView.");
            View b2 = d.a.q0.a.r1.n.a.a().b(d.a.q0.a.g.aiapps_fragment, viewGroup, false);
            this.G0 = (FrameLayout) b2.findViewById(d.a.q0.a.f.ai_apps_fragment_content);
            Q1(b2);
            this.I0 = new d.a.q0.a.o2.b.a(this);
            U2(b2);
            if (!d.a.q0.a.j1.e.b.d() && !d.a.q0.a.j1.e.b.e()) {
                d.a.q0.a.j1.e.a.b(this.H0.b(), String.valueOf(d.a.q0.a.j1.e.b.c()), String.valueOf(d.a.q0.a.j1.e.b.a(d.a.q0.a.j1.e.b.b())));
            }
            if (P1()) {
                b2 = S1(b2);
            }
            this.K0 = A1(b2, this);
            this.u0.setRegionFactor(this.H0.F());
            d.a.q0.a.m1.g.f().o();
            return this.K0;
        }
        return (View) invokeLLL.objValue;
    }

    public final void B3() {
        Bundle n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (n = n()) == null) {
            return;
        }
        this.E0 = U0;
        if (R0) {
            Log.d("SwanAppFragment", "restoreArguments sPrePageParams=" + this.E0);
        }
        d.a.q0.a.l1.c e2 = d.a.q0.a.l1.c.e(n.getString("ai_apps_param"));
        this.l0 = e2;
        this.D0.f49291e = e2 != null ? e2.g() : "";
        d.a.q0.a.l1.b bVar = this.D0;
        d.a.q0.a.l1.c cVar = this.l0;
        bVar.f49292f = cVar != null ? cVar.h() : "";
        d.a.q0.a.l1.b bVar2 = this.D0;
        bVar2.f49294h = d.a.q0.a.c2.f.p0.j.b(bVar2.h());
        d.a.q0.a.a2.n.g e3 = d.a.q0.a.g1.f.V().e(this.D0.j());
        this.L0 = e3;
        if (e3.p) {
            this.L0 = d.a.q0.a.g1.f.V().i(this.D0.h());
        }
        this.M0 = G1().getDimensionPixelSize(d.a.q0.a.d.aiapps_normal_base_action_bar_height);
    }

    @Override // d.a.q0.a.h0.g.d
    public void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.H0 == null) {
                if (R0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.H0.b());
            d.a.q0.a.p.e.e m = this.H0.m();
            if (m != null) {
                hashMap.put("webViewUrl", m.getCurrentPageUrl());
            }
            d.a.q0.a.g1.f.V().v(new d.a.q0.a.o0.d.b("sharebtn", hashMap));
        }
    }

    public final void C3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.H0.b());
            d.a.q0.a.o0.d.c cVar = new d.a.q0.a.o0.d.c(hashMap);
            if (R0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.H0.b());
            }
            d.a.q0.a.g1.f.V().v(cVar);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.D0();
            Map<String, d.a.q0.a.p.e.b> map = this.F0;
            if (map != null && !map.isEmpty()) {
                for (d.a.q0.a.p.e.b bVar : this.F0.values()) {
                    if (bVar != null) {
                        bVar.f0();
                    }
                }
            } else {
                d.a.q0.a.p.e.b bVar2 = this.H0;
                if (bVar2 != null) {
                    bVar2.f0();
                }
            }
            n3();
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public d.a.q0.a.a2.n.g D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.L0 : (d.a.q0.a.a2.n.g) invokeV.objValue;
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!TextUtils.equals(V0, this.H0.b()) || TextUtils.equals(W0, "switchTab")) {
                int o = this.I0.o(Z2().j());
                d.a.q0.a.o0.d.e eVar = new d.a.q0.a.o0.d.e();
                eVar.f49847c = V0;
                eVar.f49848d = this.H0.b();
                eVar.f49849e = W0;
                eVar.f49850f = this.D0.f49291e;
                eVar.f49851g = String.valueOf(o);
                W0 = "";
                if (R0) {
                    Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.f49847c + " ,toId: " + eVar.f49848d + " ,RouteType: " + eVar.f49849e + " page:" + eVar.f49850f + ",TabIndex: " + eVar.f49851g);
                }
                d.a.q0.a.g1.f.V().v(eVar);
                V0 = this.H0.b();
            }
        }
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.E0();
        }
    }

    public void G3(d.a.q0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            if (R0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
            }
            if (this.I0.o(Z2().j()) == this.I0.o(bVar.j())) {
                return;
            }
            this.I0.E(bVar.j());
            onPause();
            Y2(bVar, "");
        }
    }

    public final void H3(String str) {
        d.a.q0.a.p.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.H0 == (bVar = this.F0.get(str)) || bVar == null) {
            return;
        }
        d.a.q0.a.a2.n.g e2 = d.a.q0.a.g1.f.V().e(str);
        bVar.B(this.G0, e2);
        if (!bVar.d()) {
            bVar.Q(this.G0, e2);
        }
        bVar.G(0);
        d.a.q0.a.p.e.b bVar2 = this.H0;
        if (bVar2 != null) {
            bVar2.G(8);
        }
        this.H0 = bVar;
        bVar.i(this.D0);
    }

    public final void I3(d.a.q0.a.p.e.b bVar) {
        d.a.q0.a.h0.j.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) || (cVar = this.N0) == null || bVar == null) {
            return;
        }
        bVar.V(cVar);
        if (bVar.m() != null) {
            bVar.V(this.N0);
        }
    }

    public final void J3(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            float f2 = 1.0f;
            float f3 = (i2 - S0) * 1.0f;
            int i3 = this.M0;
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
            if (R0 && i4 != 0 && i4 != 255) {
                Log.d("SwanAppFragment", "update bar transparent degree: " + f2 + ZeusCrashHandler.NAME_SEPERATOR + i4);
            }
            d.a.q0.a.w2.d.b bVar = this.s0;
            if (bVar != null && bVar.i() && (e2 = this.s0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.n0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            d.a.q0.a.a2.n.g gVar = this.L0;
            if (gVar != null && gVar.f46734i && (centerTitleView = this.n0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.q0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if ((getFloatLayer() == null || !getFloatLayer().d()) && !d.a.f0.a.j()) {
                d.a.q0.a.p.e.b bVar = this.H0;
                if (bVar != null) {
                    if (d.a.q0.a.i1.b.g(bVar.b())) {
                        return true;
                    }
                    return this.H0.K();
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void K3() {
        d.a.q0.a.l1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (cVar = this.l0) == null) {
            return;
        }
        cVar.j();
    }

    public final void L3(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            int i3 = 0;
            if (z) {
                d.a.q0.a.w2.d.b bVar = this.s0;
                if (bVar != null && bVar.i()) {
                    i2 = n0.u();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.G0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.G0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.m0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.m0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = G1().getDimensionPixelSize(d.a.q0.a.d.aiapps_normal_base_action_bar_height);
            }
            i2 = 0;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.G0.getLayoutParams();
            layoutParams3.topMargin = i3;
            this.G0.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.m0.getLayoutParams();
            layoutParams22.topMargin = i2;
            this.m0.setLayoutParams(layoutParams22);
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public void Q1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            super.Q1(view);
            boolean z = false;
            p2(V1() || r3());
            if (v3()) {
                a2();
            }
            A3();
            this.n0.setOnDoubleClickListener(new b(this));
            if (!d.a.q0.a.j2.e.i()) {
                d.a.q0.a.j2.e.d(d.a.q0.a.a2.d.g().r().L());
            }
            if (t3() && r3()) {
                z = true;
            }
            this.Q0 = z;
            if (z) {
                S2();
            }
        }
    }

    public final void Q2(d.a.q0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) || bVar == null) {
            return;
        }
        d.a.q0.a.h0.j.c cVar = this.N0;
        if (cVar != null) {
            bVar.v(cVar);
        }
        bVar.a0(m3());
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.C0 = d.a.q0.a.j2.k.c("805");
        }
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            d.a.q0.a.a2.d.g().r().T().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public final d.a.q0.a.p.e.b T2(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048596, this, str, str2, str3, str4)) == null) {
            if (R0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            a.d f2 = d.a.q0.a.h0.t.a.f(h());
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = d.a.q0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str4);
                q.C(new UbcFlowEvent("na_pre_load_slave_check"));
                q.A("preload", f2.f48515b ? "1" : "0");
            }
            if (R0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + f2);
            }
            d.a.q0.a.h0.t.a.n(f2, new d(this, f2, str4, str2, str, str3));
            if (R0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.f48514a;
        }
        return (d.a.q0.a.p.e.b) invokeLLLL.objValue;
    }

    public final void U2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            d.a.q0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView start.");
            String f2 = this.l0.f();
            String h2 = this.l0.h();
            String g2 = this.l0.g();
            String a2 = d.a.q0.a.v2.q0.a(f2, g2, h2);
            this.H0 = d.a.q0.a.h0.t.a.h(a2);
            if (R0) {
                StringBuilder sb = new StringBuilder();
                sb.append("pageUrl: ");
                sb.append(a2);
                sb.append(" is load: ");
                sb.append(this.H0 != null);
                Log.d("SwanAppFragment", sb.toString());
            }
            if (this.H0 == null) {
                if (R0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
                }
                this.H0 = T2(f2, g2, h2, "");
            }
            this.H0.i(this.D0);
            d.a.q0.a.a2.n.g e2 = d.a.q0.a.g1.f.V().e(g2);
            d.a.q0.a.e0.d.g("SwanAppFragment", "create slave webview: " + g2);
            this.H0.B(this.G0, e2);
            this.H0.Q(this.G0, e2);
            o3(g2);
            Q2(this.H0);
            if (Z1()) {
                this.F0.put(g2, this.H0);
                this.I0.f(view, q(), g2);
            }
            d.a.q0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView end.");
            R2();
        }
    }

    public final void V2(d.a.q0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, bVar, str) == null) && this.F0.get(bVar.f49294h) == null) {
            String a2 = d.a.q0.a.v2.q0.a(bVar.f49293g, bVar.f49291e, bVar.f49292f);
            d.a.q0.a.p.e.b h2 = d.a.q0.a.h0.t.a.h(a2);
            if (h2 != null) {
                if (R0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.F0.put(bVar.f49291e, h2);
            } else {
                if (R0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = T2(bVar.f49293g, bVar.f49291e, bVar.f49292f, str);
                this.F0.put(bVar.f49291e, h2);
            }
            o3(bVar.f49291e);
            Q2(h2);
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Map<String, d.a.q0.a.p.e.b> map = this.F0;
            if (map != null && !map.isEmpty()) {
                for (d.a.q0.a.p.e.b bVar : this.F0.values()) {
                    if (bVar != null) {
                        I3(bVar);
                        bVar.destroy();
                    }
                }
                this.F0.clear();
            } else {
                d.a.q0.a.p.e.b bVar2 = this.H0;
                if (bVar2 != null) {
                    I3(bVar2);
                    this.H0.destroy();
                }
            }
            this.H0 = null;
            if (R0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (this.P0) {
                return;
            }
            d.a.q0.a.h0.t.a.l(d.a.q0.a.g1.f.V().getActivity());
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.L0.j = "default";
            t1();
            A3();
        }
    }

    public void Y2(d.a.q0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, bVar, str) == null) {
            E3(this.D0);
            this.E0 = U0;
            if (R0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.E0);
            }
            String str2 = bVar.f49291e;
            String str3 = bVar.f49294h;
            d.a.q0.a.a2.n.g e2 = d.a.q0.a.g1.f.V().e(TextUtils.isEmpty(str3) ? "" : str3);
            d.a.q0.a.l1.b bVar2 = this.D0;
            bVar2.f49291e = str2;
            bVar2.f49292f = bVar != null ? bVar.i() : "";
            this.D0.f49294h = str3;
            this.L0 = e2;
            boolean z = !x3(str3);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    d.a.q0.a.r1.i.c(7, str);
                } else {
                    d.a.q0.a.r1.i.c(6, str);
                }
            }
            if (!z) {
                H3(str3);
            } else {
                V2(bVar, str);
                H3(str2);
            }
            if (!TextUtils.isEmpty(str)) {
                d.a.q0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
                d.a.q0.a.r1.i.a(str, bVar);
            }
            n2(e2.f46727b);
            t2(SwanAppConfigData.s(e2.f46728c));
            l2(e2.f46726a);
            A3();
            K3();
            d.a.q0.a.e0.d.g("SwanAppFragment", "switch tab title: " + e2.f46727b + " page:" + str2);
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        d.a.q0.a.l1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            d.a.q0.a.g1.f V = d.a.q0.a.g1.f.V();
            if (V == null || (s = V.s()) == null || !s.m() || (cVar = this.l0) == null) {
                return false;
            }
            return s.q(cVar.g());
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public d.a.q0.a.l1.b Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.D0 : (d.a.q0.a.l1.b) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [d.a.q0.a.p.e.c] */
    @NonNull
    public Pair<Integer, Integer> a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            d.a.q0.a.p.e.b bVar = this.H0;
            if (bVar == null) {
                return new Pair<>(0, 0);
            }
            AbsoluteLayout currentWebView = bVar.u().getCurrentWebView();
            return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public d.a.q0.a.p.e.b b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.H0 : (d.a.q0.a.p.e.b) invokeV.objValue;
    }

    public final int c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? Y1() ? w3() ? 18 : 17 : w3() ? 12 : 15 : invokeV.intValue;
    }

    @Override // d.a.q0.a.h0.g.d
    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            L1();
            d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
            fVar.f49123e = "gohome";
            fVar.f49121c = "bar";
            f J = d.a.q0.a.g1.f.V().J();
            d.a.q0.a.l1.c K1 = J == null ? null : J.K1();
            if (K1 != null && !TextUtils.isEmpty(K1.g())) {
                fVar.a("page", K1.g());
            }
            y1(fVar);
        }
    }

    public final void d3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048609, this, z) == null) && d.a.q0.a.c1.a.G().i(z, 2)) {
            d.a.q0.a.k1.a.l(q(), this.o0, d.a.q0.a.a2.e.Q().L().f0().paNumber);
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.H0.U();
            p3();
            d3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.p0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(d.a.q0.a.j0.b.a.n(d.a.q0.a.a2.d.g().getAppId()));
            }
            this.o0.r(d.a.q0.a.c1.a.H().a(), E1(), this.p0, false);
        }
    }

    @Nullable
    public d.a.q0.a.l1.b e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.E0 : (d.a.q0.a.l1.b) invokeV.objValue;
    }

    public final void f3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            if (d.a.q0.a.c1.a.G().i(z, 1)) {
                d.a.q0.a.k1.a.k(q(), this.n0, d.a.q0.a.a2.e.Q().L().f0().paNumber);
            } else if (d.a.q0.a.a2.e.Q() == null) {
            } else {
                d.a.q0.a.k1.a.o(this.n0, d.a.q0.a.a2.e.Q().J().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    public String g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            d.a.q0.a.p.e.b bVar = this.H0;
            return bVar != null ? bVar.b() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.z1.b.c.a.InterfaceC1054a
    public d.a.q0.a.z1.b.c.a getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.J0 == null) {
                if (this.K0 == null) {
                    return null;
                }
                this.J0 = new d.a.q0.a.z1.b.c.a(this, (LinearLayout) this.K0.findViewById(d.a.q0.a.f.ai_apps_fragment_base_view), G1().getDimensionPixelOffset(d.a.q0.a.d.aiapps_normal_base_action_bar_height));
            }
            return this.J0;
        }
        return (d.a.q0.a.z1.b.c.a) invokeV.objValue;
    }

    public PullToRefreshBaseWebView h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            d.a.q0.a.p.e.b bVar = this.H0;
            if (bVar != null) {
                return bVar.h0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public List<String> h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, d.a.q0.a.p.e.b> map = this.F0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, d.a.q0.a.p.e.b> entry : this.F0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().b());
                    }
                }
            }
            d.a.q0.a.p.e.b bVar = this.H0;
            if (bVar != null) {
                String b2 = bVar.b();
                if (!arrayList.contains(b2)) {
                    arrayList.add(b2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.q0.a.h0.g.d
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.i2();
            A3();
        }
    }

    @Nullable
    public d.a.q0.a.o2.b.a i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.I0 : (d.a.q0.a.o2.b.a) invokeV.objValue;
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, motionEvent)) == null) ? V1() && this.H0.isSlidable(motionEvent) : invokeL.booleanValue;
    }

    public String j3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, str)) == null) {
            if (this.F0.containsKey(str)) {
                return this.F0.get(str).b();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public FrameLayout k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.G0 : (FrameLayout) invokeV.objValue;
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean l2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) {
            boolean l2 = super.l2(i2);
            A3();
            return l2;
        }
        return invokeI.booleanValue;
    }

    public final d.a.q0.a.h0.j.a l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? new h(this) : (d.a.q0.a.h0.j.a) invokeV.objValue;
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && l0()) {
            super.m1(z);
            if (R0) {
                Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (z) {
                resume();
                f3(false);
                return;
            }
            pause();
        }
    }

    public final d.a.q0.a.h0.j.e m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? new g(this) : (d.a.q0.a.h0.j.e) invokeV.objValue;
    }

    public final void n3() {
        d.a.q0.a.y0.j.b F0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            d.a.q0.a.p.e.b b3 = b3();
            if (!(b3 instanceof SwanAppWebViewManager) || (F0 = ((SwanAppWebViewManager) b3).F0()) == null) {
                return;
            }
            F0.d();
        }
    }

    public final void o3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, str) == null) || t3()) {
            return;
        }
        d.a.q0.a.g1.f V = d.a.q0.a.g1.f.V();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (V.e(str).f46733h && this.N0 == null) {
            this.N0 = new C0780f(this);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, bundle) == null) {
            super.onCreate(bundle);
            B3();
            if (R0) {
                Log.d("SwanAppFragment", "onCreate() obj: " + this);
            }
            q.i(new a(this), "SwanAppPageHistory");
            d.a.q0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment create.");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onDestroy();
            if (i.b()) {
                d.a.q0.a.v2.q0.q().postAtFrontOfQueue(new c(this));
            } else {
                W2();
            }
        }
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onPause();
            a1();
        }
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            super.onResume();
            d1();
            f3(false);
        }
    }

    @DebugTrace
    public void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            FragmentActivity h2 = h();
            if (this.p0 == null) {
                this.p0 = new SwanAppMenuHeaderView(q());
            }
            if (h2 == null || this.o0 != null) {
                return;
            }
            this.o0 = new n(h2, this.n0, c3(), d.a.q0.a.c1.a.G(), new d.a.q0.a.w2.h.b());
            new d.a.q0.a.j1.a(this.o0, this, this.p0).z();
            if (d.a.q0.a.j1.e.b.d()) {
                this.o0.j(50);
            }
        }
    }

    public void pause() {
        PullToRefreshBaseWebView h0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            boolean z = this.H0 == null;
            String b2 = z ? "" : this.H0.b();
            if (R0) {
                Log.d("SwanAppFragment", "pause() wvID: " + b2);
            }
            if (!z) {
                this.H0.onPause();
                C3("onHide");
                d.a.q0.a.m1.g.f().k(false);
            }
            if (getFloatLayer() != null && !getFloatLayer().d()) {
                getFloatLayer().g();
            }
            d.a.q0.a.e0.d.g("SwanApp", "onHide");
            d.a.q0.a.i1.b.i(false);
            if (!z && (h0 = this.H0.h0()) != null) {
                h0.w(false);
            }
            d.a.q0.a.c1.a.D().f(d.a.q0.a.a2.e.Q() != null ? d.a.q0.a.a2.e.Q().D() : "");
        }
    }

    public boolean q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            d.a.q0.a.o2.b.a aVar = this.I0;
            if (aVar == null) {
                return false;
            }
            return aVar.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            SwanAppConfigData s = d.a.q0.a.g1.f.V().s();
            boolean z = false;
            if (s == null) {
                return false;
            }
            return !((TextUtils.equals(s.e(), this.D0.f49291e) || s.q(this.D0.f49291e)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            boolean z = false;
            boolean z2 = this.H0 == null;
            String b2 = z2 ? "" : this.H0.b();
            if (R0) {
                Log.d("SwanAppFragment", "resume() wvID: " + b2);
            }
            if (!z2) {
                p2((V1() || r3()) ? true : true);
                this.H0.onResume();
                D3();
                C3("onShow");
                d.a.q0.a.m1.g.f().k(true);
            }
            d.a.q0.a.e0.d.g("SwanApp", "onShow");
            d.a.q0.a.i1.b.i(true);
            if (d.a.q0.a.e0.d.d()) {
                d.a.q0.a.h0.e.b.b();
            }
            d.a.q0.a.c1.a.D().e(d.a.q0.a.a2.e.Q() != null ? d.a.q0.a.a2.e.Q().D() : "");
        }
    }

    public final boolean s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            d.a.q0.a.a2.n.g gVar = this.L0;
            return gVar != null && gVar.f46733h;
        }
        return invokeV.booleanValue;
    }

    public boolean t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            d.a.q0.a.a2.n.g gVar = this.L0;
            if (gVar != null) {
                return TextUtils.equals(gVar.j, SchedulerSupport.CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.a.h0.g.d
    public void u1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            if (!d.a.q0.a.a2.n.g.f(this.L0)) {
                super.u1(i2);
                return;
            }
            v1(i2, t3() ? true : true ^ f0.h(this.k0));
            A3();
        }
    }

    public final boolean u3(d.a.q0.a.h0.g.g gVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048640, this, gVar, swanAppConfigData)) == null) {
            d.a.q0.a.h0.g.d j = gVar.j(0);
            if (j == null || !(j instanceof f)) {
                return false;
            }
            String h2 = ((f) j).Z2().h();
            return swanAppConfigData.q(h2) || TextUtils.equals(swanAppConfigData.e(), h2);
        }
        return invokeLL.booleanValue;
    }

    public final boolean v3() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            d.a.q0.a.h0.g.g J1 = J1();
            if (J1 == null) {
                return false;
            }
            d.a.q0.a.a2.n.g gVar = this.L0;
            if ((gVar != null && gVar.k) || (s = d.a.q0.a.g1.f.V().s()) == null) {
                return false;
            }
            return !u3(J1, s);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void w0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, activity) == null) {
            super.w0(activity);
            if (R0) {
                Log.d("SwanAppFragment", "onAttach() obj: " + this);
            }
        }
    }

    public final boolean w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            SwanAppConfigData s = d.a.q0.a.g1.f.V().s();
            return (s == null || TextUtils.equals(s.e(), this.D0.h())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean x3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, str)) == null) ? (this.F0.isEmpty() || this.F0.get(str) == null) ? false : true : invokeL.booleanValue;
    }

    public void y3(d.a.q0.a.j2.p.g gVar) {
        d.a.q0.a.j2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048645, this, gVar) == null) || (aVar = this.C0) == null) {
            return;
        }
        d.a.q0.a.j2.k.i(aVar, gVar);
        this.C0 = null;
    }
}
